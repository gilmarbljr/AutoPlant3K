package autoplant.ui.graphic.action;

import javax.swing.JOptionPane;

import autoplant.business.AccountManagementService;
import autoplant.business.BusinessException;
import autoplant.business.domain.Employee;
import autoplant.ui.graphic.AutoPlantGraphicInterface;

public class EmployeeLoginAction extends javax.swing.JFrame {
    
    private static final int COLUMNS = 10;
    private AutoPlantGraphicInterface autoPlantGraphicInterface;
    private AccountManagementService accountManagementService;

    /**
     * Creates new form EmployeeLoginAction
     */
    public EmployeeLoginAction(AutoPlantGraphicInterface autoPlantInterface, AccountManagementService accountManagementService) {
        this.autoPlantGraphicInterface = autoPlantInterface;
        this.accountManagementService = accountManagementService;
        initComponents();
        this.username.setColumns(COLUMNS);
        this.password.setColumns(COLUMNS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLUsarname = new javax.swing.JLabel();
        jLSenha = new javax.swing.JLabel();
        login = new javax.swing.JToggleButton();
        cadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        username.setBackground(new java.awt.Color(60, 120, 60));
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setToolTipText("");

        password.setBackground(new java.awt.Color(60, 120, 60));
        password.setForeground(new java.awt.Color(255, 255, 255));

        jLUsarname.setForeground(new java.awt.Color(5, 40, 5));
        jLUsarname.setText("Nome de usuário");

        jLSenha.setForeground(new java.awt.Color(5, 40, 5));
        jLSenha.setText("Senha");

        login.setBackground(new java.awt.Color(30, 90, 30));
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        cadastro.setBackground(new java.awt.Color(30, 90, 30));
        cadastro.setForeground(new java.awt.Color(255, 255, 255));
        cadastro.setText("Cadastro");
        cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLUsarname)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSenha)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cadastro))
                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLUsarname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastro)
                    .addComponent(login))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        try {
            Employee employee = accountManagementService.login(username.getText(), new String(password.getPassword()));
            autoPlantGraphicInterface.login(employee);
            dispose();
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_loginActionPerformed

    private void cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroActionPerformed
        CadastroAction action = new CadastroAction(accountManagementService);
        action.setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastro;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLUsarname;
    private javax.swing.JToggleButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
