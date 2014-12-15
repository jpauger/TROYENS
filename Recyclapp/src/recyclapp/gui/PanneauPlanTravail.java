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
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;

/**
 *
 * @author TROYENS
 */
public class PanneauPlanTravail extends javax.swing.JPanel {
    
    private final JPanel conteneur ;
    private final Controller controller;
    private final PanneauSelectionStation panneauSelectionStation;
    private final PanneauSelectionEntreeUsine panneauSelectionEntreeUsine ;
    private Coordonnee loc_depart = new Coordonnee();
    private Coordonnee coord_depart = new Coordonnee();
    private boolean premierEquipementSelectionne = false;
    private final int TAILLECARRE = 40;
    public boolean grille = true;
    private int dragged = 0;
    public int selection;
    
    public java.util.ArrayList<CoordonneeLigne> listeCoordonnees = new java.util.ArrayList();

    /**
     * Creates new form PanneauPlanTravail
     * @param unConteneur
     * @param unController
     * @param unPanneauSelectionStation
     * @param unPanneauSEU
     */
    public PanneauPlanTravail(JPanel unConteneur, Controller unController,PanneauSelectionStation unPanneauSelectionStation, PanneauSelectionEntreeUsine unPanneauSEU ) {
        conteneur = unConteneur ;
        controller = unController ;
        panneauSelectionStation = unPanneauSelectionStation;
        panneauSelectionEntreeUsine = unPanneauSEU ;
        initComponents();
        
        this.conteneur.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                MouseClick(evt);
                AfficherToolTip(evt);
                // ici on verifie si le bouton ajout convoyeur est cliqué
                if (controller.btnAjoutConvoyeurClicked)
                {
                    // 2eme action : cas ou un premier element est deja selectionné
                    if (premierEquipementSelectionne)
                    {
                        Coordonnee coord2 = new Coordonnee(evt.getX(),evt.getY());

                        if (controller.obtenirEquipement(coord2) == null )
                        {
                            controller.QuitterModeAjoutConvoyeur();
                            premierEquipementSelectionne = false;
                            controller.btnAjoutConvoyeurClicked = false ;
                        }
                        else
                        {
                            Equipement equipementDepart = controller.obtenirEquipement(coord_depart);
                            Equipement equipementFin = controller.obtenirEquipement(coord2);
                            if ( !(equipementFin instanceof EntreeUsine)  && !(equipementFin.entreeOccupee) )
                            {
                                controller.ajouterConvoyeur(equipementDepart.obtenirSortieVide(), equipementFin);
                                selectionner(equipementFin);
                                if (! (equipementFin instanceof Jonction))
                                {
                                    equipementFin.entreeOccupee = true;
                                } 
                            }

                            // on reinitialise les booleens a false pour sortir du mode ajout de convoyeur
                            premierEquipementSelectionne = false;

                            controller.btnAjoutConvoyeurClicked = false;

                            controller.QuitterModeAjoutConvoyeur();

                            RafraichirPlan(); 
                        }
                    }
                    else // 1ere action : cas ou un premier element n'est pas encore selectionné
                    {
                        Coordonnee coord1 = new Coordonnee(evt.getX(),evt.getY());
                        // on stock les coordonnées de la premiere station pour y acceder lors de la 2eme action
                        //Equipement equipement = controller.obtenirEquipement(coord1);
                        
                        if (controller.obtenirEquipement(coord1) == null )
                        {
                            controller.QuitterModeAjoutConvoyeur();
                            controller.btnAjoutConvoyeurClicked = false ;
                        }
                        else
                        {
                            Equipement equipement = controller.obtenirEquipement(coord1);
                            selectionner(equipement);
                            RafraichirPlan();
                            coord_depart = coord1;
                            premierEquipementSelectionne = true ;
                        }
                        
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
                selectionner(equip);
                
                if(equip != null && dragged > 1)
                {
                    Coordonnee coord = new Coordonnee(evt.getX()+ equip.coordonnees.getX()-loc_depart.getX(),evt.getY()+equip.coordonnees.getY()-loc_depart.getY());
                    // on relocalise l'équipement sur lequel le MousePressed a été appliqué
                    controller.relocaliserStation(equip , coord); 
                    dragged = 0;
                    RafraichirPlan();
                }
            }  
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                AnnulerSelectionEquipements();
                RafraichirPlan();
            }
        });
        
        this.conteneur.addMouseMotionListener(new java.awt.event.MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                dragged += 1;
            } //TODO : gerer l'affichage de la trace lors du Dragg

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
        if(grille)
            afficherGrille(g);
        afficherConvoyeurs(g);
        afficherEquipements();
    }
    
    /*
    *   Permet d'afficher la grille
    */
    private void afficherGrille(Graphics g)
    {
        BasicStroke bs;
        Coordonnee origine = controller.plan.coord_camera;
        int bold = 20/controller.plan.zoom_values[controller.plan.zoom] * TAILLECARRE;
        for(int x = (-origine.getX()) % TAILLECARRE; x < this.getWidth(); x += TAILLECARRE)
        {
            g.setColor(Color.gray);
            Graphics2D g2d = (Graphics2D) g;
            if(x == -origine.getX())
                bs = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            else if((x + origine.getX()) % bold == 0)
                bs = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            else
                bs = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs);
            g2d.drawLine(x, 0, x, this.getHeight());
        }
        for(int y = (-origine.getY()) % TAILLECARRE; y < this.getHeight(); y += TAILLECARRE)
        {
            g.setColor(Color.gray);
            Graphics2D g2d = (Graphics2D) g;
            if(y == -origine.getY())
                bs = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            else if((y + origine.getY()) % bold == 0)
                bs = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            else
                bs = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs);
            g2d.drawLine(0, y, this.getWidth(), y);
        }
    }
    
    /*
    *   Permet d'afficher tous les convoyeurs du plan de travail  
    */
    private void afficherConvoyeurs(Graphics g)
    {
        // on vide la liste des anciennes coordonnees avant de recalculer
        listeCoordonnees.clear();
        
        
        
        for (int i=0 ; i< this.controller.plan.listeConvoyeur.size();i++)
        {
            this.controller.plan.listeConvoyeur.get(i).rafraichirRepresentation();
        }
        
        for (int i=0 ; i< this.controller.plan.listeConvoyeur.size();i++)
        {
            
            g.setColor(Color.RED);
            Graphics2D g2d = (Graphics2D) g;
            BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs1);
            
            Convoyeur leConvoyeur = this.controller.plan.listeConvoyeur.get(i);
            RepresentationConvoyeur representation = leConvoyeur.representation ;
            
            for (int nbPortions = 0 ; nbPortions < representation.listePortions.size(); nbPortions++ )
            {
                PortionConvoyeur portion = representation.listePortions.get(nbPortions);
                
                Coordonnee depart = controller.coordonneeRelative(portion.getPointDepart());
                Coordonnee arrivee = controller.coordonneeRelative(portion.getPointArrivee());
                
                g2d.drawLine(depart.getX(), depart.getY(), arrivee.getX(), arrivee.getY());
            }
            
        }
        
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
            g.setColor(this.controller.plan.listeConvoyeur.get(j).getCouleur());
            Graphics2D g2d = (Graphics2D) g;
            BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs1);
            g2d.drawLine(coordRel1.getX(), coordRel1.getY(), coordRel2.getX(), coordRel2.getY());
            
            double angle = Math.toRadians(45);
            int taillePointe = 12;
            Coordonnee point1 = new Coordonnee(), point2 = new Coordonnee(), point3 = new Coordonnee();
            double dy = coordRel2.getY() - coordRel1.getY();  
            double dx = coordRel2.getX() - coordRel1.getX();  
            double theta = Math.atan2(dy, dx);  
            
            double rho = theta + angle;  
            point1.setX((int)Math.round(coordRel2.getX() - 32 * Math.cos(theta)));
            point1.setY((int)Math.round(coordRel2.getY() - 32 * Math.sin(theta)));
            
            point2.setX((int)Math.round(point1.getX() - taillePointe * Math.cos(rho)));  
            point2.setY((int)Math.round(point1.getY() - taillePointe * Math.sin(rho)));  
            
            rho = theta - angle;  
            point3.setX((int)Math.round(point1.getX() - taillePointe * Math.cos(rho)));  
            point3.setY((int)Math.round(point1.getY() - taillePointe * Math.sin(rho))); 
            
            Polygon p=new Polygon();
            p.addPoint(point1.getX(), point1.getY());
            p.addPoint(point2.getX(), point2.getY());
            p.addPoint(point3.getX(), point3.getY());
            g2d.draw(p);
            g2d.fillPolygon(p);
        }
        
        
        
    }
    
    /*
    *   Permet d'afficher tous les équipements du plan de travail
    */
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
            labelPlace.setHorizontalAlignment(JLabel.CENTER);
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
                JLabel labelNom = new JLabel(equipement.nom);
                labelNom.setLocation(coordRel.getX()+equipement.size.width/2-100,coordRel.getY()+equipement.size.height+2-100);
                labelNom.setSize(200, 200);
                labelNom.setHorizontalAlignment(JLabel.CENTER);
                this.conteneur.add(labelNom);
                afficherSortiesStations((Station)equipement);
            }
            
        }
    }
    
    
    /*
    *   Permet d'afficher toutes les sorties d'une station donnée
    *   @param station de type Station
    */
    private void afficherSortiesStations (Station station)
    {
        for (int i = 0; i < station.listeSorties.size() ; i++)
        {
            Coordonnee coordRel = controller.coordonneeRelative(station.coordonnees);
            JLabel labelSortie = new JLabel();
            labelSortie.setIcon(new ImageIcon(getClass().getResource("/ico/sortie.png")));
            
            //labelSortie.setLocation(coordRel.getX()+ 40, coordRel.getY() + 10+ ( station.listeSorties.get(i).getNumSortie() * 10 ));
            
            labelSortie.setLocation(coordRel.getX()+ 52, coordRel.getY() + 10 + ( station.listeSorties.get(i).getNumSortie() * 10 ));
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
    
    private void AfficherToolTip(java.awt.event.MouseEvent evt)
    {
        Coordonnee coordonnee = new Coordonnee(evt.getX(),evt.getY());
        Equipement equipement = controller.obtenirEquipement(coordonnee);
        Convoyeur convoyeurSeclectionne = controller.obtenirConvoyeurSelectionne();
        ToolTipManager.sharedInstance().setInitialDelay(0);
        
        if(equipement != null)
        { 
            this.conteneur.setToolTipText(preparerMessageQuantite(equipement));
            hackMouseEvent(evt);            
        }
        else if(convoyeurSeclectionne != null)
        {
            this.conteneur.setToolTipText(preparerMessageQuantite(convoyeurSeclectionne));
            hackMouseEvent(evt);  
        }
        else
            this.conteneur.setToolTipText(null);
    }
    
    private String preparerMessageQuantite(Equipement equipement)
    {
        String message = "<html>";
        if(!equipement.ObtenirListeProduitEntrant().isEmpty())
        {
            for(int i = 0; i <equipement.ObtenirListeProduitEntrant().size();i++)
            {
                LigneProduit ligneProduit = equipement.ObtenirListeProduitEntrant().get(i);
                message += ligneProduit.produit.nom + " : " + ligneProduit.quantite + "Kg/h<br>";
            }
            message += "</html>";
        }
        else
            message =null;
        return message;
    }
    
    private String preparerMessageQuantite(Convoyeur convoyeur)
    {
        String message = "<html>";
        if(convoyeur.sortie != null)
        {
            for(int i = 0; i < convoyeur.sortie.listeLigneProduit.size();i++)
            {
                LigneProduit ligneProduit = convoyeur.sortie.listeLigneProduit.get(i);
                message += ligneProduit.produit.nom + " : " + ligneProduit.quantite + "Kg/h<br>";
            }
            message += "</html>";
        }
        else
            message =null;
        return message;
    }
    
    private void hackMouseEvent(java.awt.event.MouseEvent evt)
    {
        //Hack pour afficher le tooltip sans avoir à bouger
        ToolTipManager.sharedInstance().mouseMoved(new MouseEvent(this.conteneur,
                MouseEvent.MOUSE_MOVED,
                System.currentTimeMillis(),
                0,
                evt.getX(),
                evt.getY(),
                0,
                false));
    }
    
    /*
     *   Gère les actions a effectuer lorsqu'on fait un simple click sur le plan de travail
     */
    private void MouseClick(java.awt.event.MouseEvent evt)
    {
        dragged = 0;
        panneauSelectionStation.AfficherPanneauSelection(false);
        panneauSelectionEntreeUsine.Afficher(false);
        
        Coordonnee coord = new Coordonnee(evt.getX(), evt.getY());
        
        Equipement equipement = controller.obtenirEquipement(coord);
        

        if(equipement instanceof Station)
        {
            selectionner(equipement);
            panneauSelectionStation.AfficherPanneauSelection(true);
            panneauSelectionStation.AfficherStation((Station)equipement);
        }
        else if(equipement instanceof EntreeUsine)
        {
            selectionner(equipement);
            panneauSelectionEntreeUsine.Afficher(true);
            panneauSelectionEntreeUsine.AfficherEntree((EntreeUsine) equipement);
        }
        else if (!(equipement instanceof Jonction) && !(equipement instanceof SortieUsine))
        {
            AnnulerSelectionConvoyeurs();
            coord = controller.plan.coordonneeCliqueSurPlan(coord);
            // on verifie si on a cliqué sur un convoyeur        
            for (int i =0; i< this.listeCoordonnees.size(); i++)
            {
                if ( coord.estSurLigne(this.listeCoordonnees.get(i))) 
                {
                    // On peut récupérer le convoyeur cliqué a ce niveau
                    this.controller.plan.listeConvoyeur.get(i).selectionner();
                    break;
                } 
            }
            
            controller.selection = -1;

        }
        else
            controller.selection = -1;

        RafraichirPlan();
        AnnulerSelectionEquipements();
        
    }
    
    
    /*
     * permet d'annuler la selection d'un convoyeur
     *
     */
    public void AnnulerSelectionConvoyeurs()
    {
        for (int i =0; i< this.listeCoordonnees.size(); i++)
        {
            // On pourrait récupérer le convoyeur cliqué a ce niveau
            this.controller.plan.listeConvoyeur.get(i).deselectionner();

        }
        RafraichirPlan();
    }
    
    
    /*
     * permet de selectionner un equipement sur le plan qui sera mis en surbrillance lors de l'affichage
     * @param un equipement
     */
    private void selectionner(Equipement equipement)
    {
        AnnulerSelectionEquipements();
        AnnulerSelectionConvoyeurs();
        if(equipement != null)
        {
            equipement.estSelectionne = true;
            
            for(int i = 0; i< this.controller.plan.listeEquipement.size(); i++)
            {
                if(this.controller.plan.listeEquipement.get(i) == equipement)
                    controller.selection = i;
            }
        }
        if (equipement instanceof Station)
        {
            panneauSelectionStation.AfficherPanneauSelection(true);
            panneauSelectionStation.AfficherStation((Station)equipement);
        }
        if (equipement instanceof EntreeUsine)
        {
            panneauSelectionEntreeUsine.Afficher(true);
            panneauSelectionEntreeUsine.AfficherEntree((EntreeUsine) equipement);
        }
    }
    
    // annule la selection de tous les equipements du plan.
    public void AnnulerSelectionEquipements()
    {
        for(int i = 0; i< this.controller.plan.listeEquipement.size(); i++)
        {
            this.controller.plan.listeEquipement.get(i).estSelectionne = false;
        }
    }
    
    /*
     *  permet de rafraichir le plan de travail et réafficher tout son contenu.
     */
    public void RafraichirPlan()
    {
        this.conteneur.removeAll();
        creerMenuCamera();
        afficherEquipements();
        this.Init();
        this.conteneur.repaint();
    }  
    
    
    private void creerMenuCamera()
    {        
        JLabel fleche;
        for(int i = 0; i < 4; i++)
        {
            fleche = new JLabel();
            fleche.setSize(20,20);
            fleche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            if(i == 0) {//haut
                fleche.setLocation(778, 12);
                fleche.setIcon(new ImageIcon(getClass().getResource("/ico/FlecheH.png")));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(0,-1);
                            RafraichirPlan();}
                    });
            }
            else if(i == 1) {//droite
                fleche.setLocation(798, 32);
                fleche.setIcon(new ImageIcon(getClass().getResource("/ico/FlecheD.png")));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(1,0);
                            RafraichirPlan();}
                    });
            }
            else if(i == 2) {//bas
                fleche.setLocation(778, 52);
                fleche.setIcon(new ImageIcon(getClass().getResource("/ico/FlecheB.png")));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(0,1);
                            RafraichirPlan();}
                    });
            }
            else if(i == 3) {//gauche
                fleche.setLocation(758, 32);
                fleche.setIcon(new ImageIcon(getClass().getResource("/ico/FlecheG.png")));
                fleche.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){controller.moveCamera(-1,0);
                            RafraichirPlan();}
                    });
            }            
            
            this.conteneur.add(fleche);
        }
        fleche = new JLabel();
        fleche.setSize(20,20);
        fleche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fleche.setLocation(778,32);
        fleche.setIcon(new ImageIcon(getClass().getResource("/ico/FlecheC.png")));
        fleche.addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){controller.centrerCamera();
            RafraichirPlan();}
        });
        this.conteneur.add(fleche);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
