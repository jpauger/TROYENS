
package utilitaires;

/**
 *
 * @author TROYENS
 */
public class Coordonnee {
    
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
}
