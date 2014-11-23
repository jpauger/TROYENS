package domaine;

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
       SortieEquipement sortieEquipement = new SortieEquipement((Equipement)this, 0);
       sortieEquipement.listeLigneProduit.add(new LigneProduit(new Produit("Bois"),1000));
       sortieEquipement.listeLigneProduit.add(new LigneProduit(new Produit("Metal"),1000));
       this.listeSorties.add(sortieEquipement);  
    }
    void ajouterLigneProduit (int quantite ,Produit produit ){}
   
}
