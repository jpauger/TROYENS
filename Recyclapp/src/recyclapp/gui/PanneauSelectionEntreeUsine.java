package recyclapp.gui;

import application.Controller;
import domaine.EntreeUsine;
import domaine.Produit ;
import javax.swing.JPanel;
import utilitaires.Util ;

/**
 *
 * @author De Bayzer
 */
public class PanneauSelectionEntreeUsine extends javax.swing.JPanel {
    
    
    private final JPanel conteneur ;
    private final Controller controller;
    private EntreeUsine entree;
    private FenetrePanierProduit fenetrePanierProduit;
    
    /**
     * Creates new form panneauOutils
     * @param unConteneur
     * @param unController
     */
    public PanneauSelectionEntreeUsine(JPanel unConteneur, Controller unController ) {
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
    
    public void Afficher(boolean estVisible)
    {
        this.setVisible(estVisible);
    }
    
    public void AfficherEntree(EntreeUsine entree)
    {
        this.entree = entree;
        txtNomEntree.setText(entree.nom);
        txtDescription.setText(entree.description);
        btnPanierProduit.setVisible(true);  
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
        txtNomEntree = new javax.swing.JTextField();
        btnEnregistrer = new javax.swing.JButton();
        btnPanierProduit = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "selection"));

        jLabel1.setText("Nom Entree :");

        jLabel2.setText("Description :");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnPanierProduit.setText("Panier de produits entrants");
        btnPanierProduit.setToolTipText("");
        btnPanierProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanierProduitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomEntree, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnregistrer)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnPanierProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1))
                    .addComponent(txtNomEntree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addComponent(btnPanierProduit)
                .addGap(44, 44, 44)
                .addComponent(btnEnregistrer)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Selection");
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        entree.nom = txtNomEntree.getText();
        entree.description = txtDescription.getText();
  
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnPanierProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanierProduitActionPerformed
        fenetrePanierProduit = new FenetrePanierProduit(entree, controller);
        
    }//GEN-LAST:event_btnPanierProduitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JButton btnPanierProduit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtNomEntree;
    // End of variables declaration//GEN-END:variables
}
