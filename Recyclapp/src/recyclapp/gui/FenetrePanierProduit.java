package recyclapp.gui;

import application.Controller;
import domaine.EntreeUsine;
import domaine.Produit;
import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utilitaires.Util;

public class FenetrePanierProduit extends javax.swing.JFrame {
    private DefaultTableModel cvModel;
    private  JTable tableau;
    private String[] colonnes;
    private final EntreeUsine entree;
    private final Controller controller;
    
    
    /**
     * Creates new form FenetrePanierProduit
     * @param entree
     * @param controller
     */
    //@SuppressWarnings("empty-statement")
    public FenetrePanierProduit(EntreeUsine entree,Controller controller) {
        initComponents();
        this.entree = entree;
        this.controller = controller;
        
        colonnes = new String[2];
        colonnes[0] = "Produits";
        colonnes[1] = "Taux d'arrivée (Kg)";
        
        tableau = new JTable();
        this.setLayout(new BorderLayout());
        
        this.add(tableau.getTableHeader(), BorderLayout.PAGE_START);
        this.add(tableau, BorderLayout.CENTER);
        
        if (entree.produits != null)
        {            
            cvModel = new DefaultTableModel(entree.produits,colonnes);
            
            tableau.setModel(cvModel);
        }
        rafraichirText();       
        
        
        this.setLocationRelativeTo(this.controller.fenetre);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEnregistrer = new javax.swing.JButton();
        btnAjouterLigne = new javax.swing.JButton();
        btnFermer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textAucunProduit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnAjouterLigne.setText("Nouvelle ligne");
        btnAjouterLigne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterLigneActionPerformed(evt);
            }
        });

        btnFermer.setText("Fermer");
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });

        jLabel1.setText("Aide : Pour supprimer un produit remplacer la quantité par 0");

        textAucunProduit.setText("Aucun produit n'a été ajouté à cette entrée.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFermer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(btnAjouterLigne)
                        .addGap(54, 54, 54)
                        .addComponent(btnEnregistrer))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(textAucunProduit))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAucunProduit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnregistrer)
                    .addComponent(btnFermer)
                    .addComponent(btnAjouterLigne))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed

        // TODO : enregistrer les modifications apportées
        //DefaultTableModel dtm = (DefaultTableModel) tableau.getModel();
        int nRow = tableau.getRowCount();
        int nCol = tableau.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++) 
        {
            for (int j = 0 ; j < nCol ; j++)
            {
                tableData[i][j] = tableau.getValueAt(i,j);
            }
                
        }
            
        entree.modifierProduits(tableData);
        entree.majPanier();
        
        
        controller.redefinirMatriceStations();  
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnAjouterLigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterLigneActionPerformed
        
        // TODO : ajouter une nouvelle ligne au tableau des produits
        
        String nomProduit = Util.recupChaineOptionPane("Ajouter un produit","nom produit");
        
        if (nomProduit != null)
        {
            String message = "Quantité de "+ nomProduit + " (Kg/h):";
            String quantiteProduitStr = Util.recupChaineOptionPane("Ajouter un produit",message);
            
            int quantiteProduit = Integer.parseInt(quantiteProduitStr);
            
            if (quantiteProduit > 0)
            {
                entree.ajouterLigneProduit(quantiteProduit, new Produit(nomProduit) );
            }
            rafraichirText();
            cvModel = new DefaultTableModel(entree.produits,colonnes);
            tableau.setModel(cvModel);
            cvModel.fireTableDataChanged();
            tableau.repaint();
        }
    }//GEN-LAST:event_btnAjouterLigneActionPerformed

    
    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFermerActionPerformed


    private void rafraichirText()
    {
        if (entree.produits != null)
            textAucunProduit.setVisible(false);
        else
            textAucunProduit.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterLigne;
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JButton btnFermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel textAucunProduit;
    // End of variables declaration//GEN-END:variables
}
