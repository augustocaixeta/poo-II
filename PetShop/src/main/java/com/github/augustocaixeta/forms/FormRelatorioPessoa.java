package com.github.augustocaixeta.forms;

import com.github.augustocaixeta.bo.PessoaBO;
import com.github.augustocaixeta.objetos.Pessoa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

public class FormRelatorioPessoa extends javax.swing.JFrame {
    private MaskFormatter dataInicioFormatted, dataFinalFormatted;
    PessoaBO pessoaBO = new PessoaBO();
    TableRowSorter<TableModel> sorter;
    
    private void pesquisar() {
        List<Pessoa> listaPessoas;

        String nome = jTxtNome.getText().trim();
        String dataInicio = jTxtDataInicio.getText().trim();
        String dataFinal = jTxtDataFinal.getText().trim();

        if (!nome.isEmpty() && dataInicio.length() == 4 && dataFinal.length() == 4) {
            listaPessoas = pessoaBO.getPessoas(nome);   
        } else if (!nome.isEmpty() && dataInicio.length() != 4 && dataFinal.length() != 4) {
            listaPessoas = pessoaBO.getPessoas(nome, dataInicio, dataFinal);
        } else if (dataInicio.length() != 4 && dataFinal.length() != 4) {
            listaPessoas = pessoaBO.getPessoas(dataInicio, dataFinal);
        } else {
            listaPessoas = pessoaBO.getPessoas();
        }
        
        if (!listaPessoas.isEmpty()) {
            preencherTabela(listaPessoas);
        }
    }
    
    public void preencherTabela(List<Pessoa> listaPessoas) {
        DefaultTableModel tabelaPessoas = (DefaultTableModel) jTabPessoas.getModel();
        jTabPessoas.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTabPessoas.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTabPessoas.getColumnModel().getColumn(2).setPreferredWidth(80);
        
        tabelaPessoas.setRowCount(0);

        listaPessoas.forEach(p -> {
            tabelaPessoas.addRow(new Object[] {
                p.getId(),
                p.getNome(),
                p.getDataNascimento()
            });
        });
        
        jTabPessoas.addMouseListener(new MouseAdapter() {
            int linSelecionada;
            int codSelecionado;
            
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    linSelecionada = jTabPessoas.getSelectedRow();
                    codSelecionado = (int) jTabPessoas.getValueAt(linSelecionada, 0);
                    
                    FormCadastroPessoa form = new FormCadastroPessoa(codSelecionado);
                    form.setVisible(true);
                }
            }
        });
    }
    
    public FormRelatorioPessoa() {
        initComponents();
        
        sorter = new TableRowSorter<> (jTabPessoas.getModel());
        jTabPessoas.setRowSorter(sorter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        try {
            dataInicioFormatted = new MaskFormatter("##/##/####");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível aplicar a mascara de data para este campo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        jTxtDataInicio = new JFormattedTextField(dataInicioFormatted);
        jLabel5 = new javax.swing.JLabel();
        try {
            dataFinalFormatted = new MaskFormatter("##/##/####");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível aplicar a mascara de data para este campo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        jTxtDataFinal = new JFormattedTextField(dataFinalFormatted);
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabPessoas = new javax.swing.JTable();
        jBtnFechar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTxtFiltro = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE PESSOA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RELATÓRIO DE PESSOAS");
        jLabel3.setMaximumSize(new java.awt.Dimension(226, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(226, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Consultar Pessoa"));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jTxtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTxtNomeCaretUpdate(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Data de Nascimento:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("até");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1)
                    .addComponent(jTxtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "#", "Nome", "Data de Nascimento"
            }
        ));
        jScrollPane1.setViewportView(jTabPessoas);

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtro:");

        jTxtFiltro.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTxtFiltroCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtFiltro))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnFechar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTxtNomeCaretUpdate
        pesquisar();
    }//GEN-LAST:event_jTxtNomeCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jTxtFiltroCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTxtFiltroCaretUpdate
        String conteudo = jTxtFiltro.getText();
        if (conteudo.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("^" + conteudo));
            } catch (PatternSyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTxtFiltroCaretUpdate

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
        
        java.awt.EventQueue.invokeLater(() -> new FormRelatorioPessoa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabPessoas;
    private javax.swing.JTextField jTxtDataFinal;
    private javax.swing.JTextField jTxtDataInicio;
    private javax.swing.JTextField jTxtFiltro;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
