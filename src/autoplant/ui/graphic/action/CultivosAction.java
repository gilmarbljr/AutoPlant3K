/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.ui.graphic.action;

import autoplant.business.OperationService;
import autoplant.business.domain.UnidadeDeCultivo;
import javax.swing.DefaultListModel;

/**
 *
 * @author gbljunior
 */
public class CultivosAction extends javax.swing.JFrame {

    private final OperationService operationService;
    /**
     * Creates new form CultivosAction
     */
    public CultivosAction(OperationService operationService) {
        this.operationService = operationService;
        initComponents();
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listCultivos = new javax.swing.JList();
        search = new javax.swing.JButton();
        idCultivo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listCultivos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listCultivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCultivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listCultivos);

        search.setBackground(new java.awt.Color(195, 220, 195));
        search.setText("+");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        idCultivo.setText("ID do Cultivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 245, Short.MAX_VALUE)
                        .addComponent(idCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(idCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        getCultivosByID();
    }//GEN-LAST:event_searchActionPerformed

    private void listCultivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCultivosMouseClicked
        UnidadeDeCultivo uc = (UnidadeDeCultivo) listCultivos.getSelectedValue();
        VisualizeAction action = new VisualizeAction(uc);
        action.setVisible(true);
    }//GEN-LAST:event_listCultivosMouseClicked

    private void initData(){
        DefaultListModel DLM = new DefaultListModel();
        for (UnidadeDeCultivo uc : operationService.getAllUnidadeDeCultivo()){
            DLM.addElement(uc);
        }
        listCultivos.setModel(DLM);
    }
    
    private void getCultivosByID(){
        DefaultListModel DLM = new DefaultListModel();
        UnidadeDeCultivo uc = operationService.getUnidadeDeCultivoByID(getInteger());
        if(uc == null){
            initData();
            idCultivo.setText("ID do Cultivo");
        }
        else{
            DLM.addElement(uc);
            listCultivos.setModel(DLM);
        }
    }
    
    private Integer getInteger(){
        Integer id = 0;
        try {
            id = Integer.parseInt(idCultivo.getText());
        } catch (Exception e) {
        }
        return id;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idCultivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listCultivos;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
