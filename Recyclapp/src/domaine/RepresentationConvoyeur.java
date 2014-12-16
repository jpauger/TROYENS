package domaine;

import java.util.ArrayList;
import utilitaires.Coordonnee;

/**
 *
 * @author De Bayzer
 * Sert a représenter un convoyeur comme une liste de plusieurs portions de convoyeurs
 * 
 */
public class RepresentationConvoyeur implements java.io.Serializable {
    
    
    public Coordonnee ptDepart ;
    public Coordonnee ptArrivee ;
    public final ArrayList<PortionConvoyeur> listePortions = new ArrayList();
    
    
    public RepresentationConvoyeur( Coordonnee depart, Coordonnee arrivee)
    {
        PortionConvoyeur portionInitiale = new PortionConvoyeur(depart,arrivee);
        this.listePortions.add(portionInitiale) ;
    }
    
    
    public void majPointsCritiques(Coordonnee nvPtDepart, Coordonnee nvPtArrivee)
    {
        for (PortionConvoyeur portion : this.listePortions)
        {
            if ( portion.getPointDepart().compareTo(this.ptDepart))
            {
                portion.setPointDepart(nvPtDepart);
                this.ptDepart = nvPtDepart ;
            }
            
            if ( portion.getPointArrivee().compareTo(this.ptArrivee))
            {
                portion.setPointArrivee(nvPtArrivee);
                this.ptArrivee = nvPtArrivee ;
            }
        }  
    }
    
    public void creerNvlPortion (Coordonnee nvPoint, PortionConvoyeur unePortion )
    {
        boolean deletePortion = false;
        int index = 0;
        
        for (PortionConvoyeur portion : this.listePortions)
        {
            if( portion.compareTo(unePortion) )
            {
                deletePortion = true ;
                index = this.listePortions.indexOf(portion);
            }
        } 
        
        if (deletePortion)
        {
            PortionConvoyeur nvlPortion1 = new PortionConvoyeur( unePortion.getPointDepart(), nvPoint );
            PortionConvoyeur nvlPortion2 = new PortionConvoyeur (nvPoint, unePortion.getPointArrivee() ) ;
            this.listePortions.add(nvlPortion1);
            this.listePortions.add(nvlPortion2);
            this.listePortions.remove(index);
            
        }
    }
    
    public void deplacerPointAngulaire (Coordonnee PointDepart , Coordonnee PointSortie)
    {
        for (PortionConvoyeur portion : listePortions)
        {
            if ( portion.getPointArrivee() == PointDepart )
            {
                portion.setPointArrivee(PointSortie);
            }
            
            if ( portion.getPointDepart() == PointDepart )
            {
                portion.setPointDepart(PointSortie);
            }
        }
    }
    
}
