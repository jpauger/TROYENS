package domaine;
import java.awt.Point;
//import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import utilitaires.Coordonnee;


/**
 *
 * @author TROYENS
 */
public class Station extends Equipement  {
    
    public String nomStation = "" ;
    //private final Point position = new Point(0,0);
    //private Point start_drag ;
    //private Point start_loc ;
    
    //private Point decalage ;
    public double capaciteMax ;
    public String description ;
    public ImageIcon image;
//    Color couleur ;
    
    
    MatriceTransformation matriceTransformation ;
    
    //constructeur
    public Station (Coordonnee coordonnees)
    {
        super.coordonnees = coordonnees;
        // on initialise les propiétés d'une station
        this.nomStation = "nomStation";
        this.description = "descriptionStation";
        this.capaciteMax = 1000;
        this.nombreSorties = 3;
        /*this.setSize(d);
        this.setPreferredSize(d);
        this.setToolTipText("STATION");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setVisible(true);*/
        this.image = new ImageIcon("src/ico/station3moyen.png");
        
        //on rajoute les "Listener"
        /*this.addMouseListener(this);
        this.addMouseMotionListener(this);*/
    }
    
    //Constructeur sans parametres
    public Station ()
    {
        
        this.nomStation = "nomStation";
        this.image = new ImageIcon("src/ico/station3moyen.png");
        this.coordonnees.setX(0);
        this.coordonnees.setY(0);
        
    }
    
    public Coordonnee obtenirCoordonnees ()
    {
        return this.coordonnees;
    }
    
    //TODO : La gestion du drag and drop doit etre dans la classe InterfacePrincipale/InterfacePlan
    //ici on surcharge les methodes des Listeners       
    /*@Override
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
    public void mouseMoved(MouseEvent e){}*/
     
    
    void definirNombreSorties(int nouveauNbSorties)
    {
        super.nombreSorties = nouveauNbSorties;
    }
    
    void majQuantiteSorties(){};    
 
    
    
 
    
    
    //methode pour obtenir la position en tenant compte de la position de la sourie
    /*private Point obtenirLocation(MouseEvent evt)
    {
        Point cursor = evt.getPoint();
        Point target_location = this.getLocationOnScreen();
        return new Point((int)(target_location.getX() + cursor.getX()), (int)(target_location.getY() + cursor.getY()) );
    }*/
        
}
