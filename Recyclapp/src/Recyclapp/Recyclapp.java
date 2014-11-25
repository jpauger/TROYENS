/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclapp;
import javax.swing.UIManager;

/**
 *
 * @author De Bayzer
 */
public class Recyclapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            recyclapp.gui.FenetrePrincipale fenetrePrincipale = new recyclapp.gui.FenetrePrincipale();
            fenetrePrincipale.setVisible(true);
        }
        catch(Exception e){e.printStackTrace();}
        
    }
    
}
