/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.ui.graphic;

import autoplant.business.AccountManagementService;
import autoplant.business.OperationService;
import autoplant.business.domain.Credentials;
import autoplant.business.domain.OperationLocation;
import autoplant.ui.graphic.action.CultivosAction;
import autoplant.ui.graphic.action.EditAction;
import autoplant.ui.graphic.action.EmployeeLoginAction;
import autoplant.ui.graphic.action.InsertAction;

/**
 *
 * @author gbljunior
 */
public class AutoPlantGraphicInterface extends javax.swing.JFrame {
    
    private final OperationLocation location;
    private final AccountManagementService accountManagementService;
    private final OperationService operationService;
    private Credentials credentials;
    
    /**
     * Creates new form AutoPlantGraphicInterface
     */
    public AutoPlantGraphicInterface(OperationLocation location, AccountManagementService accountManagementService, OperationService operationService) {
        this.location = location;
        this.accountManagementService = accountManagementService;
        this.operationService = operationService;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inserirCultivo = new javax.swing.JButton();
        visualizarCultivo = new javax.swing.JButton();
        alterarCultivo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        login = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(127, 160, 78));

        jPanel1.setBackground(new java.awt.Color(110, 140, 90));

        inserirCultivo.setBackground(new java.awt.Color(195, 220, 195));
        inserirCultivo.setText("Inserir Cultivo");
        inserirCultivo.setEnabled(false);
        inserirCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirCultivoActionPerformed(evt);
            }
        });

        visualizarCultivo.setBackground(new java.awt.Color(195, 220, 195));
        visualizarCultivo.setText("Visualizar Cultivos");
        visualizarCultivo.setEnabled(false);
        visualizarCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarCultivoActionPerformed(evt);
            }
        });

        alterarCultivo.setBackground(new java.awt.Color(195, 220, 195));
        alterarCultivo.setText("Alterar Cultivos");
        alterarCultivo.setEnabled(false);
        alterarCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarCultivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(alterarCultivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(visualizarCultivo, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
            .addComponent(inserirCultivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(alterarCultivo)
                .addGap(18, 18, 18)
                .addComponent(visualizarCultivo)
                .addGap(18, 18, 18)
                .addComponent(inserirCultivo)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jMenu1.setText(location.toString());

        login.setText("Iniciar Sessão");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jMenu1.add(login);

        logout.setText("Encerrar Sessão");
        logout.setEnabled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        exit.setText("Sair");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        EmployeeLoginAction action = new EmployeeLoginAction(AutoPlantGraphicInterface.this, accountManagementService);
        action.setVisible(true);
    }//GEN-LAST:event_loginActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        logout();
    }//GEN-LAST:event_logoutActionPerformed

    private void visualizarCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarCultivoActionPerformed
        CultivosAction action = new CultivosAction(operationService);
        action.setVisible(true);
    }//GEN-LAST:event_visualizarCultivoActionPerformed

    private void inserirCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirCultivoActionPerformed
        InsertAction action = new InsertAction(operationService);
        action.setVisible(true);
    }//GEN-LAST:event_inserirCultivoActionPerformed

    private void alterarCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarCultivoActionPerformed
        EditAction action = new EditAction(operationService);
        action.setVisible(true);
    }//GEN-LAST:event_alterarCultivoActionPerformed

    public boolean isLoggedIn() {
		return this.credentials != null;
	}

	public void login(Credentials credentials) {
		this.credentials = credentials;
		if (isLoggedIn()) {
                    toggleActions();
		}
	}

	public void logout() {
		this.credentials = null;
                toggleActions();
	}
        
        protected void toggleActions() {
            alterarCultivo.setEnabled(!alterarCultivo.isEnabled());
            visualizarCultivo.setEnabled(!visualizarCultivo.isEnabled());
            inserirCultivo.setEnabled(!inserirCultivo.isEnabled());
            login.setEnabled(!login.isEnabled());
            logout.setEnabled(!logout.isEnabled());
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarCultivo;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton inserirCultivo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem login;
    private javax.swing.JMenuItem logout;
    private javax.swing.JButton visualizarCultivo;
    // End of variables declaration//GEN-END:variables
}
