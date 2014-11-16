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
import java.awt.Cursor;
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
    private final JPanel conteneur ;
    private final Controller controller;
    private final PanneauSelectionStation panneauSelectionStation;
    private Coordonnee loc_depart = new Coordonnee();
    
    public InterfacePlan (JPanel jpanel, Controller controller, PanneauSelectionStation panneauSelectionStation)
    {
                
        this.controller = controller;
        this.conteneur = jpanel;
        this.panneauSelectionStation = panneauSelectionStation;
        this.conteneur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.conteneur.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                MouseClick(evt);
            }   
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                //on stock les coordonnees de depart, elles serviront pour savoir quelle equipement deplacer lors du MouseReleased
                Coordonnee coordonnees = new Coordonnee( evt.getX(), evt.getY());
                loc_depart = coordonnees;
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                //25 et 40 sont du au decallage entre le bord de l'image .png et l'image reelle :(
                // pour que la souris sous bien au milieu de l'image
                Coordonnee coord = new Coordonnee(evt.getX()-25,evt.getY()-40);
                // on relocalise l'équipement sur lequel le MousePressed a été appliqué
                controller.relocaliserStation(controller.obtenirEquipement(loc_depart) , coord ); 
                RafraichirPlan();
            }  
        });
        
        this.conteneur.addMouseMotionListener(new java.awt.event.MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {} //TODO : gerer l'affichage de la trace lors du Dragg

            @Override
            public void mouseMoved(MouseEvent e) {}
        });
    }
    private void MouseClick(java.awt.event.MouseEvent evt)
    {
        panneauSelectionStation.AfficherPanneauSelection(false);
        Equipement equipement = controller.obtenirEquipement(new Coordonnee( evt.getX(), evt.getY()));
        if(equipement instanceof Station)
        {
            panneauSelectionStation.AfficherPanneauSelection(true);
            panneauSelectionStation.AfficherStation((Station)equipement);
        }

        RafraichirPlan();
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
