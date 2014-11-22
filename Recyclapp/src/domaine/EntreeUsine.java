package domaine;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import utilitaires.Coordonnee;

/**
 *
 * @author TROYENS
 */
public class EntreeUsine extends Equipement {
    
     public EntreeUsine (Coordonnee coordonnees)
     {
        super.coordonnees = coordonnees;          
        this.image = new ImageIcon("src/ico/light/appbar.door.enter.png");
        this.listeSorties.add(new SortieEquipement((Equipement)this, 0));
        
        
     }
    void ajouterLigneProduit (int quantite ,Produit produit ){}
   
}
