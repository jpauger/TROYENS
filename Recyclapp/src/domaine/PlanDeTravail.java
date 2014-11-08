package domaine;
import utilitaires.*;


/**
 *
 * @author TROYENS
 */
public class PlanDeTravail {
    
    boolean estMagnetique = false;
    boolean estAfficheImage = false;
    int zoom = 100 ;
    Coordonnee position ;
    
    void ajouterStation (Coordonnee coordonnee){}
    void ajouterEntreeUsine (Coordonnee coordonnee){}
    void ajouterSortieUsine (Coordonnee coordonnee){}
    void ajouterJonction (Coordonnee corrdonnee){}
    
    void ajouterConvoyeur (SortieEquipement equipementInitial, Equipement equipement){}
    
    void validerPlan(){}
    
    Equipement obtenirEquipement(Coordonnee coordonnee)
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        Equipement equipement = null;
        return equipement;
    }
    
    SortieEquipement obtenirSortieVide()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        SortieEquipement sortie = null;
        return sortie;
    }
       
}
