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
    boolean estMagnetique = false;
    boolean estAfficheImage = false;
    public Coordonnee coord_camera = new Coordonnee(0,0);
    public final int zoom_values[] = new int []{5,10,20,40};
    public int zoom = 2;
    
    
    
    //constructeur de la classe plan de travail
    public PlanDeTravail ()
    {
    }
    
    
    public void ajouterStation (Coordonnee coordonnee)
    {
        Station nouvelleStation = new Station(coordonneeCliqueSurPlan(coordonnee));
        listeEquipement.add(nouvelleStation);
    }
    
    public void ajouterStation(Coordonnee coordonnee, int nombreSorties)
    {
        Station nouvelleStation = new Station(coordonneeCliqueSurPlan(coordonnee));
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
                equipement.coordonnees = coorArrivee;
            }
        }
    }
    
    
    public void ajouterEntreeUsine (Coordonnee coordonnee)
    {
       EntreeUsine nouvelleEntreeUsine = new EntreeUsine(coordonneeCliqueSurPlan(coordonnee));
       listeEquipement.add(nouvelleEntreeUsine);
    }
    
    public void ajouterSortieUsine (Coordonnee coordonnee)
    {
        SortieUsine nouvelleSortieUsine = new SortieUsine(coordonneeCliqueSurPlan(coordonnee));
        listeEquipement.add(nouvelleSortieUsine);
    }
    
    public void ajouterJonction (Coordonnee coordonnee)
    {
        Jonction nouvelleJonction = new Jonction(coordonneeCliqueSurPlan(coordonnee));
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
        coord_camera.setX(coord_camera.getX()+x*(40/zoom));    
        coord_camera.setY(coord_camera.getY()+y*(40/zoom));
    }
    
    public Coordonnee coordonneeRelative(Coordonnee coordonnee)
    {
        Coordonnee c = new Coordonnee(coordonnee.getX()-coord_camera.getX(), coordonnee.getY()-coord_camera.getY());
        return c;
    }
    
    private Coordonnee coordonneeCliqueSurPlan(Coordonnee coordonnee)
    {
        Coordonnee c = new Coordonnee(coordonnee.getX()+coord_camera.getX(), coordonnee.getY()+coord_camera.getY());
        return c;
    }
}
