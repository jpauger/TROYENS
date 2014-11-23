package recyclapp.gui;

import application.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import utilitaires.*;
import domaine.*;
import java.awt.Color;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author TROYENS
 */
public class PanneauPlanTravail extends javax.swing.JPanel {
    
    private final JPanel conteneur ;
    private final Controller controller;
    private final PanneauSelectionStation panneauSelectionStation;
    private Coordonnee loc_depart = new Coordonnee();
    private Coordonnee coord_depart = new Coordonnee();
    private boolean premierEquipementSelectionne = false;
    
    public java.util.ArrayList<CoordonneeLigne> listeCoordonnees = new java.util.ArrayList();

    /**
     * Creates new form PanneauPlanTravail
     * @param unConteneur
     * @param unController
     * @param unPanneauSelectionStation
     */
    public PanneauPlanTravail(JPanel unConteneur, Controller unController,PanneauSelectionStation unPanneauSelectionStation ) {
        conteneur = unConteneur ;
        controller = unController ;
        panneauSelectionStation = unPanneauSelectionStation;
        initComponents();
        
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
                        Equipement equipementDepart = controller.obtenirEquipement(coord_depart);
                        Equipement equipementFin = controller.obtenirEquipement(coord2);
                        
                        if (! (equipementFin instanceof EntreeUsine) )
                        {
                            controller.ajouterConvoyeur(equipementDepart.obtenirSortieVide(), equipementFin);
                        }

                        if (equipementDepart instanceof Jonction)
                        {
                            equipementDepart.ajouterSortie();
                        }

                        // on reinitialise les booleens a false pour sortir du mode ajout de convoyeur
                        premierEquipementSelectionne = false;
                        controller.btnAjoutConvoyeurClicked = false;
                        
                        RafraichirPlan(); 
                    }
                    else // 1ere action : cas ou un premier element n'est pas encore selectionné
                    {
                        Coordonnee coord1 = new Coordonnee(evt.getX(),evt.getY());
                        // on stock les coordonnées de la premiere station pour y acceder lors de la 2eme action
                        Equipement equipement = controller.obtenirEquipement(coord1);
                        equipement.estSelectionne = true ;
                        RafraichirPlan();
                        equipement.estSelectionne = false; 
                        
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
                Equipement equip;
                equip = controller.obtenirEquipement(loc_depart);
                if(equip != null)
                {
                    Coordonnee coord = new Coordonnee(evt.getX()+equip.coordonnees.getX()-loc_depart.getX(),evt.getY()+equip.coordonnees.getY()-loc_depart.getY());
                    // on relocalise l'équipement sur lequel le MousePressed a été appliqué
                    controller.relocaliserStation(equip , coord); 
                    RafraichirPlan();
                }
            }  
        });
        
        this.conteneur.addMouseMotionListener(new java.awt.event.MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {} //TODO : gerer l'affichage de la trace lors du Dragg

            @Override
            public void mouseMoved(MouseEvent e) {}
        });
    }
    
    public void Init()
    {
        this.setLocation(0,0);
        this.setSize(this.conteneur.getSize());
        this.conteneur.add(this);
        initComponents();
        this.conteneur.repaint();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Plan de travail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        afficherConvoyeurs(g);
        afficherEquipements();
    }
    
    private void afficherConvoyeurs(Graphics g)
    {
        // on vide la liste des anciennes coordonnees avant de recalculer
        listeCoordonnees.clear();
        
        // on stocke les coordonnées des lignes a tracer dans une arrayliste
        for (int i= 0; i< this.controller.plan.listeConvoyeur.size(); i++ )
        {
            this.listeCoordonnees.add(i, obtenirCoordonneeLigne(this.controller.plan.listeConvoyeur.get(i) ));
        }
        
        // on trace chacune des lignes
        for (int j= 0; j< this.listeCoordonnees.size(); j++)
        {
            Coordonnee coordRel1 = controller.coordonneeRelative(new Coordonnee(this.listeCoordonnees.get(j).getX1(),this.listeCoordonnees.get(j).getY1()));
            Coordonnee coordRel2 = controller.coordonneeRelative(new Coordonnee(this.listeCoordonnees.get(j).getX2(),this.listeCoordonnees.get(j).getY2()));
            g.setColor(Color.BLUE);
            Graphics2D g2d = (Graphics2D) g;
            BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs1);
            //g2d.drawLine(this.listeCoordonnees.get(j).getX1()-camX, this.listeCoordonnees.get(j).getY1()-camY, this.listeCoordonnees.get(j).getX2()-camX, this.listeCoordonnees.get(j).getY2()-camY);
            g2d.drawLine(coordRel1.getX(), coordRel1.getY(), coordRel2.getX(), coordRel2.getY());
        }
        
        
        
    }
    
    private void afficherEquipements()
    {
        for(int i=0;i<controller.plan.listeEquipement.size();i++)
        {
            Equipement equipement = controller.plan.listeEquipement.get(i);
            JLabel labelPlace = new JLabel();
            Coordonnee coordRel = controller.coordonneeRelative(equipement.coordonnees);
            labelPlace.setLocation(coordRel.getX(), coordRel.getY());
            //labelPlace.setLocation(equipement.coordonnees.getX()-controller.plan.coord_camera.getX(), equipement.coordonnees.getY()-controller.plan.coord_camera.getY());
            labelPlace.setSize(equipement.size);
            labelPlace.setVisible(true);
            labelPlace.setIcon(equipement.image);
            labelPlace.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            if(equipement.estSelectionne)
            {
                labelPlace.setBorder(BorderFactory.createLineBorder(Color.yellow));
            }
            this.conteneur.add(labelPlace);
            
            if (equipement instanceof Station)
            {
                afficherSortiesStations((Station)equipement);
            }
            
        }
    }
    
    private void afficherSortiesStations (Station station)
    {
        for (int i = 0; i < station.listeSorties.size() ; i++)
        {
            Coordonnee coordRel = controller.coordonneeRelative(station.coordonnees);
            JLabel labelSortie = new JLabel();
            labelSortie.setIcon(new ImageIcon("src/ico/sortie.png") );
            
            labelSortie.setLocation(coordRel.getX()+ 40, coordRel.getY() + ( station.listeSorties.get(i).getNumSortie()*10));
            labelSortie.setSize(5,5);
            labelSortie.setVisible(true);
            this.conteneur.add(labelSortie);
        }
        
    }
    
    /*
    * retourne les coordonnées utilisées pour tracer la ligne représentant un convoyeur
    * @param c de type Convoyeur
    * @return coordLigne de type CoordonneeLigne
    */
    private CoordonneeLigne obtenirCoordonneeLigne(Convoyeur c)
    {
        CoordonneeLigne coordLigne = new CoordonneeLigne( c.coorDepartX(), c.coorDepartY(), c.coorArriveeX(), c.coorArriveeY());
        return coordLigne ;
    }
    
    
    private void MouseClick(java.awt.event.MouseEvent evt)
    {
        panneauSelectionStation.AfficherPanneauSelection(false);
        Coordonnee coord = new Coordonnee(evt.getX(), evt.getY());
        
        Equipement equipement = controller.obtenirEquipement(coord);
        
        // on verifie si on a cliqué sur un convoyeur
        boolean convoyeurTrouve = false;
        
        for (int i =0; i< this.listeCoordonnees.size(); i++)
        {
            if ( coord.estSurLigne(this.listeCoordonnees.get(i))) 
            {
                convoyeurTrouve = true ;
                System.out.println("Convoyeur");
            } 
        }
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
        afficherEquipements();
        creerMenuCamera();
        this.Init();
        this.conteneur.repaint();
    }  
    
    private void creerMenuCamera()
    {        
        for(int i = 0; i < 4; i++)
        {
            JLabel fleche = new JLabel();
            fleche.setSize(20,20);
            fleche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            if(i == 0) {//haut
                fleche.setLocation(778, 12);
                fleche.setIcon(new ImageIcon("src/ico/FlecheH.png"));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(0,-1);
                            RafraichirPlan();}
                    });
            }
            else if(i == 1) {//droite
                fleche.setLocation(798, 32);
                fleche.setIcon(new ImageIcon("src/ico/FlecheD.png"));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(1,0);
                            RafraichirPlan();}
                    });
            }
            else if(i == 2) {//bas
                fleche.setLocation(778, 52);
                fleche.setIcon(new ImageIcon("src/ico/FlecheB.png"));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(0,1);
                            RafraichirPlan();}
                    });
            }
            else if(i == 3) {//gauche
                fleche.setLocation(758, 32);
                fleche.setIcon(new ImageIcon("src/ico/FlecheG.png"));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(-1,0);
                            RafraichirPlan();}
                    });
            }            
            
            this.conteneur.add(fleche);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
