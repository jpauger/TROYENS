package domaine;

import javax.swing.ImageIcon;
import utilitaires.Coordonnee;

/**
 *
 * @author TROYENS
 */
public class SortieUsine extends Equipement {
    
    public SortieUsine (Coordonnee coordonnees)
    {
        nom = "Sortie d'usine";
       super.coordonnees = coordonnees;          
       this.image = new ImageIcon(getClass().getResource("/ico/light/appbar.door.leave.png"));
       
       this.listeSorties.add(new SortieEquipement((Equipement)this, 0));
       this.listeSorties.get(0).setEstConnecte(true);
    }  
    
}
