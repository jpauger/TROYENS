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

import java.awt.Graphics;
import java.awt.Graphics2D;
import recyclapp.ligneConvoyeur;

/**
 *
 * @author De Bayzer
 */
public class InterfacePlan {
    private final JPanel conteneur ;
    private final Controller controller;
    private final PanneauSelectionStation panneauSelectionStation;
    private final PanneauPlanTravail panneauPlanTravailExt;
    private Coordonnee loc_depart = new Coordonnee();
    private Coordonnee coord_depart = new Coordonnee();
    private boolean premierEquipementSelectionne = false;
    
    
    
    public InterfacePlan (JPanel jpanel, Controller controller, PanneauSelectionStation panneauSelectionStation, PanneauPlanTravail panneauPlanTravailExt)
    {
                
        this.controller = controller;
        this.conteneur = jpanel;
        this.panneauSelectionStation = panneauSelectionStation;
        this.panneauPlanTravailExt = panneauPlanTravailExt ;
       
        
        this.conteneur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.conteneur.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                MouseClick(evt);
                
                // ici on verifie si le bouton ajout convoyeur est cliqué
                if (controller.btnAjoutConvoyeurClicked)
                {
                    // 2eme action : cas ou un premier element est deja selectionné
                    if (premierEquipementSelectionne)
                    {

                        Coordonnee coord2 = new Coordonnee(evt.getX(),evt.getY());
                        Station station1 = (Station)controller.obtenirEquipement(coord_depart);
                        Station station2 =(Station)controller.obtenirEquipement(coord2);

                        controller.ajouterConvoyeur(station1.listeSorties.get(0), station2);

                        // on reinitialise les booleens a false pour sortir du mode ajout de convoyeur
                        premierEquipementSelectionne = false;
                        controller.btnAjoutConvoyeurClicked = false;
                        
                        RafraichirPlan();
                        
                    }
                    else // 1ere action : cas ou un premier element n'est pas encore selectionné
                    {
                        Coordonnee coord1 = new Coordonnee(evt.getX(),evt.getY());
                        // on stock les coordonnées de la premiere station pour y acceder lors de la 2eme action
                        coord_depart = coord1;
                        premierEquipementSelectionne = true ;
                       
                    }
                    
                }
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
        
        // affichage des equipements
        
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
            
            //AFFICHAGE FOIREUX
            
            
        }
        
        // affichage des convoyeurs
        
       conteneur.add(new ligneConvoyeur(controller.plan));
       
       this.panneauPlanTravailExt.removeAll();
       this.panneauPlanTravailExt.Init();
       this.panneauPlanTravailExt.repaint();
       
       
       this.conteneur.repaint();
    }  
    
}
