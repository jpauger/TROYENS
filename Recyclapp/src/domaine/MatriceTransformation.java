package domaine;

import java.util.ArrayList;

/**
 *
 * @author TROYENS
 */
public class MatriceTransformation {
    
    public ArrayList<LigneProduitMatrice> listeLigneProduitMatrice = new ArrayList();
    void ajouterProduit (Produit produit, int pourcentage, SortieEquipement sortie)
    {
        listeLigneProduitMatrice.add(new LigneProduitMatrice(produit,pourcentage,sortie));
    }
    
}
