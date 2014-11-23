package recyclapp.gui;
import application.Controller;
import javax.swing.ImageIcon;
import java.awt.Font;
import utilitaires.Coordonnee;



/**
 *
 * @author De Bayzer
 */
public class FenetrePrincipale extends javax.swing.JFrame{
    
    
//    private final InterfacePlan interfacePlan;
    private final Controller controller;
    private final PanneauSelectionStation panneauSelectionStation ;
    
    public final PanneauPlanTravail panneauPlanTravailExt;
    
    private int dragged = 0; //L'élément que l'on déplace (1 = Station)
    private boolean dansLePlan = false; //Si le curseur est présentement à l'intérieur du plan

    /**
     * Creates new form FenetrePrincipale
     */
    public FenetrePrincipale() 
    {
        initComponents();
        controller = new Controller();
        panneauSelectionStation = new PanneauSelectionStation(this.panneauProprietes ,controller);
        panneauSelectionStation.Init();
        
        panneauPlanTravailExt = new PanneauPlanTravail(this.panneauPlanTravail, controller, panneauSelectionStation);
        panneauPlanTravailExt.Init();

        controller.ajouterEntreeUsine(new Coordonnee(0,0));
        panneauPlanTravailExt.RafraichirPlan();
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panneauMenuHaut = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panneauOutils = new javax.swing.JPanel();
        btnAjoutConvoyeur = new javax.swing.JButton();
        btnStation = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnJonction = new javax.swing.JButton();
        btnSortieUsine = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        panneauProprietes = new javax.swing.JPanel();
        panneauPlanTravail = new javax.swing.JPanel();
        panneauMenuBas = new javax.swing.JPanel();
        labelCoordonnees = new javax.swing.JLabel();
        checkboxGrilleMagetique = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPanelCoordonnees = new javax.swing.JTextPane();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RecyclApp - Troyens");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        panneauMenuHaut.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "menu haut [x]", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/save.png"))); // NOI18N
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/appbar.folder.open.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/appbar.undo.curve.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setMaximumSize(new java.awt.Dimension(75, 75));
        jLabel4.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/appbar.redo.curve.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setMaximumSize(new java.awt.Dimension(75, 75));
        jLabel5.setMinimumSize(new java.awt.Dimension(25, 25));
        jLabel5.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/appbar.delete.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setMaximumSize(new java.awt.Dimension(75, 75));
        jLabel6.setMinimumSize(new java.awt.Dimension(75, 75));
        jLabel6.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/appbar.check.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setMaximumSize(new java.awt.Dimension(75, 75));
        jLabel7.setMinimumSize(new java.awt.Dimension(75, 75));
        jLabel7.setPreferredSize(new java.awt.Dimension(75, 75));

        ImageIcon iconeEnregistrer = new ImageIcon("save.png");
        jLabel2.setIcon(iconeEnregistrer);

        javax.swing.GroupLayout panneauMenuHautLayout = new javax.swing.GroupLayout(panneauMenuHaut);
        panneauMenuHaut.setLayout(panneauMenuHautLayout);
        panneauMenuHautLayout.setHorizontalGroup(
            panneauMenuHautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauMenuHautLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(702, Short.MAX_VALUE))
        );
        panneauMenuHautLayout.setVerticalGroup(
            panneauMenuHautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauMenuHautLayout.createSequentialGroup()
                .addGroup(panneauMenuHautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panneauMenuHautLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panneauMenuHautLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        panneauOutils.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "outils", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        panneauOutils.setToolTipText("");

        btnAjoutConvoyeur.setText("Ajouter Convoyeur");
        btnAjoutConvoyeur.setToolTipText("");
        btnAjoutConvoyeur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjoutConvoyeurMouseClicked(evt);
            }
        });

        btnStation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/station3moyen.png"))); // NOI18N
        btnStation.setToolTipText("");
        btnStation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnStation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStation.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnStationMouseDragged(evt);
            }
        });
        btnStation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnStationMouseReleased(evt);
            }
        });

        jLabel8.setText("Station");

        btnJonction.setText("Jonction");
        btnJonction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJonction.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnJonctionMouseDragged(evt);
            }
        });
        btnJonction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnJonctionMouseReleased(evt);
            }
        });

        btnSortieUsine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/light/appbar.door.leave.png"))); // NOI18N
        btnSortieUsine.setToolTipText("");
        btnSortieUsine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSortieUsine.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnSortieUsineMouseDragged(evt);
            }
        });
        btnSortieUsine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSortieUsineMouseReleased(evt);
            }
        });

        jLabel9.setText("sortie usine");

        javax.swing.GroupLayout panneauOutilsLayout = new javax.swing.GroupLayout(panneauOutils);
        panneauOutils.setLayout(panneauOutilsLayout);
        panneauOutilsLayout.setHorizontalGroup(
            panneauOutilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauOutilsLayout.createSequentialGroup()
                .addGroup(panneauOutilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauOutilsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAjoutConvoyeur))
                    .addGroup(panneauOutilsLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panneauOutilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(btnStation)
                            .addComponent(btnSortieUsine, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(62, 62, 62)
                        .addComponent(btnJonction)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        panneauOutilsLayout.setVerticalGroup(
            panneauOutilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauOutilsLayout.createSequentialGroup()
                .addGroup(panneauOutilsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauOutilsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnStation))
                    .addGroup(panneauOutilsLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnJonction)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSortieUsine, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnAjoutConvoyeur)
                .addGap(23, 23, 23))
        );

        panneauProprietes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "propriétés", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        panneauProprietes.setMaximumSize(new java.awt.Dimension(327, 332));
        panneauProprietes.setMinimumSize(new java.awt.Dimension(327, 332));
        panneauProprietes.setPreferredSize(new java.awt.Dimension(327, 332));

        javax.swing.GroupLayout panneauProprietesLayout = new javax.swing.GroupLayout(panneauProprietes);
        panneauProprietes.setLayout(panneauProprietesLayout);
        panneauProprietesLayout.setHorizontalGroup(
            panneauProprietesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panneauProprietesLayout.setVerticalGroup(
            panneauProprietesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panneauPlanTravail.setBackground(new java.awt.Color(153, 153, 153));
        panneauPlanTravail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "plan de travail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        panneauPlanTravail.setForeground(new java.awt.Color(255, 255, 255));
        panneauPlanTravail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panneauPlanTravailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panneauPlanTravailMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panneauPlanTravailLayout = new javax.swing.GroupLayout(panneauPlanTravail);
        panneauPlanTravail.setLayout(panneauPlanTravailLayout);
        panneauPlanTravailLayout.setHorizontalGroup(
            panneauPlanTravailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panneauPlanTravailLayout.setVerticalGroup(
            panneauPlanTravailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        panneauMenuBas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N

        labelCoordonnees.setText("Coordonnées :");

        checkboxGrilleMagetique.setText("Grille manétique");

        textPanelCoordonnees.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        textPanelCoordonnees.setText("x m , y m");
        jScrollPane2.setViewportView(textPanelCoordonnees);

        jRadioButton1.setText("Affichage image");

        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Affichage texte");

        jLabel1.setText("Échelle :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100 m", "200 m", "500 m", "1km" }));

        javax.swing.GroupLayout panneauMenuBasLayout = new javax.swing.GroupLayout(panneauMenuBas);
        panneauMenuBas.setLayout(panneauMenuBasLayout);
        panneauMenuBasLayout.setHorizontalGroup(
            panneauMenuBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauMenuBasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCoordonnees)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(panneauMenuBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(100, 100, 100)
                .addComponent(checkboxGrilleMagetique)
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panneauMenuBasLayout.setVerticalGroup(
            panneauMenuBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauMenuBasLayout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauMenuBasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panneauMenuBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauMenuBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCoordonnees))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauMenuBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkboxGrilleMagetique)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panneauMenuHaut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panneauOutils, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panneauProprietes, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panneauPlanTravail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panneauMenuBas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panneauMenuHaut, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panneauPlanTravail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panneauMenuBas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panneauOutils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panneauProprietes, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStationMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStationMouseDragged
        dragged = 1;
    }//GEN-LAST:event_btnStationMouseDragged

    private void panneauPlanTravailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panneauPlanTravailMouseEntered
        dansLePlan = true;
    }//GEN-LAST:event_panneauPlanTravailMouseEntered

    private void panneauPlanTravailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panneauPlanTravailMouseExited
        dansLePlan = false;
    }//GEN-LAST:event_panneauPlanTravailMouseExited

    private void btnStationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStationMouseReleased

        Coordonnee coord = new Coordonnee(evt.getX()-420 ,evt.getY());
        controller.ajouterStation(coord ); 
        panneauPlanTravailExt.RafraichirPlan();
    }//GEN-LAST:event_btnStationMouseReleased

    private void btnAjoutConvoyeurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjoutConvoyeurMouseClicked
        // TODO add your handling code here:
        btnAjoutConvoyeur.setFont(btnAjoutConvoyeur.getFont().deriveFont(Font.BOLD));
        controller.btnAjoutConvoyeurClicked = true;
    }//GEN-LAST:event_btnAjoutConvoyeurMouseClicked

    private void btnJonctionMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJonctionMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJonctionMouseDragged

    private void btnJonctionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJonctionMouseReleased
        // TODO add your handling code here:
        
        Coordonnee coord = new Coordonnee(evt.getX()- 290 ,evt.getY()+ 10);
        controller.ajouterJonction(coord ); 
        panneauPlanTravailExt.RafraichirPlan();
    }//GEN-LAST:event_btnJonctionMouseReleased

    private void btnSortieUsineMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortieUsineMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSortieUsineMouseDragged

    private void btnSortieUsineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortieUsineMouseReleased
        // TODO add your handling code here:
        Coordonnee coord = new Coordonnee(evt.getX()-440 ,evt.getY()+90);
        controller.ajouterSortieUsine(coord ); 
        panneauPlanTravailExt.RafraichirPlan();
    }//GEN-LAST:event_btnSortieUsineMouseReleased

       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjoutConvoyeur;
    private javax.swing.JButton btnJonction;
    private javax.swing.JButton btnSortieUsine;
    private javax.swing.JLabel btnStation;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox checkboxGrilleMagetique;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCoordonnees;
    private javax.swing.JPanel panneauMenuBas;
    private javax.swing.JPanel panneauMenuHaut;
    private javax.swing.JPanel panneauOutils;
    private javax.swing.JPanel panneauPlanTravail;
    private javax.swing.JPanel panneauProprietes;
    private javax.swing.JTextPane textPanelCoordonnees;
    // End of variables declaration//GEN-END:variables

    

}
