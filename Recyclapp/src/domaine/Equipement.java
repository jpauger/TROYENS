package domaine;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import utilitaires.*;

/**
 *
 * @author TROYENS
 */
public class Equipement implements java.io.Serializable {
    public String nom = "" ;
    public Coordonnee coordonnees;
    public int nombreEntrees = 1 ;
    public int nombreSorties = 1 ;
    public final Dimension size = new Dimension(64,64);
    public ImageIcon image;
    public ArrayList<SortieEquipement> listeSorties = new ArrayList();
    public ArrayList<SortieEquipement> listeSortieEntrante = new ArrayList();
    public boolean estSelectionne = false;
    public boolean entreeOccupee = false ;
    
    LigneProduit[] obtenirInformationTransit()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        LigneProduit[] informationTransit = null;
        return informationTransit;
    }  
    
    public boolean estSurEquipement(Coordonnee coordonnee)
    {
        int coordonneeX = coordonnee.getX();
        int coordonneeY = coordonnee.getY();
        int pointXHautGauche = this.coordonnees.getX();
        int pointXHautDroite = this.coordonnees.getX() + this.size.width;
        int pointYHautGauche = this.coordonnees.getY();
        int pointYBasGauche = this.coordonnees.getY() + this.size.height;
        
        return coordonneeX >= pointXHautGauche && coordonneeX <= pointXHautDroite && coordonneeY >= pointYHautGauche && coordonneeY <= pointYBasGauche;
    }
    
    public void augmenterNbSorties(){this.nombreSorties += 1;}
    
    public SortieEquipement obtenirSortieVide()
    {
        SortieEquipement sortieEquipement = this.listeSorties.get(0);

        for (int i=0; i< listeSorties.size(); i++ )
        {
            if (!listeSorties.get(i).estConnecte())
            {
                sortieEquipement = listeSorties.get(i);
                break;
            }
        }
        return sortieEquipement ;
    }
    
    public int getNombreSortie()
    {
        return this.listeSorties.size();
    }
    
    public ArrayList<LigneProduit> ObtenirListeProduitEntrant()
    {
        ArrayList<LigneProduit> listeLigneProduit = new ArrayList();
        for(int i =0;i<listeSortieEntrante.size();i++)
        {
            ArrayList<LigneProduit> listeLigneProduitSortie = listeSortieEntrante.get(i).listeLigneProduit;
            for(int j=0;j< listeLigneProduitSortie.size();j++)
            {
                boolean produitTrouve = false;
                for(int k =0; k< listeLigneProduit.size(); k++)
                {
                    if(listeLigneProduitSortie.get(j).produit.nom == listeLigneProduit.get(k).produit.nom)
                    {
                        listeLigneProduit.get(k).quantite += listeLigneProduitSortie.get(j).quantite;
                        produitTrouve = true;
                    }
                }
                if(!produitTrouve)
                    listeLigneProduit.add(new LigneProduit(listeLigneProduitSortie.get(j).produit, listeLigneProduitSortie.get(j).quantite));
            }
        }
        return listeLigneProduit;
    }
       
    public void ajouterSortie ()
    {
        this.listeSorties.add(new SortieEquipement(this, this.getNombreSortie()+1));
    }
    
    public String ObtenirTauxPurete(LigneProduit ligneProduit)
    {
        int quantiteTotal = 0;
        for(int i=0;i<listeSortieEntrante.size();i++)
        {
            for(int j=0;j<listeSortieEntrante.get(i).listeLigneProduit.size();j++)
            {
                    quantiteTotal += listeSortieEntrante.get(i).listeLigneProduit.get(j).quantite;
            }
        }
        
         float tauxRetourne = (float)ligneProduit.quantite / quantiteTotal * 100;
        return String.format("%.0f",tauxRetourne)  + "%";
    }
    
    public void ajouterEntree()
    {
        this.nombreEntrees ++ ;
    }
}
