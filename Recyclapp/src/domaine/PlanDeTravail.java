package domaine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import utilitaires.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRelation;

/**
 *
 * @author TROYENS
 */
public class PlanDeTravail implements java.io.Serializable {
    
    public ArrayList<Equipement> listeEquipement = new ArrayList();
    public ArrayList<Convoyeur> listeConvoyeur = new ArrayList();
    public boolean estMagnetique = false;
    public boolean estAfficheImage = false;
    public Coordonnee coord_camera = new Coordonnee(-420,-300);
    transient public final int zoom_values[] = new int []{1,2,4,10};
    public int zoom = 2;
    transient public String erreursValidation = "";
    transient private ArrayList<PlanDeTravail> etats = new ArrayList();
    transient private int etatPresent = 0;
    
    
    
    //constructeur de la classe plan de travail
    public PlanDeTravail ()
    {
    }
    
    
    public void ajouterStation (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        Station nouvelleStation = new Station(coord,1);
        listeEquipement.add(nouvelleStation);
        ajouterEtat();
    }
    
    public void ajouterStation(Coordonnee coordonnee, int nombreSorties)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        Station nouvelleStation = new Station(coord, nombreSorties);
        listeEquipement.add(nouvelleStation);
        ajouterEtat();
    }
    
    public void supprimerStation (int equip)
    {
        Equipement equipement = listeEquipement.get(equip);
        
        for(int i = 0; i < equipement.listeSortieEntrante.size(); i++)
        {   
            equipement.listeSortieEntrante.remove(i);
            i--;
        System.out.println("On supprime "+equipement.nom);
        }
        for(int i = 0; i < equipement.listeSorties.size(); i++)
        {   
            equipement.listeSorties.remove(i);
            i--;
        System.out.println("On supprime "+equipement.nom);
        }
        for(int i = 0; i < listeEquipement.size(); i++)
        {
            for(int j = 0; j < listeEquipement.get(i).listeSortieEntrante.size(); j++)
            {
                if(listeEquipement.get(i).listeSortieEntrante.get(j).equipementMere() == equipement)
                {
                    listeEquipement.get(i).entreeOccupee = false;
                    listeEquipement.get(i).listeSortieEntrante.remove(j);
                    j--;
                }
            }
        }
        
        for(int i =0; i<listeConvoyeur.size();i++)
        {
            if(listeConvoyeur.get(i).equipement == equipement)
            {
                listeConvoyeur.get(i).sortie.setEstConnecte(false);
                listeConvoyeur.remove(i);
            }
        }
        
        for(int i=0; i<listeConvoyeur.size();i++)
         {
             if(listeConvoyeur.get(i).sortie.equipementMere() == equipement)      
             {
                 //libérer la sortie qui de la station
                 listeConvoyeur.get(i).sortie.setEstConnecte(false);
                 listeConvoyeur.remove(i);
                 i--;
             }
         }
        listeEquipement.remove(equipement);
        ajouterEtat();
    }
    
    public void supprimerConvoyeur()
    {
        int index = -1;
        
        for (Convoyeur convoyeur : listeConvoyeur)
        {
            if (convoyeur.estSelectionne)
            {
                index = listeConvoyeur.indexOf(convoyeur);
            }
        }
        
        if (index != -1)
        {
            listeConvoyeur.get(index).sortie.setEstConnecte(false);
            listeConvoyeur.get(index).equipement.entreeOccupee = false ;
            listeConvoyeur.remove(index);
        }
        ajouterEtat();
    }
    
    
    //deplace une station prise en paramettre vers de nouvelles coordonnées prise en parametre
    public void relocaliserStation (Equipement unEquipement, Coordonnee coorArrivee)
    {
        for (Equipement equipement : listeEquipement)
        {
            if ( equipement.coordonnees == unEquipement.coordonnees)
            {
                if(estMagnetique)
                    coorArrivee = coordonneeMagnetique(coorArrivee);
                equipement.coordonnees = coorArrivee;
            }
        }
        ajouterEtat();
    }
    
    public void redefinirMatriceStations()
    {
        for(int i=0;i<listeEquipement.size();i++)
        {
            if((listeEquipement.get(i)) instanceof Station)
                ((Station)listeEquipement.get(i)).definirMatriceBase();
            MettreAJourQuantiteTous();
        }
        ajouterEtat();
    }
    
    public void ajouterEntreeUsine (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        EntreeUsine nouvelleEntreeUsine = new EntreeUsine(coord);
        listeEquipement.add(nouvelleEntreeUsine);
        ajouterEtat();
    }
    
    public void ajouterSortieUsine (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        SortieUsine nouvelleSortieUsine = new SortieUsine(coord);
        listeEquipement.add(nouvelleSortieUsine);
        ajouterEtat();
    }
    
    public void ajouterJonction (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        Jonction nouvelleJonction = new Jonction(coord);
        listeEquipement.add(nouvelleJonction);
        ajouterEtat();
    }
    
    public void ajouterConvoyeur (SortieEquipement sortie, Equipement equipement)
    {
        if (! sortie.estConnecte())
        {
            Convoyeur nouveauConvoyeur = new Convoyeur(sortie, equipement);
            listeConvoyeur.add(nouveauConvoyeur);
            sortie.setEstConnecte(true);
            System.out.println("convoyeur ajouté");
            MettreAJourQuantiteTous();

            if(sortie.equipementMere() instanceof Jonction)
            {
                sortie.equipementMere().augmenterNbSorties();
            }
        }
        ajouterEtat();
    }
    
    public void supprimerConvoyeur (SortieEquipement sortie, Equipement equipement)
    {
        //TODO : a implementer
        ajouterEtat();
    }
    
    public boolean validerPlan()
    {
        erreursValidation = "";
        for(int i = 0; i< listeEquipement.size();i++)
        {
            if(listeEquipement.get(i) instanceof EntreeUsine)
            {
                if(!((EntreeUsine)listeEquipement.get(i)).listeSorties.get(0).estConnecte())
                    erreursValidation += "Une entrée d'usine n'est pas connecté." + "\n";
            }
            if(listeEquipement.get(i) instanceof SortieUsine)
            {
                if(((SortieUsine)listeEquipement.get(i)).listeSortieEntrante.size() < 1)
                    erreursValidation += "Une sortie d'usine n'a pas d'entrée." + "\n";
            }
            if(listeEquipement.get(i) instanceof Jonction)
            {
                if(((Jonction)listeEquipement.get(i)).listeSorties.size() < 1)
                    erreursValidation += "Une jonction n'a pas de sortie." + "\n";
                if(((Jonction)listeEquipement.get(i)).listeSortieEntrante.size() < 2)
                    erreursValidation += "Une jonction n'a pas deux entrées." + "\n";
            }
            if(listeEquipement.get(i) instanceof Station)
            {
                if(((Station)listeEquipement.get(i)).listeSortieEntrante.size() < 1)
                    erreursValidation += "Une station n'a pas d'entrée." + "\n";
                for(int j=0; j<((Station)listeEquipement.get(i)).listeSorties.size(); j++)
                {
                    if(!((Station)listeEquipement.get(i)).listeSorties.get(j).estConnecte())
                        erreursValidation += "Une sortie de station n'est pas connecté." + "\n";
                }
                
                int capaciteEntrante=0;
                for(int j=0;j <((Station)listeEquipement.get(i)).listeSortieEntrante.size();j++)
                {
                    for(int k=0;k<((Station)listeEquipement.get(i)).listeSortieEntrante.get(j).listeLigneProduit.size();k++)
                    {
                        capaciteEntrante += ((Station)listeEquipement.get(i)).listeSortieEntrante.get(j).listeLigneProduit.get(k).quantite;
                    }
                }
                if(((Station)listeEquipement.get(i)).capaciteMax < capaciteEntrante)
                    erreursValidation += "Une station a dépassé sa capacité maximal." + "\n";
            }
        }
        for(int i = 0; i< listeConvoyeur.size();i++)
        {
            int capaciteEntrante=0;
            for(int j=0;j < listeConvoyeur.get(i).sortie.listeLigneProduit.size();j++)
            {
                capaciteEntrante += listeConvoyeur.get(i).sortie.listeLigneProduit.get(j).quantite;
            }
            if(capaciteEntrante > listeConvoyeur.get(i).capaciteMax)
                erreursValidation += "Un convoyeur a dépassé sa capacité maximal." + "\n";
        }
        return erreursValidation == "";
    }
    
    public Equipement obtenirEquipement(Coordonnee coordonnee)
    {
        for(int i=0;i<listeEquipement.size();i++)
        {
            Equipement equipement = listeEquipement.get(i);
            if(equipement.estSurEquipement(coordonneeCliqueSurPlan(coordonnee)))
            {
                return equipement;
            }
                
        }
        return null;
    }
    
    public Convoyeur obtenirConvoyeur(Coordonnee coordonnee)
    {
        for (int i=0; i<listeConvoyeur.size();i++)
        {
            Convoyeur convoyeur = listeConvoyeur.get(i);
            for (int nbPortions = 0 ; nbPortions < convoyeur.representation.listePortions.size(); nbPortions++)
            {
                PortionConvoyeur portion =listeConvoyeur.get(i).representation.listePortions.get(nbPortions);
                CoordonneeLigne coordonneesPortion = new CoordonneeLigne(portion.getPointDepart(),portion.getPointArrivee());
                if (coordonnee.estSurLigne(coordonneesPortion))
                {
                    return convoyeur;
                }
            }
        }
        
        return null ;
    }
    
    public PortionConvoyeur obtenirPortion (Coordonnee coordonnee)
    {
        for (int i=0; i<listeConvoyeur.size();i++)
        {
            for (int nbPortions = 0 ; nbPortions < listeConvoyeur.get(i).representation.listePortions.size(); nbPortions++)
            {
                PortionConvoyeur portion =listeConvoyeur.get(i).representation.listePortions.get(nbPortions);
                
                CoordonneeLigne coordonneesPortion = new CoordonneeLigne(portion.getPointDepart(),portion.getPointArrivee());
                
                if (coordonnee.estSurLigne(coordonneesPortion))
                {
                    return listeConvoyeur.get(i).representation.listePortions.get(nbPortions);
                }
            }
        }
        
        return null ;
    }
    
    public Convoyeur obtenirConvoyeurSelectionne()
    {
        for(int i=0;i<this.listeConvoyeur.size();i++)
        {
            if(listeConvoyeur.get(i).estSelectionne)
                return listeConvoyeur.get(i);
        }
        return null;
    }
    
    public int obtenirIndexConvoyeur (Coordonnee coordonnee)
    {
        int index = -1;
        for (int i=0; i<listeConvoyeur.size();i++)
        {
            for (int nbPortions = 0 ; nbPortions < listeConvoyeur.get(i).representation.listePortions.size(); nbPortions++)
            {
                PortionConvoyeur portion =listeConvoyeur.get(i).representation.listePortions.get(nbPortions);
                CoordonneeLigne coordonneesPortion = new CoordonneeLigne(portion.getPointDepart(),portion.getPointArrivee());
                if (coordonnee.estSurLigne(coordonneesPortion))
                {
                    index = i ;
                }
            }
        }
        
        return index ;
    }
    
    public int obtenirIndexConvoyeur (Convoyeur convoyeur)
    {
        return listeConvoyeur.indexOf(convoyeur);
    }
    
    public SortieEquipement obtenirSortieVide()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        SortieEquipement sortie = null;
        return sortie;
    }
    
    
    /* Cette fonction retourne une valeur aléatoire entre 0 et le numero passé en parametre
    *@param int valeur un entier
    */
    public int numeroAleatoire(int valeur)
    {
        int num = (int) Math.floor(Math.random()*valeur+1);
        return num;
    }
       
    public void moveCamera(int x, int y)
    {
        coord_camera.setX(coord_camera.getX()+x*20);    
        coord_camera.setY(coord_camera.getY()+y*20);
    }
    
    public Coordonnee coordonneeRelative(Coordonnee coordonnee)
    {
        Coordonnee c = new Coordonnee(coordonnee.getX()-coord_camera.getX(), coordonnee.getY()-coord_camera.getY());
        return c;
    }
    
    public Coordonnee coordonneeCliqueSurPlan(Coordonnee coordonnee)
    {
        Coordonnee c = new Coordonnee(coordonnee.getX()+coord_camera.getX(), coordonnee.getY()+coord_camera.getY());
        return c;
    }
    
    public void changerZoom(int nouveauZoom)
    {
        float ratio = (float)zoom_values[zoom]/zoom_values[nouveauZoom];
        Coordonnee centre = new Coordonnee(coord_camera.getX()+420,coord_camera.getY()+300);
        coord_camera.setX(coord_camera.getX()+420);
        coord_camera.setX((int)(Math.ceil(coord_camera.getX()*ratio)-420));
        coord_camera.setY(coord_camera.getY()+300);
        coord_camera.setY((int)(Math.round(coord_camera.getY()*ratio)-300));
        for(int i=0;i<listeEquipement.size();i++)
        {
            Equipement equipement = listeEquipement.get(i);
            equipement.coordonnees.setX(equipement.coordonnees.getX()+equipement.size.width/2);
            equipement.coordonnees.setX((int)(Math.ceil(equipement.coordonnees.getX()*ratio)-equipement.size.width/2));
            equipement.coordonnees.setY(equipement.coordonnees.getY()+equipement.size.height/2);
            equipement.coordonnees.setY((int)(Math.round(equipement.coordonnees.getY()*ratio)-equipement.size.height/2));
        }
        zoom = nouveauZoom;
    }
    
    public void MettreAJourQuantiteTous()
    {
        for(int i = 0;i<listeEquipement.size();i++)
        {
            Equipement equipement = listeEquipement.get(i);
            if(equipement instanceof Station )
            {
                ((Station)equipement).majQuantiteProduitSorties();
                ((Station)equipement).majQuantiteMatrice();
            }
            if (equipement instanceof EntreeUsine)
            {
                ((EntreeUsine)equipement).majPanier();
            }
            if(equipement instanceof Jonction)
                ((Jonction)equipement).calculerSortie();
        }
    }
    public String ObtenirTauxRecuperation(LigneProduit ligneProduit)
    {
        int quantiteTotal = 0;
        for(int i=0;i<listeEquipement.size();i++)
        {
            if(listeEquipement.get(i) instanceof EntreeUsine)
            {
                for(int j=0;j < listeEquipement.get(i).listeSorties.size();j++)
                {
                    for(int k =0 ; k < listeEquipement.get(i).listeSorties.get(j).listeLigneProduit.size();k++)
                    {
                        if(listeEquipement.get(i).listeSorties.get(j).listeLigneProduit.get(k).produit.nom == ligneProduit.produit.nom)
                            quantiteTotal += listeEquipement.get(i).listeSorties.get(j).listeLigneProduit.get(k).quantite;
                    }
                }
            }
        }
        float tauxRetourne = (float)ligneProduit.quantite / quantiteTotal * 100;
        return String.format("%.0f",tauxRetourne)  + "%";
    }
   private Coordonnee coordonneeMagnetique(Coordonnee coord)
    {
        int dif;
        coord.setX(coord.getX()+32);
        coord.setY(coord.getY()+32);
        
        dif = Math.abs(coord.getX()%40);
        if(dif != 0 && coord.getX() < 0)
        {
            if(dif < 20)
                coord.setX(coord.getX()+dif);
            else
                coord.setX(coord.getX()-(40-dif));
        }
        else if(dif != 0 && coord.getX() > 0)
        {
            if(dif < 20)
                coord.setX(coord.getX()-dif);
            else
                coord.setX(coord.getX()+(40-dif));
        }
        
        dif = Math.abs(coord.getY()%40);        
        if(dif != 0 && coord.getY() < 0)
        {
            if(dif < 20)
                coord.setY(coord.getY()+dif);
            else
                coord.setY(coord.getY()-(40-dif));
        }
        else if(dif != 0 && coord.getY() > 0)
        {
            if(dif < 20)
                coord.setY(coord.getY()-dif);
            else
                coord.setY(coord.getY()+(40-dif));
        }
        
        coord.setX(coord.getX()-32);
        coord.setY(coord.getY()-32);
                        
        return coord;       
    }
    
    public void centrerCamera()
    {
        coord_camera.setX(-420);
        coord_camera.setY(-300);
    }
    
    public void sauvegarderPlan(File f)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(f.getPath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    
    public void chargerPlan(File f)
    {
        PlanDeTravail e = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(f.getPath());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (PlanDeTravail) in.readObject();
            in.close();
            fileIn.close();
            
            listeEquipement = e.listeEquipement;
            listeConvoyeur = e.listeConvoyeur;
            estMagnetique = e.estMagnetique;
            estAfficheImage = e.estAfficheImage;
            coord_camera.setX(e.coord_camera.getX());
            coord_camera.setY(e.coord_camera.getY());
            zoom = e.zoom;
            ajouterEtat();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("PlanDeTravail class not found");
            c.printStackTrace();
        }
         
    }
    
    public void ajouterEtat()
    {        
        if(etatPresent < etats.size()-1)
        {
            for(int i = etatPresent+1; i < etats.size(); i++)
            {
                etats.remove(i);
                i--;
            }
        }
        if(etats.size() >= 10)
            etats.remove(0);
        
        
        PlanDeTravail e = null;
        
        String path = System.getProperty("user.dir").concat("/temp");
        try
        {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }catch(IOException i)
        {}
        
        try
        {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (PlanDeTravail) in.readObject();
        in.close();        
        fileIn.close();
        
        File f = new File(path);
        f.delete();
        }catch(IOException i)
        {} 
        catch (ClassNotFoundException ex) 
        {}
        System.out.println("État ajouté "+etats.size());
        etats.add(e);
        
        etatPresent = etats.size()-1;
    }
    
    public void changerEtat(int saut)
    {
        if(saut == -1 && etatPresent > 0)
        {
            etatPresent -= 1;
            chargerEtat();
        }
        else if(saut == 1 && etatPresent < etats.size()-1)
        {
            etatPresent += 1;
            chargerEtat();
        }
    }
    
    private void chargerEtat()
    {
        PlanDeTravail e = null;
        
        String path = System.getProperty("user.dir").concat("/temp");
        try
        {
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(etats.get(etatPresent));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {}
        
        try
        {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (PlanDeTravail) in.readObject();
        in.close();
        fileIn.close();
        
        File f = new File(path);
        f.delete();
        }catch(IOException i)
        {} 
        catch (ClassNotFoundException ex) 
        {}
        
        listeEquipement = e.listeEquipement;
        listeConvoyeur = e.listeConvoyeur;
        estMagnetique = e.estMagnetique;
        estAfficheImage = e.estAfficheImage;
        coord_camera.setX(e.coord_camera.getX());
        coord_camera.setY(e.coord_camera.getY());
        zoom = e.zoom;
    }
}
