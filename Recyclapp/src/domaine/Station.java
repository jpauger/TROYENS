package domaine;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import utilitaires.Coordonnee;


/**
 *
 * @author TROYENS
 */
public class Station extends Equipement  {
    
    
    public String nomStation = "" ;
    public int capaciteMax ;
    public String description ;  
    public Object[][] produits;
    
    public MatriceTransformation matriceTransformation ;
    
    //constructeur
    public Station (Coordonnee coordonnees, int nombreSorties)
    {
        super.coordonnees = coordonnees;
        this.nomStation = "nomStation";
        this.description = "descriptionStation";
        this.capaciteMax = 1000;      
        this.image = new ImageIcon("src/ico/station3moyen.png");
        this.nombreSorties = nombreSorties;
        
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
        if(!this.ObtenirListeProduitEntrant().isEmpty())
        {
            produits = new  Object[this.ObtenirListeProduitEntrant().size()][];
            for(int i =0 ; i< produits.length; i++)
            {
                LigneProduit ligneProduit = this.ObtenirListeProduitEntrant().get(i);
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
    
    public void majQuantiteMatrice()
    {
        if(produits != null)
        {
            for(int i =0 ; i< produits.length; i++)
            {
                LigneProduit ligneProduit = this.ObtenirListeProduitEntrant().get(i);
                produits[i][0] = ligneProduit.produit.nom + "(" + ligneProduit.quantite + ")";
            } 
        }
    }
    
    public void majQuantiteProduitSorties()
    {
        //Vider la lsite de produit pour chaque sorties
        for(int i = 0; i< listeSorties.size();i++)
        {
            if(listeSorties.get(i).listeLigneProduit != null)
                listeSorties.get(i).listeLigneProduit.clear();
        }
        //Recréer la liste de produits pour chaque produit entrant multiplié par la matrice de transformation
        if(produits != null)
        {
            for(int i = 0; i< produits.length;i++)
            {
                for(int j=0; j < this.ObtenirListeProduitEntrant().size();j++)
                {
                   LigneProduit listeLigneProduit = this.ObtenirListeProduitEntrant().get(j);
                   if(produits[i][0].toString().contains(listeLigneProduit.produit.nom))
                   {
                       for(int k = 0 ; k< this.listeSorties.size();k++)
                       {
                           this.listeSorties.get(k).listeLigneProduit.add(new LigneProduit(listeLigneProduit.produit,listeLigneProduit.quantite * Integer.parseInt(produits[i][k+1].toString()) / 100));
                       }
                   }
                }
            }
        }
    };
    
    

        
}
