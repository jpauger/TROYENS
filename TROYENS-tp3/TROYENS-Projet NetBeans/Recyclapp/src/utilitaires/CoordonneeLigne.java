package utilitaires;

/**
 *
 * @author TROYENS
 */
public class CoordonneeLigne {
    
    private final int X1 ;
    private final int Y1 ;
    private final int X2 ;
    private final int Y2 ; 
    
    public CoordonneeLigne (int point1X , int point1Y, int point2X, int point2Y)
    {
        X1 = point1X;
        Y1 = point1Y;
        X2 = point2X;
        Y2 = point2Y;
    }
    
    public int getX1 () { return X1; }
    public int getY1 () { return Y1; }
    public int getX2 () { return X2; }
    public int getY2 () { return Y2; }
 
}
