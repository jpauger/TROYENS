
package application;
import domaine.*;
import utilitaires.*;

/**
 *
 * @author TROYENS
 */
public class Controller {
    
    void enregistrer(){}
    void importer(){}
    void annuler(){}
    void refaire(){}
    
    void afficherFenetreEntreeUsine(EntreeUsine entreUsine){}
    void afficherFenetreSelection (Equipement equipement){}
    void afficherFenetreMatriceTransformation(Station station){}
    
    void ajouterStation(Coordonnee coordonnees){}
    void ajouterEntreeUsine(Coordonnee coordonnees){}
    void ajouterSortieUsine(Coordonnee coordonnees){}
    void ajouterJonction(Coordonnee coordonnees){}
    void ajouterConvoyeur(SortieEquipement equipementInitial, Equipement equipementFinal){}
    
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
    
    void rendreGrilleMagnetique(){}
    void afficherModeImage(){}
    
}
