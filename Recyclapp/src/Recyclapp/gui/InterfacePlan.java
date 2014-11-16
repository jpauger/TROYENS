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
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utilitaires.Coordonnee;

/**
 *
 * @author De Bayzer
 */
public class InterfacePlan {
    private JPanel conteneur ;
    private Controller controller;
    
    public InterfacePlan (JPanel jpanel, Controller controller)
    {
        Coordonnee loc_depart = new Coordonnee();
        Coordonnee loc_arrivee = new Coordonnee();
        Equipement unEquipement = new Equipement();
                
        this.controller = controller;
        this.conteneur = jpanel;
        this.conteneur.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                
                //Equipement equipement = controller.obtenirEquipement(new Coordonnee( evt.getX(), evt.getY()));
                  //controller.supprimerToutes();
                Coordonnee coordonnees = new Coordonnee(400,400);// test
                controller.relocaliserStation(controller.obtenirEquipement(new Coordonnee( evt.getX(), evt.getY())) , coordonnees ); 
                RafraichirPlan();
            }
            
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
//                Coordonnee coord = new Coordonnee(evt.getX(),evt.getY());
//                controller.ajouterStation(coord);
//                RafraichirPlan();
            }
          
            
        });
        
        this.conteneur.addMouseMotionListener(new java.awt.event.MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
//                Coordonnee coord = new Coordonnee(e.getX(),e.getY());
//                controller.ajouterStation(coord);
//                RafraichirPlan();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    public void RafraichirPlan()
    {
        this.conteneur.removeAll();
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
