package domaine;

import java.util.ArrayList;
import utilitaires.Coordonnee;

/**
 *
 * @author De Bayzer
 * Sert a représenter une portion de convoyeur
 * La représatation d'un convoyeur sera composée de plusieurs portions
 * 
 */
public class PortionConvoyeur implements java.io.Serializable {
    
    private Coordonnee pointDepart ;
    private Coordonnee pointArrivee ;
    
    
    public PortionConvoyeur(Coordonnee depart , Coordonnee arrivee)
    {
        this.pointDepart = depart;
        this.pointArrivee = arrivee ;
    }
    
    public void setPointDepart(Coordonnee nvlCoordonnees)
    {
        this.pointDepart = nvlCoordonnees ;
    }
    
    public void setPointArrivee(Coordonnee nvlCoordonnees)
    {
        this.pointArrivee = nvlCoordonnees ;
    }
    
    public Coordonnee getPointDepart()
    {
        return this.pointDepart ;
    }
    
    public Coordonnee getPointArrivee()
    {
        return this.pointArrivee ;
    }
      
}
