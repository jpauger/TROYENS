package domaine;
import java.awt.Point;
//import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;


/**
 *
 * @author TROYENS
 */
public class Station extends Equipement  {
    
    private String nomStation = "" ;
    private final Point position = new Point(0,0);
    private Point start_drag ;
    private Point start_loc ;
    private final Dimension d = new Dimension(70,70);
    private Point decalage ;
    private int nbSorties = 1;
    private int nouveau_X;
    private int nouveau_Y;
    private double capaciteMax ;
    private String description ;
//    Color couleur ;
    
    
    MatriceTransformation matriceTransformation ;
    
    //constructeur
    public Station ()
    {
        // on initialise les propiétés d'une station
        this.setLocation(position);
        this.setText(nomStation);
        this.setSize(d);
        this.setPreferredSize(d);
        this.setToolTipText("STATION");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setVisible(true);
        this.setIcon(new ImageIcon("src/ico/station3moyen.png"));
        
        //on rajoute les "Listener"
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    //ici on surcharge les methodes des Listeners       
    @Override
    public void mouseClicked(MouseEvent e)
    {
        // ???
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        this.start_drag = obtenirLocation(e);
        this.start_loc = this.getLocation();
        
    }
    
    @Override
    public void mouseDragged (MouseEvent e)
    {
        Point current = this.obtenirLocation(e);
        decalage = new Point ((int) current.getX() - (int)start_drag.getX(), (int)current.getY() - (int)start_drag.getY() );
        Point new_location = new Point ((int)(this.start_loc.getX() + decalage.getX()),(int)(this.start_loc.getY() + decalage.getY())     );
        this.setLocation(new_location);
    }
       
    @Override
    public void mouseReleased (MouseEvent e)
    {
        nouveau_X = (this.getLocation().x);
        nouveau_Y = (this.getLocation().y);
        this.setLocation(nouveau_X, nouveau_Y);
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        this.setBorder(null);
    }
    
    @Override
    public void mouseMoved(MouseEvent e){}
    
    
    
    // LES METHODES POUR MODIFIER LES PARAMATRES D'UNE STATION
    
    
    void definirNombreSorties(int nouveauNbSorties)
    {
        this.nbSorties = nouveauNbSorties;
    }
    
    void majQuantiteSorties(){};
    
    
    void definirImage(ImageIcon image)
    {
        this.setIcon(image);
    }
    
    void changerNomStation (String nvNom)
    {
        this.nomStation = nvNom;
    }
    
    void changerCapaciteMax (double nvCapaciteMax)
    {
        this.capaciteMax = nvCapaciteMax;
    }
    
    void changerDescription (String nvDescription)
    {
        this.description = nvDescription;
    }
    
    // LES METHODES POUR OBTENIR LES PARAMETRES D'UNE STATION
    
 
    
    
    //methode pour obtenir la position en tenant compte de la position de la sourie
    private Point obtenirLocation(MouseEvent evt)
    {
        Point cursor = evt.getPoint();
        Point target_location = this.getLocationOnScreen();
        return new Point((int)(target_location.getX() + cursor.getX()), (int)(target_location.getY() + cursor.getY()) );
    }
        
}
