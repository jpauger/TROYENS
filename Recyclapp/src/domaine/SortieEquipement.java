package domaine;

import java.util.ArrayList;

/**
 *
 * @author TROYENS
 */
public class SortieEquipement {
    
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
}
