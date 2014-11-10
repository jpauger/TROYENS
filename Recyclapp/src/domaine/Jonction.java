package domaine;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author TROYENS
 */
public class Jonction extends Equipement {
    
    Color couleur;
    void incrementerNombreEntree(){}
    
            //ici on surcharge les methodes des Listeners       
    @Override
    public void mouseClicked(MouseEvent e)
    {
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
    }
    
    @Override
    public void mouseDragged (MouseEvent e)
    {
    }
       
    @Override
    public void mouseReleased (MouseEvent e)
    {
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        this.setBorder(null);
    }
    
    @Override
    public void mouseMoved(MouseEvent e){}
    
}
