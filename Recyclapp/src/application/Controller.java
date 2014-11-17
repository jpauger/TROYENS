
package application;
import domaine.*;
import utilitaires.*;
import recyclapp.gui.FenetrePrincipale;

/**
 *
 * @author TROYENS
 */
public class Controller {
    
    FenetrePrincipale fenetre ;
    Station station ;
    public PlanDeTravail plan;
    public boolean btnAjoutConvoyeurClicked = false ;
    
    public Controller()
    {
        plan = new PlanDeTravail();
    }
       
    void enregistrer(){}
    void importer(){}
    void annuler(){}
    void refaire(){}
    
    void afficherFenetreEntreeUsine(EntreeUsine entreUsine){}
    void afficherFenetreSelection (Equipement equipement){}
    void afficherFenetreMatriceTransformation(Station station){}
    
    public void ajouterStation(Coordonnee coordonnees)
    {
        plan.ajouterStation(coordonnees);
    }
    
    void ajouterEntreeUsine(Coordonnee coordonnees){}
    void ajouterSortieUsine(Coordonnee coordonnees){}
    void ajouterJonction(Coordonnee coordonnees){}
    
    void ajouterConvoyeur(SortieEquipement sortie, Equipement equipementFinal)
    {
        plan.ajouterConvoyeur(sortie, equipementFinal);
    }
    
    void validerPlan()
    {
        plan.validerPlan();
    }
    
    public Equipement obtenirEquipement(Coordonnee coordonnee)
    {
        return plan.obtenirEquipement(coordonnee);
    }
    
    public void relocaliserStation (Equipement equipement, Coordonnee coorArrivee)
    {
        plan.relocaliserStation(equipement,coorArrivee);
    }
    
    public void supprimerStation(Equipement equipement)
    {
        plan.supprimerStation(equipement);
    }
    
    
    SortieEquipement obtenirSortieVide()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        SortieEquipement sortie = null;
        return sortie;
    }
    
    void rendreGrilleMagnetique(){}
    void afficherModeImage(){}
    
}
