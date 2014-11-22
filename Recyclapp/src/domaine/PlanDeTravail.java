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
    int zoom = 100 ;
    
    
    
    //constructeur de la classe plan de travail
    public PlanDeTravail ()
    {
    }
    
    
    public void ajouterStation (Coordonnee coordonnee)
    {
        Station nouvelleStation = new Station(coordonnee);
        listeEquipement.add(nouvelleStation);
    }
    
    public void supprimerStation (Equipement unEquipement)
    {
        for(int i=0;i<listeEquipement.size();i++)
        {
            Equipement equipement = listeEquipement.get(i);
            if(equipement.estSurEquipement(unEquipement.coordonnees))
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
       EntreeUsine nouvelleEntreeUsine = new EntreeUsine(coordonnee);
       listeEquipement.add(nouvelleEntreeUsine);
    }
    
    public void ajouterSortieUsine (Coordonnee coordonnee)
    {
        SortieUsine nouvelleSortieUsine = new SortieUsine();
        coordonnee = nouvelleSortieUsine.coordonnees;
    }
    
    public void ajouterJonction (Coordonnee coordonnee)
    {
        Jonction nouvelleJonction = new Jonction(coordonnee);
        listeEquipement.add(nouvelleJonction);
    }
    
    public void ajouterConvoyeur (SortieEquipement sortie, Equipement equipement)
    {
        Convoyeur nouveauConvoyeur = new Convoyeur(sortie, equipement);
        listeConvoyeur.add(nouveauConvoyeur);
        sortie.setEstConnecte(true);
        System.out.println("convoyeur ajouté");
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
            if(equipement.estSurEquipement(coordonnee))
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
       
}
