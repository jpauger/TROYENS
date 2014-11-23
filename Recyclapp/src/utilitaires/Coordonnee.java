
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
    
    public boolean estSurLigne(CoordonneeLigne ligne)
    {
        boolean estSurLigne = false ;
        System.out.print("X1 : ");
        System.out.println(ligne.getX1());
        System.out.print("Y1 : ");
        System.out.println(ligne.getY1());
        System.out.print("X2 : ");
        System.out.println(ligne.getX2());
        System.out.print("Y2 : ");
        System.out.println(ligne.getY2());
        System.out.print("X3 : ");
        System.out.println(this.getX());
        System.out.print("Y3 : ");
        System.out.println(this.getY());
        
        // calcul du déterminant AB, AC
        int ACx = this.getX() - ligne.getX1();
        int ACy = this.getY() - ligne.getY1();
        int ABx = ligne.getX2() - ligne.getX1();
        int ABy = ligne.getY2() - ligne.getY1();
        
        int determinant = ACx*ABy - ABx*ACy ;
        System.out.print("produit determinant : ");
        System.out.println(determinant);
        
        
        // calcul du produit scalaire
        int CAx = ligne.getX1() - this.getX();
        int CAy = ligne.getY1() - this.getY();
        int CBx = ligne.getX2() - this.getX();
        int CBy = ligne.getY2() - this.getY();
        
        int produitScalaire = CAx*CBx + CAy*CBy ;
        System.out.print("produit scalaire : ");
        System.out.println(produitScalaire);
        
        // si le determinant est nul et que le produit scalaire est negatif ou nul le point appartient au segment
        if ( (determinant == 0) && ( produitScalaire <= 0) )
        {
            estSurLigne = true ;
            System.out.println("Click sur convoyeur");
        }
        else 
        {
            System.out.println("pas sur convoyeur");
        }
        
        
        return estSurLigne ;
    }
}
