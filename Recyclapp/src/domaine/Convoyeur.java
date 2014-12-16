package domaine;
import java.awt.Color;
import utilitaires.Coordonnee;


/**
 *
 * @author TROYENS
 */
public class Convoyeur implements java.io.Serializable {
    
    private Color couleur;
    private Color derniereCouleur ;
    public int capaciteMax = 2000;
    public final SortieEquipement sortie ;
    public final Equipement equipement; 
    public boolean estSelectionne ;
    public RepresentationConvoyeur representation ;

    
    
    // constructeur
    public Convoyeur (SortieEquipement uneSortie, Equipement unEquipement)
    {
        this.couleur = Color.RED;
        this.sortie = uneSortie ;
        this.equipement = unEquipement;
        this.estSelectionne = false ;
        unEquipement.listeSortieEntrante.add(uneSortie);
        if(unEquipement instanceof Station)
            ((Station)unEquipement).definirMatriceBase();
        if(unEquipement instanceof Jonction)
            ((Jonction)unEquipement).calculerSortie();
        
        initialiserRepresentation(uneSortie, unEquipement);
    }
    
    
    private void initialiserRepresentation(SortieEquipement sortie, Equipement equipement)
    {
        Coordonnee CoordonneeDepart = new Coordonnee(this.coorDepartX(), this.coorDepartY());
        Coordonnee CoordonneeArrivee = new Coordonnee (this.coorArriveeX(), this.coorArriveeY());
        
        RepresentationConvoyeur uneRepresentation  = new RepresentationConvoyeur(CoordonneeDepart, CoordonneeArrivee);
        uneRepresentation.ptDepart = CoordonneeDepart ;
        uneRepresentation.ptArrivee = CoordonneeArrivee ;
        
        this.representation = uneRepresentation ;
    }
    
    public void rafraichirRepresentation()
    {
        Coordonnee CoordonneeDepart = new Coordonnee(this.coorDepartX(), this.coorDepartY());
        Coordonnee CoordonneeArrivee = new Coordonnee (this.coorArriveeX(), this.coorArriveeY());
        //RepresentationConvoyeur uneRepresentation  = new RepresentationConvoyeur(CoordonneeDepart, CoordonneeArrivee);
        this.representation.majPointsCritiques(CoordonneeDepart, CoordonneeArrivee);
    }
    
    private Coordonnee getPointDepart(Coordonnee Arrivee)
    {
        Coordonnee depart = null ;
        for( PortionConvoyeur portion : this.representation.listePortions)
        {
            if ( portion.getPointArrivee().compareTo(Arrivee))
                depart = portion.getPointDepart();  
        }
        return depart ;
    }
    
    public boolean compareTo (Convoyeur nvConvoyeur)
    {
        boolean comparaison = false ;
        
        if (this.sortie == nvConvoyeur.sortie)
            comparaison = true ;
        
        return comparaison ;
    }
    
    
    /*
    * retourne le point d'arrivee du convoyeur
    * sert pour calculer les coordonnées de la fleche du convoyeur
    */
    public Coordonnee ptArrivee()
    {
        Coordonnee CoordonneeArrivee = new Coordonnee (this.coorArriveeX(), this.coorArriveeY());
        return CoordonneeArrivee ;
    }
    
    /*
    * retourne le point de depart de la derniere portion du convoyeur
    * sert pour calculer les coordonnées de la fleche du convoyeur
    */
    public Coordonnee dernierPtDepart()
    {
        Coordonnee ptArrivee = this.ptArrivee();
        Coordonnee dernierPtDepart = getPointDepart(ptArrivee);
        return dernierPtDepart;
    }
    
    public void setRepresentation(RepresentationConvoyeur nvlRepresentation)
    {
        this.representation = nvlRepresentation ;
    }
    
    
    LigneProduit[] obtenirInformationTransit()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        LigneProduit[] informationTransit = null;
        return informationTransit;
    }
    
    public String ObtenirTauxPurete(LigneProduit ligneProduit)
    {
        int quantiteTotal = 0;
        for(int i=0;i<sortie.listeLigneProduit.size();i++)
        {
            quantiteTotal += sortie.listeLigneProduit.get(i).quantite;
        }
        
         float tauxRetourne = (float)ligneProduit.quantite / quantiteTotal * 100;
        return String.format("%.0f",tauxRetourne)  + "%";
    }
    
        public void selectionner()
    {
        this.estSelectionne = true;

    }
    
    public void deselectionner()
    {
        this.estSelectionne = false ;
    }
    
    public Color getCouleur()
    {
        return this.couleur;
    }
    
    public void setCouleur(Color nvCouleur)
    {
        this.couleur = nvCouleur ;
    }
    
     

    
    // Calcul du decalage 
    
    
    private int decalageLargeurDepart(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.width / 2;
        return decalage;
    }
    
    private int decalageHauteurDepart(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.height / 2;
        return decalage;
    }
    
    private int decalageLargeurArrivee (Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.width / 2;
        return decalage;
    }
    
    private int decalageHauteurArrivee(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.height / 2;
        return decalage;
    }
    /* les coorDepart donnnent pour un convoyeur les coordonnées de départ utilisées pour sa représentation graphique */
    public int coorDepartX()
    {
        int coorDepartX = this.sortie.equipementMere().coordonnees.getX() + decalageLargeurDepart(this.equipement) ; 
        if (this.sortie.equipementMere() instanceof Station)
        {
            coorDepartX = this.sortie.equipementMere().coordonnees.getX()+ 69 ;
        }
        return coorDepartX ;
    }
    
    public int coorDepartY()
    {
        int coorDepartY = this.sortie.equipementMere().coordonnees.getY() + decalageHauteurDepart(this.equipement);
        
        if (this.sortie.equipementMere() instanceof Station)
        {
            coorDepartY = this.sortie.equipementMere().coordonnees.getY()+ 11 + this.sortie.getNumSortie()*10 ;
        }
        return coorDepartY ;
    }
  
    public int coorArriveeX()
    {
        return this.equipement.coordonnees.getX()+ decalageLargeurArrivee(this.equipement);
    }
    
    public int coorArriveeY()
    {
        return this.equipement.coordonnees.getY()+  decalageHauteurArrivee(this.equipement);
    }
    

    
    /* Fin coordonnées */
    
}
