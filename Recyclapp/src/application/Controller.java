
package application;
import domaine.*;
import java.io.File;
import utilitaires.*;
import recyclapp.gui.FenetrePrincipale;

/**
 *
 * @author TROYENS
 */
public class Controller {
    
    public FenetrePrincipale fenetre ;
    Station station ;
    public PlanDeTravail plan;
    public boolean btnAjoutConvoyeurClicked = false ;
    public boolean modeAjoutConvoyeurTermine = false;
    public int selection = -1;
    
    public Controller(FenetrePrincipale fenetre)
    {
        plan = new PlanDeTravail();
        this.fenetre = fenetre;
    }
       
    void enregistrer(){}
    void importer(){}
    void annuler(){}
    void refaire(){}
    
    void afficherFenetreEntreeUsine(EntreeUsine entreUsine){}
    void afficherFenetreSelection (Equipement equipement){}
    void afficherFenetreMatriceTransformation(Station station){}
    
    public void ajouterStation(Coordonnee coordonnees, int nombreSorties)
    {
        plan.ajouterStation(coordonnees, nombreSorties);
        validerPlan();
    }
    
    public void ajouterEntreeUsine(Coordonnee coordonnees)
    {
        plan.ajouterEntreeUsine(coordonnees);
        validerPlan();
    }
    public void ajouterSortieUsine(Coordonnee coordonnees)
    {
        plan.ajouterSortieUsine(coordonnees);
        validerPlan();
    }
    
    public void ajouterJonction(Coordonnee coordonnees)
    {
        plan.ajouterJonction(coordonnees);
        validerPlan();
    }
    
    public void ajouterConvoyeur(SortieEquipement sortie, Equipement equipementFinal)
    {
        plan.ajouterConvoyeur(sortie, equipementFinal);
        validerPlan();
    }
    
    public void validerPlan()
    {
        fenetre.changerCheckIcone(plan.validerPlan());
    }
    
    public String obtenirErreur()
    {
        return plan.erreursValidation;
    }
    public Convoyeur obtenirConvoyeurSelectionne()
    {
        return plan.obtenirConvoyeurSelectionne();
    }
    
    public Equipement obtenirEquipement(Coordonnee coordonnee)
    {
        return plan.obtenirEquipement(coordonnee);
    }
    
    public Convoyeur obtenirConvoyeur (Coordonnee coordonnee)
    {
        return plan.obtenirConvoyeur(coordonnee);
    }
    
    public PortionConvoyeur obtenirPortion(Coordonnee coordonnee)
    {
        return plan.obtenirPortion(coordonnee);
    }
    
    public int obtenirIndexConvoyeur(Coordonnee coordonnee)
    {
        return plan.obtenirIndexConvoyeur(coordonnee);
    }
    
    public int obtenirIndexConvoyeur(Convoyeur convoyeur)
    {
        return plan.obtenirIndexConvoyeur(convoyeur);
    }
    
    public void relocaliserStation (Equipement equipement, Coordonnee coorArrivee)
    {
        plan.relocaliserStation(equipement,coorArrivee);
    }
    
    public void supprimerStation()
    {        
        if(selection != -1)
            plan.supprimerStation(selection);
        selection = -1;
        validerPlan();
    }
    
    public void redefinirMatriceStations()
    {
        plan.redefinirMatriceStations();
    }
       
    SortieEquipement obtenirSortieVide()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        SortieEquipement sortie = null;
        return sortie;
    }
    public String ObtenirTauxRecuperation(LigneProduit ligneProduit)
    {
        return plan.ObtenirTauxRecuperation(ligneProduit);
    }
    
    public void raffraichirPlan()
    {
        this.fenetre.panneauPlanTravailExt.RafraichirPlan();
    }
    
    public void QuitterModeAjoutConvoyeur()
    {  
        this.modeAjoutConvoyeurTermine = true ;
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
        validerPlan();
    }
    
    public void centrerCamera()
    {
        plan.centrerCamera();
    }
    
    public void sauvegarderPlan(File f)
    {
        plan.sauvegarderPlan(f);
    }
    
    public void chargerPlan(File f)
    {
        plan.chargerPlan(f);
        validerPlan();
    }
    
    public void ajouterEtat()
    {
        plan.ajouterEtat();
    }
    
    public void changerEtat(int saut)
    {
        plan.changerEtat(saut);
    }
}
