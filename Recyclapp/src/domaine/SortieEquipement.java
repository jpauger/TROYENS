package domaine;

/**
 *
 * @author TROYENS
 */
public class SortieEquipement {
    
    private final int numeroSortie;
    private boolean sortieParDefaut = false;
    private boolean estConnectee = false;
    private final Station stationMere ;
    
    public SortieEquipement(Station stationMere, int unNumeroSortie)
    {
        this.numeroSortie = unNumeroSortie;
        if (this.numeroSortie == 1)
        {
            sortieParDefaut = true ;
        }
        this.stationMere = stationMere ;
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
    
    public Station stationMere()
    {
        return this.stationMere ;
    }
}
