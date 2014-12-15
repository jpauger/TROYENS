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
    
    
    public final ArrayList<PortionConvoyeur> listePortions = new ArrayList();
    
    
    public RepresentationConvoyeur( Coordonnee depart, Coordonnee arrivee)
    {
        PortionConvoyeur portionInitiale = new PortionConvoyeur(depart,arrivee);
        this.listePortions.add(portionInitiale) ;
    }
    
    public void creerNvlPortion (Coordonnee nvPoint, PortionConvoyeur portion )
    {
        if (listePortions.contains(portion))
        {
            PortionConvoyeur nvlPortion1 = new PortionConvoyeur( nvPoint, portion.getPointArrivee() );
            PortionConvoyeur nvlPortion2 = new PortionConvoyeur (portion.getPointDepart(), nvPoint) ;
            
            listePortions.remove(portion);
            
            listePortions.add(nvlPortion1);
            listePortions.add(nvlPortion2);
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
