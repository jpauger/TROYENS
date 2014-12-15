package domaine;

import java.util.ArrayList;

/**
 *
 * @author TROYENS
 */
public class MatriceTransformation implements java.io.Serializable {
    
    public ArrayList<ArrayList<LigneProduitMatrice>> matriceLigneProduitMatrice = new ArrayList();
    public ArrayList<LigneProduitMatrice> listeLigneProduitMatrice = new ArrayList();
    void ajouterProduit (Produit produit, int pourcentage, SortieEquipement sortie)
    {
        /*listeLigneProduitMatrice.add(new LigneProduitMatrice(pourcentage,sortie));
        matriceLigneProduitMatrice.add(produit,listeLigneProduitMatrice);*/
    }
    public void definirMatriceBase()
    {
        
    }
    Object[][] obtenirMatriceTransformation()
    {
       /* Object[][] produits = new  Object[station.sortieEntrante.listeLigneProduit.size()][];
        for(int i =0 ; i< produits.length; i++)
        {
            String nomProduit = station.sortieEntrante.listeLigneProduit.get(i).produit.nom;
            produits[i] = new Object[station.nombreSorties];
            produits[i][0] = nomProduit;
            for(int j=1;j<=station.nombreSorties;j++)
            {
                produits[i][j] = j;
            }
        }*/
        return null;
    }
    
}
