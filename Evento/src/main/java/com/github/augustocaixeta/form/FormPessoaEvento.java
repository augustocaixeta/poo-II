package com.github.augustocaixeta.form;

import com.github.augustocaixeta.bo.EventoBO;
import com.github.augustocaixeta.bo.ParticipanteBO;
import com.github.augustocaixeta.bo.PessoaBO;
import com.github.augustocaixeta.objeto.Evento;
import com.github.augustocaixeta.objeto.Participante;
import com.github.augustocaixeta.objeto.Pessoa;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormPessoaEvento extends javax.swing.JFrame {
    EventoBO eventoBO;
    PessoaBO pessoaBO;
    ParticipanteBO participanteBO;
    
    List<Evento> eventos;
    List<Pessoa> pessoas;
    List<Participante> participantes;
    
    Evento eventoSelecionado;

    public FormPessoaEvento() {
        initComponents();
        
        pessoaBO = new PessoaBO();
        eventoBO = new EventoBO();
        participanteBO = new ParticipanteBO();
        
        participantes = participanteBO.consultarParticipantes();
        preencherEventoCombo();
        
        DefaultTableModel modelo = (DefaultTableModel) jTabEventoPessoa.getModel();
        modelo.setRowCount(0);
    }
    
    private void preencherEventoCombo() {
        eventos = eventoBO.consultarEventos();
        jCmbEventos.removeAllItems();
        for (Evento e : eventos) {
            jCmbEventos.addItem(e.getNome() + " (" + e.getId() + ")");
        }
    }
    
    private void atualizarPessoaComboParaEvento(Evento eventoSelecionado) {
        jCmbPessoas.removeAllItems();
        pessoas = pessoaBO.consultarPessoas();

        for (Pessoa pessoa : pessoas) {
            boolean jaVinculada = false;
            for (Participante p : participantes) {
                if (p.getEvento().getId() == eventoSelecionado.getId() &&
                    p.getPessoa().getId() == pessoa.getId()) {
                    jaVinculada = true;
                    break;
                }
            }
            if (!jaVinculada) {
                jCmbPessoas.addItem(pessoa);
            }
        }
    }
    
    private void adicionarTabelaEventoPessoa(Participante participante) {
        DefaultTableModel modelo = (DefaultTableModel) jTabEventoPessoa.getModel();
        modelo.addRow(new Object[] {
            participante.getEvento().getNome(),
            participante.getPessoa().getNome()
        });
    }
    
    private void vincularPessoaEvento() {
        int idxPessoa = jCmbPessoas.getSelectedIndex();
        int idxEvento = jCmbEventos.getSelectedIndex();

        if (idxPessoa >= 0 && idxEvento >= 0) {
            Pessoa pessoa = (Pessoa) jCmbPessoas.getSelectedItem();
            Evento evento = eventos.get(idxEvento);

            Participante participante = new Participante();
            participante.setEvento(evento);
            participante.setPessoa(pessoa);

            adicionarTabelaEventoPessoa(participante);
            jCmbPessoas.removeItemAt(idxPessoa);
        }
    }
    
    private void limparTabelaEventoPessoa() {
        DefaultTableModel modelo = (DefaultTableModel) jTabEventoPessoa.getModel();
        modelo.setRowCount(0);
    }
    
    private void salvarItensTabelaEventoPessoa() {
        DefaultTableModel modelo = (DefaultTableModel) jTabEventoPessoa.getModel();
        int rowCount = modelo.getRowCount();
        
        for (int i = 0; i < rowCount; i++) {
            String nomeEvento = modelo.getValueAt(i, 0).toString();
            String nomePessoa = modelo.getValueAt(i, 1).toString();

            Evento evento = null;
            for (Evento e : eventos) {
                if (e.getNome().equals(nomeEvento)) {
                    evento = e;
                    break;
                }
            }

            Pessoa pessoa = null;
            for (Pessoa p : pessoas) {
                if (p.getNome().equals(nomePessoa)) {
                    pessoa = p;
                    break;
                }
            }
            
            if (evento != null && pessoa != null) {
                Participante participante = new Participante();
                participante.setEvento(evento);
                participante.setPessoa(pessoa);
                participanteBO.vincularParticipante(participante);
                participantes.add(participante);
            }
        }
        
        JOptionPane.showMessageDialog(this, "Vínculos salvos com sucesso!");
        limparTabelaEventoPessoa();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCmbEventos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCmbPessoas = new javax.swing.JComboBox<>();
        jBtnVincular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabEventoPessoa = new javax.swing.JTable();
        jBtnFechar = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VINCULAR PESSOA AO EVENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vinculação"));

        jLabel2.setText("Eventos:");

        jCmbEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbEventosActionPerformed(evt);
            }
        });

        jLabel3.setText("Pessoas:");

        jBtnVincular.setText("Vincular");
        jBtnVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVincularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCmbEventos, 0, 412, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCmbPessoas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnVincular)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCmbEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCmbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnVincular))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabEventoPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Evento", "Pessoa"
            }
        ));
        jScrollPane1.setViewportView(jTabEventoPessoa);

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnFechar)
                    .addComponent(jBtnNovo)
                    .addComponent(jBtnSalvar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jBtnVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVincularActionPerformed
        vincularPessoaEvento();
    }//GEN-LAST:event_jBtnVincularActionPerformed

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        limparTabelaEventoPessoa();
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        salvarItensTabelaEventoPessoa();
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jCmbEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbEventosActionPerformed
        int idx = jCmbEventos.getSelectedIndex();
        if (idx >= 0) {
            eventoSelecionado = eventos.get(idx);
            atualizarPessoaComboParaEvento(eventoSelecionado);
        }
    }//GEN-LAST:event_jCmbEventosActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new FormCadastroPessoa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JButton jBtnVincular;
    private javax.swing.JComboBox<String> jCmbEventos;
    private javax.swing.JComboBox<Pessoa> jCmbPessoas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabEventoPessoa;
    // End of variables declaration//GEN-END:variables
}
