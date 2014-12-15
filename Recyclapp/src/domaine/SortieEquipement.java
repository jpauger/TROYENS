package domaine;

import java.util.ArrayList;

/**
 *
 * @author TROYENS
 */
public class SortieEquipement implements java.io.Serializable {
    
    private final int numeroSortie;
    public boolean sortieParDefaut = false;
    private boolean estConnectee = false;
    private final Equipement equipementMere ;
    public ArrayList<LigneProduit> listeLigneProduit = new ArrayList();
    
    public SortieEquipement(Equipement equipementMere, int unNumeroSortie)
    {
        this.numeroSortie = unNumeroSortie;
        this.estConnectee = false ;
        
        if (this.numeroSortie == 1)
        {
            sortieParDefaut = true ;
        }
        this.equipementMere = equipementMere ;
        //this.definirPosition();
    }
    
    public int getNumSortie()
    {
        return numeroSortie ;
    }
    
    public boolean estConnecte ()
    {
        return estConnectee;
    }
    
    public void setEstConnecte(boolean etat)
    {
        estConnectee = etat ;
    }
    
    public Equipement equipementMere()
    {
        return this.equipementMere ;
    }
    
    /*
    
    private void definirPosition()
    {
        if (this.numeroSortie <= 3 )
        {
            this.coordonnees.setX( this.equipementMere.coordonnees.getX() + 40);
            this.coordonnees.setY(this.equipementMere.coordonnees.getY() + 10 + this.numeroSortie * 10 );
        }
        
        if (this.numeroSortie > 3 && this.numeroSortie <= 6) 
        {
            this.coordonnees.setX( this.equipementMere.coordonnees.getX() + 40 - this.numeroSortie * 10 );
            this.coordonnees.setY(this.equipementMere.coordonnees.getY() + 10);
        }
    }
    
    */
}
