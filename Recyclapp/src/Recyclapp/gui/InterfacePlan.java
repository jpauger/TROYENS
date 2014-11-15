/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclapp.gui;

import application.Controller;
import domaine.Equipement;
import domaine.PlanDeTravail;
import domaine.Station;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author De Bayzer
 */
public class InterfacePlan {
    private JPanel conteneur ;
    private Controller controller;
    
    public InterfacePlan (JPanel jpanel, Controller controller)
    {
        this.controller = controller;
        this.conteneur = jpanel;
    }
    
    public void RafraichirPlan()
    {
        for(int i=0;i<controller.plan.listeEquipement.size();i++)
        {
            Equipement equipement = controller.plan.listeEquipement.get(i);
            JLabel labelPlace = new JLabel();
            labelPlace.setLocation(equipement.coordonnees.getX(), equipement.coordonnees.getY());
            labelPlace.setSize(equipement.size);
            labelPlace.setVisible(true);
            //TODO : centraliser la gestion du type d'équipement? Trouver une meilleur facon de procéder
            if(equipement instanceof Station)
                labelPlace.setIcon(((Station)equipement).image);
            this.conteneur.add(labelPlace);            
        }
        
        this.conteneur.repaint();
    }
    
    
    
}
