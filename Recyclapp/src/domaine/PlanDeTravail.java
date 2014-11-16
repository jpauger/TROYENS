package domaine;
import utilitaires.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author TROYENS
 */
public class PlanDeTravail {
    
    public ArrayList<Equipement> listeEquipement = new ArrayList<Equipement>();
    public ArrayList<Convoyeur> listeConvoyeur = new ArrayList<Convoyeur>();
    boolean estMagnetique = false;
    boolean estAfficheImage = false;
    int zoom = 100 ;
    
    
    
    //constructeur de la classe plan de travail
    public PlanDeTravail ()
    {
    }
    
    public void supprimerToutes()
    {
        listeEquipement.clear();
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
       EntreeUsine nouvelleEntreeUsine = new EntreeUsine();
       coordonnee = nouvelleEntreeUsine.coordonnees;
       //nouvelleEntreeUsine.setLocation(numeroAleatoire(this.conteneur.getWidth() - nouvelleEntreeUsine.getWidth()), numeroAleatoire(this.conteneur.getHeight()-nouvelleEntreeUsine.getHeight()));
        // on ajoute l'objet au JPanel
        //this.conteneur.add(nouvelleEntreeUsine);
        // on actualise le graphique
        //this.conteneur.repaint();
    }
    
    public void ajouterSortieUsine (Coordonnee coordonnee)
    {
        SortieUsine nouvelleSortieUsine = new SortieUsine();
        coordonnee = nouvelleSortieUsine.coordonnees;
        //ouvelleSortieUsine.setLocation(numeroAleatoire(this.conteneur.getWidth() - nouvelleSortieUsine.getWidth()), numeroAleatoire(this.conteneur.getHeight()-nouvelleSortieUsine.getHeight()));
        // on ajoute l'objet au JPanel
        //this.conteneur.add(nouvelleSortieUsine);
        // on actualise le graphique
        //this.conteneur.repaint();
    }
    
    void ajouterJonction (Coordonnee coordonnee)
    {
        Jonction nouvelleJonction = new Jonction();
        coordonnee = nouvelleJonction.coordonnees;
        //nouvelleJonction.setLocation(numeroAleatoire(this.conteneur.getWidth() - nouvelleJonction.getWidth()), numeroAleatoire(this.conteneur.getHeight()-nouvelleJonction.getHeight()));
        // on ajoute l'objet au JPanel
       // this.conteneur.add(nouvelleJonction);
        // on actualise le graphique
        //this.conteneur.repaint();
    }
    
    void ajouterConvoyeur (SortieEquipement equipementInitial, Equipement equipement)
    {
        Convoyeur nouveauConvoyeur = new Convoyeur();
        equipementInitial = nouveauConvoyeur.sortie;
        equipement = nouveauConvoyeur.equipement;
        //nouveauConvoyeur.setLocation(numeroAleatoire(this.conteneur.getWidth() - nouveauConvoyeur.getWidth()), numeroAleatoire(this.conteneur.getHeight()-nouveauConvoyeur.getHeight()));
        // on ajoute l'objet au JPanel
        //this.conteneur.add(nouveauConvoyeur);
        // on actualise le graphique
        //this.conteneur.repaint();
    }
    
    void validerPlan(){}
    
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
