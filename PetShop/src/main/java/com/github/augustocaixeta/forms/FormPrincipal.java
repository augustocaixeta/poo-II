package com.github.augustocaixeta.forms;

public class FormPrincipal extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPrincipal.class.getName());

    public FormPrincipal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCadastroPessoa = new javax.swing.JMenuItem();
        jMenuCadastroPet = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuRelatorioPessoa = new javax.swing.JMenuItem();
        jMenuRelatorioPet = new javax.swing.JMenuItem();
        jMenuOptFechar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastro");

        jMenuCadastroPessoa.setText("Pessoa");
        jMenuCadastroPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroPessoaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroPessoa);

        jMenuCadastroPet.setText("Pet");
        jMenuCadastroPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroPetActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroPet);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatório");

        jMenuRelatorioPessoa.setText("Pessoa");
        jMenuRelatorioPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioPessoaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRelatorioPessoa);

        jMenuRelatorioPet.setText("Pet");
        jMenuRelatorioPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioPetActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuRelatorioPet);

        jMenuBar1.add(jMenu2);

        jMenuOptFechar.setText("Fechar");
        jMenuOptFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOptFecharActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuOptFechar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastroPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroPessoaActionPerformed
        new FormCadastroPessoa().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroPessoaActionPerformed

    private void jMenuCadastroPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroPetActionPerformed
        new FormCadastroPet().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroPetActionPerformed

    private void jMenuRelatorioPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioPessoaActionPerformed
        new FormRelatorioPessoa().setVisible(true);
    }//GEN-LAST:event_jMenuRelatorioPessoaActionPerformed

    private void jMenuRelatorioPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioPetActionPerformed
        new FormRelatorioPet().setVisible(true);
    }//GEN-LAST:event_jMenuRelatorioPetActionPerformed

    private void jMenuOptFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOptFecharActionPerformed
        
    }//GEN-LAST:event_jMenuOptFecharActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FormPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadastroPessoa;
    private javax.swing.JMenuItem jMenuCadastroPet;
    private javax.swing.JMenu jMenuOptFechar;
    private javax.swing.JMenuItem jMenuRelatorioPessoa;
    private javax.swing.JMenuItem jMenuRelatorioPet;
    // End of variables declaration//GEN-END:variables
}
