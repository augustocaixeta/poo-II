package com.github.augustocaixeta.form;

public class FormPrincipal extends javax.swing.JFrame {
    public FormPrincipal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jItemCadastroPessoa = new javax.swing.JMenuItem();
        jItemCadastroEvento = new javax.swing.JMenuItem();
        jItemVincular = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jItemRelatorioParticipantes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastro");

        jItemCadastroPessoa.setText("Pessoa");
        jItemCadastroPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemCadastroPessoaActionPerformed(evt);
            }
        });
        jMenu1.add(jItemCadastroPessoa);

        jItemCadastroEvento.setText("Evento");
        jItemCadastroEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemCadastroEventoActionPerformed(evt);
            }
        });
        jMenu1.add(jItemCadastroEvento);

        jItemVincular.setText("Vincular");
        jItemVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemVincularActionPerformed(evt);
            }
        });
        jMenu1.add(jItemVincular);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatorio");

        jItemRelatorioParticipantes.setText("Participantes");
        jItemRelatorioParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemRelatorioParticipantesActionPerformed(evt);
            }
        });
        jMenu2.add(jItemRelatorioParticipantes);

        jMenuBar1.add(jMenu2);

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

    private void jItemCadastroPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemCadastroPessoaActionPerformed
        new FormCadastroPessoa().setVisible(true);
    }//GEN-LAST:event_jItemCadastroPessoaActionPerformed

    private void jItemCadastroEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemCadastroEventoActionPerformed
        new FormCadastroEvento().setVisible(true);
    }//GEN-LAST:event_jItemCadastroEventoActionPerformed

    private void jItemRelatorioParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemRelatorioParticipantesActionPerformed
        new FormRelatorioParticipante().setVisible(true);
    }//GEN-LAST:event_jItemRelatorioParticipantesActionPerformed

    private void jItemVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemVincularActionPerformed
        new FormPessoaEvento().setVisible(true);
    }//GEN-LAST:event_jItemVincularActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jItemCadastroEvento;
    private javax.swing.JMenuItem jItemCadastroPessoa;
    private javax.swing.JMenuItem jItemRelatorioParticipantes;
    private javax.swing.JMenuItem jItemVincular;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
