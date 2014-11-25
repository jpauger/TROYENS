package utilitaires;
import domaine.*;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;


/**
 *
 * @author TROYENS
 */
public class ligneConvoyeur extends JComponent {
    
    public PlanDeTravail plan;

    public ligneConvoyeur(PlanDeTravail plan)
    {
        this.plan = plan ;
    }
    
    public void dessinerConvoyeurs(Graphics g)
    {
        
        for (int i=0; i<plan.listeConvoyeur.size(); i++)
        {
            int coordX1 = plan.listeConvoyeur.get(i).coorDepartX();
            int coordY1 = plan.listeConvoyeur.get(i).coorDepartY();
            
            int coordX2 = plan.listeConvoyeur.get(i).coorArriveeX();
            int coordY2 = plan.listeConvoyeur.get(i).coorArriveeY();
            
            Graphics2D convoyeur = (Graphics2D) g;
            convoyeur.drawLine(coordX1, coordY1, coordX2, coordY2);    
        } 
    }
            
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        dessinerConvoyeurs(g);
    }
    
}
