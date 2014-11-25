package recyclapp.gui;

import application.Controller;
import domaine.Station;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author De Bayzer
 */
public class PanneauSelectionStation extends javax.swing.JPanel {
    
    
    private final JPanel conteneur ;
    private final Controller controller;
    private Station station;
    private FenetreMatriceTransformation fenetreTransformation;
    
    /**
     * Creates new form panneauOutils
     * @param unConteneur
     * @param unController
     */
    public PanneauSelectionStation(JPanel unConteneur, Controller unController ) {
        this.controller = unController;
        this.conteneur = unConteneur ;
        
    }
    
    public void Init()
    {
        this.setLocation(0,0);
        this.setSize(this.conteneur.getSize());
        this.conteneur.add(this);
        initComponents();
        this.conteneur.repaint();
        this.setVisible(false);
    }
    
    public void AfficherPanneauSelection(boolean estVisible)
    {
        this.setVisible(estVisible);
    }
    
    public void AfficherStation(Station station)
    {
        this.station = station;
        txtNomStation.setText(station.nom);
        txtDescription.setText(station.description);
        txtCapaciteMax.setText(Integer.toString(station.capaciteMax));
        
        txtNombreSorties.setText(String.valueOf(station.getNombreSortie()));
        
        if(station.ObtenirListeProduitEntrant().isEmpty())
            btnMatrice.setVisible(false);
        else
            btnMatrice.setVisible(true);
        for(int i=0;i<station.nombreSorties;i++)
        {
            JLabel lblSortie = new JLabel("Sortie" + i);
            lblSortie.setSize(10,10);
            lblSortie.setLocation(10,10);
            lblSortie.setVisible(true);
            this.conteneur.add(lblSortie);
        }
        this.conteneur.repaint();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtNomStation = new javax.swing.JTextField();
        btnEnregistrer = new javax.swing.JButton();
        txtCapaciteMax = new javax.swing.JTextField();
        btnMatrice = new javax.swing.JButton();
        txtNombreSorties = new javax.swing.JTextField();
        labelNbSorties = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "selection"));

        jLabel1.setText("Nom station :");

        jLabel2.setText("Description :");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel3.setText("Capacité max.(kg/h) :");

        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnMatrice.setText("Matrice de transformation");
        btnMatrice.setToolTipText("");
        btnMatrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriceActionPerformed(evt);
            }
        });

        txtNombreSorties.setEditable(false);

        labelNbSorties.setText("Nombre de sorties :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnregistrer)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomStation, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelNbSorties)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreSorties)
                                    .addComponent(txtCapaciteMax, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMatrice, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1))
                    .addComponent(txtNomStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCapaciteMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreSorties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNbSorties))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMatrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnEnregistrer)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Selection");
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        station.nom = txtNomStation.getText();
        station.description = txtDescription.getText();
        station.capaciteMax = Integer.parseInt(txtCapaciteMax.getText());
        //on ajoute des sorties a la station
        // pour l'instant on ne permettra pas la modification du nombre de sorties
        
        /*
        int temp = Integer.parseInt(txtNombreSorties.getText());
        if (station.getNombreSortie() < temp)
        {
            for (int i= station.getNombreSortie() ; i < temp ; i++)
            {
                station.ajouterSortie();
            }
        }
        */
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnMatriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriceActionPerformed
        fenetreTransformation = new FenetreMatriceTransformation(station,controller);
        
    }//GEN-LAST:event_btnMatriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JButton btnMatrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNbSorties;
    private javax.swing.JTextField txtCapaciteMax;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtNomStation;
    private javax.swing.JTextField txtNombreSorties;
    // End of variables declaration//GEN-END:variables
}
