package domaine;

import javax.swing.ImageIcon;
import utilitaires.Coordonnee;

/**
 *
 * @author DeBayzer
 */
public class EntreeUsine extends Equipement {
    
    public String description = "" ;
    public Object[][] produits ;
    
    public EntreeUsine (Coordonnee coordonnees)
    {
       this.nom = "Entrée d'usine";
       this.description = "Description de la l'entrée d'usine";
       super.coordonnees = coordonnees;          
       this.image = new ImageIcon(getClass().getResource("/ico/light/appbar.door.enter.png"));
       SortieEquipement sortieEquipement = new SortieEquipement((Equipement)this, 0);
       this.listeSorties.add(sortieEquipement);
       this.definirPanierProduits();
       
    }
    
    
    public void ajouterLigneProduit (int quantite ,Produit produit )
    {
        if (quantite != 0)
        {
            this.listeSorties.get(0).listeLigneProduit.add(new LigneProduit(produit, quantite));
            this.definirPanierProduits();
        }
    }
    

    void supprimerLigneProduit (String nomProduit)
    {
        for (LigneProduit ligne : this.listeSorties.get(0).listeLigneProduit)
        {
            // on parcourt la liste des produit de la seule sortie et si on trouve produit on supprime la ligne entiere
            if ( ligne.produit.nom.equals(nomProduit) ) 
            {
                this.listeSorties.get(0).listeLigneProduit.remove(ligne); 
            }
        }
    }
    
    
    void retirerLigneProduit(Produit produit)
    {
        for (LigneProduit ligne : this.listeSorties.get(0).listeLigneProduit)
        {
            // on parcourt la liste des produit de la seule sortie et si on trouve produit on supprime la ligne entiere
            if (ligne.produit == produit) 
            {
                this.listeSorties.get(0).listeLigneProduit.remove(ligne); 
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
    
    public void modifierProduits(Object[][] nvProduits)
    {
        for (int i = 0; i< nvProduits.length ; i++)
        {
            if ( Integer.parseInt(nvProduits[i][1].toString()) != 0 )
            {
                this.produits[i] = nvProduits[i];
            }
        }
        //this.produits = nvProduits ;
        
        
    }
    
    private void definirPanierProduits()
    {
              
        if(!this.listeSorties.get(0).listeLigneProduit.isEmpty())
        {
            this.retirerProduitsSupprimes();
            
            produits = new  Object[this.listeSorties.get(0).listeLigneProduit.size()][];
            for(int i =0 ; i< produits.length; i++)
            {
                LigneProduit ligneProduit = this.listeSorties.get(0).listeLigneProduit.get(i);
                produits[i] = new Object[this.nombreSorties + 1];
                produits[i][0] = ligneProduit.produit.nom ;
                produits [i][1] = ligneProduit.quantite ;
            } 
        }
    }
    
    public void majPanier()
    {
        //Vider la liste de produit actuelle
        this.listeSorties.get(0).listeLigneProduit.clear();
        // recréer la liste de produits 
        if (produits!= null)
        {
            for (int i= 0 ; i< produits.length; i++)
            {
                Produit nvProduit = new Produit(produits[i][0].toString());
                int nvQuantite = Integer.parseInt(produits[i][1].toString());
                
                if (nvQuantite != 0)
                {
                    LigneProduit nvLigne = new LigneProduit(nvProduit, nvQuantite);
                    this.listeSorties.get(0).listeLigneProduit.add(nvLigne);
                }                  
            }
        }
        
        this.definirPanierProduits();
    }
    
    public void retirerProduitsSupprimes()
    {
        for (LigneProduit ligne : this.listeSorties.get(0).listeLigneProduit)
        {
            // on parcourt la liste des produit de la seule sortie et si on trouve produit on supprime la ligne entiere
            if ( ligne.quantite == 0 ) 
            {
                this.listeSorties.get(0).listeLigneProduit.remove(ligne); 
            }
        }
    }
        
   
}
