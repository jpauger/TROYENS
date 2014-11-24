package domaine;
import utilitaires.*;
import java.util.ArrayList;

/**
 *
 * @author TROYENS
 */
public class PlanDeTravail {
    
    public ArrayList<Equipement> listeEquipement = new ArrayList();
    public ArrayList<Convoyeur> listeConvoyeur = new ArrayList();
    public boolean estMagnetique = false;
    public boolean estAfficheImage = false;
    public Coordonnee coord_camera = new Coordonnee(-420,-300);
    public final int zoom_values[] = new int []{1,2,4,10};
    public int zoom = 2;
    
    
    
    //constructeur de la classe plan de travail
    public PlanDeTravail ()
    {
    }
    
    
    public void ajouterStation (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        Station nouvelleStation = new Station(coord);
        listeEquipement.add(nouvelleStation);
    }
    
    public void ajouterStation(Coordonnee coordonnee, int nombreSorties)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        Station nouvelleStation = new Station(coord);
        for (int i = 1; i< nombreSorties; i++)
        {
            nouvelleStation.ajouterSortie();
        }
        listeEquipement.add(nouvelleStation);
    }
    
    public void supprimerStation (Equipement unEquipement)
    {
        for(int i=0;i<listeEquipement.size();i++)
        {
            Equipement equipement = listeEquipement.get(i);
            if(equipement.estSurEquipement(coordonneeCliqueSurPlan(unEquipement.coordonnees)))
                listeEquipement.remove(i);
        }
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
    }
    
    
    public void ajouterEntreeUsine (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
       EntreeUsine nouvelleEntreeUsine = new EntreeUsine(coord);
       listeEquipement.add(nouvelleEntreeUsine);
    }
    
    public void ajouterSortieUsine (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        SortieUsine nouvelleSortieUsine = new SortieUsine(coord);
        listeEquipement.add(nouvelleSortieUsine);
    }
    
    public void ajouterJonction (Coordonnee coordonnee)
    {
        Coordonnee coord = coordonneeCliqueSurPlan(coordonnee);
        if(estMagnetique)
            coord = coordonneeMagnetique(coord);
        Jonction nouvelleJonction = new Jonction(coord);
        listeEquipement.add(nouvelleJonction);
    }
    
    public void ajouterConvoyeur (SortieEquipement sortie, Equipement equipement)
    {
        if (! sortie.estConnecte())
        {
            Convoyeur nouveauConvoyeur = new Convoyeur(sortie, equipement);
            listeConvoyeur.add(nouveauConvoyeur);
            sortie.setEstConnecte(true);
            System.out.println("convoyeur ajouté");

            if(sortie.equipementMere() instanceof Jonction)
            {
                sortie.equipementMere().augmenterNbSorties();
            }
        }
 
    }
    
    public void supprimerConvoyeur (SortieEquipement sortie, Equipement equipement)
    {
        //TODO : a implementer
    }
    
    public void validerPlan(){}
    
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
    
    private Coordonnee coordonneeMagnetique(Coordonnee coord)
    {
        coord.setX(coord.getX()+32);
        coord.setY(coord.getY()+32);
        int dif = (coord.getX()+coord_camera.getX())%40;
        if(dif != 0)
        {
            if(dif < 20)
                coord.setX(coord.getX()-dif);
            else
                coord.setX(coord.getX()+dif);
        }
        
        dif = (coord.getY()+coord_camera.getY())%40;
        if(dif != 0)
        {
            if(dif < 20)
                coord.setY(coord.getY()-dif);
            else
                coord.setY(coord.getY()+dif);
        }
        
        coord.setX(coord.getX()-32-20);
        coord.setY(coord.getY()-32-20);
                        
        return coord;        
    }
}
