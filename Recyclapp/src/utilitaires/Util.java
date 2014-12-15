
package utilitaires;
import domaine.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author TROYENS
 */
public class Util {
    
    void enregistrer(PlanDeTravail plan){}
    void importer (String cheminFichier){}
    
    public static String recupChaineOptionPane (String titre, String message)
    {
        
        JFrame frame = new JFrame(titre);
        String chaine = JOptionPane.showInputDialog(frame,message);
        
        return chaine ;
    }
}
