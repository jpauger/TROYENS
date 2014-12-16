
package utilitaires;

import java.awt.geom.Line2D;


/**
 *
 * @author TROYENS
 */
public class Coordonnee implements java.io.Serializable {
    
    private int x ;
    private int y ;

    
    // constructeur
    public Coordonnee (int abscisse, int ordonnee)
    {
        this.x = abscisse;
        this.y = ordonnee;
    }
    
    //consructeur sans arguments
    public Coordonnee()
    {
        this.x = 0;
        this.y = 0;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setX(int abscisse)
    {
        this.x = abscisse ;
    }
    
    public void setY(int ordonnee)
    {
        this.y = ordonnee ;
    }
    
    public boolean compareTo(Coordonnee coord)
    {
        boolean comparaison = false ;
        
        if ( (this.getX()== coord.getX()) && (this.getY()== coord.getY()))
            comparaison = true ;
        
        return comparaison ;
    }
    
    /*
    * verifie si les coordonnees se situent sur une Ligne ou très proche...
    */
    public boolean estSurLigne(CoordonneeLigne uneLigne)
    {
        
        boolean estSurLigne = false ;
        
        Line2D.Double ligne = new Line2D.Double(uneLigne.getX1()*1.0, uneLigne.getY1()*1.0 , uneLigne.getX2()*1.0 , uneLigne.getY2()*1.0 );
        
        double X = this.getX()*1.0;
        double Y = this.getY()*1.0;
        double distance = ligne.ptSegDist(X, Y);
        
        // on accepte un ecart de 15 pixels
        if (distance < 5)
        {
            estSurLigne = true ;
        }
        
        return estSurLigne ;
    }
}
