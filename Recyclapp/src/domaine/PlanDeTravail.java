package domaine;
import utilitaires.*;
import javax.swing.JPanel;
import java.awt.Point;

/**
 *
 * @author TROYENS
 */
public class PlanDeTravail {
    
    private JPanel conteneur ;
    boolean estMagnetique = false;
    boolean estAfficheImage = false;
    int zoom = 100 ;
    
    //constructeur de la classe plan de travail
    public PlanDeTravail (JPanel jpanel)
    {
        this.conteneur = jpanel;
    }
    
    public void ajouterStation ()
    {
        Station nouvelleStation = new Station();
        // pour la location on defini une location aléatoire mais qui se situe bien dans la zonne du conteneur
        nouvelleStation.setLocation(numeroAleatoire(this.conteneur.getWidth() - nouvelleStation.getWidth()), numeroAleatoire(this.conteneur.getHeight()-nouvelleStation.getHeight()));
        // on ajoute l'objet au JPanel
        this.conteneur.add(nouvelleStation);
        // on actualise le graphique
        this.conteneur.repaint();
    }
    
    
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
    
    
    /* Cette fonction retourne une valeur aléatoire entre 0 et le numero passé en parametre
    *@param int valeur un entier
    */
    public int numeroAleatoire(int valeur)
    {
        int num = (int) Math.floor(Math.random()*valeur+1);
        return num;
    }
       
}
