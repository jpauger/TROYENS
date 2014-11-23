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
    public Object[][] produits;
    
    public MatriceTransformation matriceTransformation ;
    
    //constructeur
    public Station (Coordonnee coordonnees)
    {
        super.coordonnees = coordonnees;
        this.nomStation = "nomStation";
        this.description = "descriptionStation";
        this.capaciteMax = 1000;      
        this.image = new ImageIcon("src/ico/station3moyen.png");
        
        for(int i =0; i< this.nombreSorties;i++)
        {
            this.listeSorties.add(new SortieEquipement((Equipement)this, i));
        }
        ((SortieEquipement)this.listeSorties.get(0)).sortieParDefaut = true;
    }
    
    public Coordonnee obtenirCoordonnees ()
    {
        return this.coordonnees;
    }

    void definirNombreSorties(int nouveauNbSorties)
    {
        super.nombreSorties = nouveauNbSorties;
    }
    public void definirMatriceBase()
    {
        if(this.sortieEntrante != null)
        {
            produits = new  Object[this.sortieEntrante.listeLigneProduit.size()][];
            for(int i =0 ; i< produits.length; i++)
            {
                LigneProduit ligneProduit = this.sortieEntrante.listeLigneProduit.get(i);
                produits[i] = new Object[this.nombreSorties + 1];
                produits[i][0] = ligneProduit.produit.nom + "(" + ligneProduit.quantite + ")";
                for(int j=1;j<=this.nombreSorties;j++)
                {
                    if(j == 1)
                        produits[i][j] = 100;
                    else
                        produits[i][j] = 0;
                }
            } 
        }
    }
    
    void majQuantiteSorties(){};
    
    

        
}
