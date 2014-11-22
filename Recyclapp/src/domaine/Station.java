package domaine;
import javax.swing.ImageIcon;
import utilitaires.Coordonnee;


/**
 *
 * @author TROYENS
 */
public class Station extends Equipement  {
    
    
    public String nomStation = "" ;
    public double capaciteMax ;
    public String description ;
    
    
    
    MatriceTransformation matriceTransformation ;
    
    //constructeur
    public Station (Coordonnee coordonnees)
    {
        super.coordonnees = coordonnees;
        this.nomStation = "nomStation";
        this.description = "descriptionStation";
        this.capaciteMax = 1000;
        this.nombreSorties = 2;        
        this.image = new ImageIcon("src/ico/station3moyen.png");
        
        for(int i =0; i< this.nombreSorties;i++)
        {
            this.listeSorties.add(new SortieEquipement((Equipement)this, i));
        }
        ((SortieEquipement)this.listeSorties.get(0)).sortieParDefaut = true;
    }
    
    // constructeur sans parametre
    public Station()
    {
        
    }
    
    public Coordonnee obtenirCoordonnees ()
    {
        return this.coordonnees;
    }

    void definirNombreSorties(int nouveauNbSorties)
    {
        super.nombreSorties = nouveauNbSorties;
    }
    
    void majQuantiteSorties(){};
    
    void ajouterSortie ()
    {
        this.listeSorties.add(new SortieEquipement(this, this.nombreSorties+1));
        nombreSorties ++;
    }
        
}
