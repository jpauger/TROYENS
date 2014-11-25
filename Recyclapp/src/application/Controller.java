
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
    
    public void ajouterStation(Coordonnee coordonnees, int nombreSorties)
    {
        plan.ajouterStation(coordonnees, nombreSorties);
    }
    
    public void ajouterEntreeUsine(Coordonnee coordonnees)
    {
        plan.ajouterEntreeUsine(coordonnees);
    }
    public void ajouterSortieUsine(Coordonnee coordonnees)
    {
        plan.ajouterSortieUsine(coordonnees);
    }
    
    public void ajouterJonction(Coordonnee coordonnees)
    {
        plan.ajouterJonction(coordonnees);
    }
    
    public void ajouterConvoyeur(SortieEquipement sortie, Equipement equipementFinal)
    {
        plan.ajouterConvoyeur(sortie, equipementFinal);
    }
    
    void validerPlan()
    {
        plan.validerPlan();
    }
    
    public Convoyeur obtenirConvoyeurSelectionne()
    {
        return plan.obtenirConvoyeurSelectionne();
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
    
    public void raffraichirPlan()
    {
        this.fenetre.panneauPlanTravailExt.RafraichirPlan();
    }
    void rendreGrilleMagnetique(){}
    void afficherModeImage(){}
    
    public void moveCamera(int x, int y)
    {
        plan.moveCamera(x,y);
    }
    
    public Coordonnee coordonneeRelative(Coordonnee coordonnee)
    {
        return plan.coordonneeRelative(coordonnee);
    }
    
    public Coordonnee coordonneeCliqueSurPlan(Coordonnee coordonnee)
    {
        return plan.coordonneeCliqueSurPlan(coordonnee);
    }
    
    public void changerZoom(int nouveauZoom)
    {
        plan.changerZoom(nouveauZoom);
    }
    public void MettreAJourQuantiteTous()
    {
        plan.MettreAJourQuantiteTous();
    }
    
    public void centrerCamera()
    {
        plan.centrerCamera();
    }
}
