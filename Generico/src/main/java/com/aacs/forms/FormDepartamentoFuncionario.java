package com.aacs.forms;

import com.aacs.bo.DepartamentoBO;
import com.aacs.bo.FuncionarioBO;
import com.aacs.modelos.Departamento;
import com.aacs.modelos.Funcionario;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class FormDepartamentoFuncionario extends javax.swing.JFrame {
    private final DepartamentoBO departamentoBO;
    private final FuncionarioBO funcionarioBO;
    
    private List<Departamento> departamentos;
    private final List<Funcionario> novosFuncionariosParaSalvar;
    
    private Departamento departamentoSelecionado;
    
    public FormDepartamentoFuncionario() {
        initComponents();
        
        jTxtDeptID.setEnabled(false);
        jTxtDeptNome.setEnabled(false);
        jTxtFuncID.setEnabled(false);
        
        departamentoBO = new DepartamentoBO();
        funcionarioBO = new FuncionarioBO();
        novosFuncionariosParaSalvar = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtDeptNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtDeptID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTxtFuncID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtFuncNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtFuncSalario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
            jTxtFuncDataNasc = new JFormattedTextField(mascaraData);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        jTxtFuncDataNasc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTxtConsultarDept = new javax.swing.JTextField();
        jCmbDept = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jBtnConsultar = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();
        jBtnRemover = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabDeptFunc = new javax.swing.JTable();
        jBtnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CADASTRO DE FUNCIONÁRIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(22, 22, 22))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Departamento"));

        jLabel1.setText("Nome:");

        jLabel2.setText("ID:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtDeptID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtDeptNome)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtDeptNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtDeptID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Funcionario"));

        jLabel4.setText("ID:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Data de Nascimento:");

        jLabel7.setText("Salário (R$):");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFuncID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTxtFuncDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFuncSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtFuncNome))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtFuncID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtFuncNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtFuncSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtFuncDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Consulta Departamento"));

        jLabel8.setText("Nome:");

        jTxtConsultarDept.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTxtConsultarDeptCaretUpdate(evt);
            }
        });

        jLabel9.setText("Departamentos:");

        jBtnConsultar.setText("Consultar");
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCmbDept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConsultar)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtConsultarDept)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtConsultarDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jBtnConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jBtnRemover.setText("Remover");
        jBtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverActionPerformed(evt);
            }
        });

        jBtnSalvar.setText("Salvar");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jTabDeptFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Departamento", "Funcionário"
            }
        ));
        jScrollPane1.setViewportView(jTabDeptFunc);

        jBtnAdicionar.setText("Adicionar");
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBtnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnRemover)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnFechar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnFechar)
                    .addComponent(jBtnRemover)
                    .addComponent(jBtnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void preencherComboDept() {
        String nome = jTxtConsultarDept.getText();
        jCmbDept.removeAllItems();
        if (!nome.isEmpty()) {
            departamentos = departamentoBO.buscarDepartamentos(nome);
            departamentos.forEach(d -> {
                jCmbDept.addItem(d);
            });
        }
    }
    
    private void limparCamposFuncionario() {
        jTxtFuncNome.setText("");
        jTxtFuncDataNasc.setText("");
        jTxtFuncSalario.setText("");
        jTxtFuncNome.requestFocusInWindow(); 
    }
    
    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) jTabDeptFunc.getModel();
        model.setRowCount(0);
    }
    
    private void jTxtConsultarDeptCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTxtConsultarDeptCaretUpdate
        preencherComboDept();
    }//GEN-LAST:event_jTxtConsultarDeptCaretUpdate

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed
        int index = jCmbDept.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um departamento.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 1. Guarda o objeto do departamento selecionado na nossa variável de classe
        // Suponho que 'departamentos' seja a lista que popula o jCmbDept
        this.departamentoSelecionado = departamentos.get(index);

        // 2. Atualiza os campos de texto do departamento na tela
        jTxtDeptID.setText(String.valueOf(departamentoSelecionado.getId()));
        jTxtDeptNome.setText(departamentoSelecionado.getNome());

        // 3. Habilita os campos do funcionário para digitação
        jTxtFuncNome.setEnabled(true);
        jTxtFuncDataNasc.setEnabled(true);
        jTxtFuncSalario.setEnabled(true);
        jBtnAdicionar.setEnabled(true);

        // 4. Limpa a tabela e a lista de salvamento, pois um novo departamento foi selecionado
        novosFuncionariosParaSalvar.clear();
        limparTabela(); // Método auxiliar para limpar a JTable

        System.out.println("Departamento '" + departamentoSelecionado.getNome() + "' selecionado.");
    }//GEN-LAST:event_jBtnConsultarActionPerformed

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverActionPerformed
        int selectedRow = jTabDeptFunc.getSelectedRow();
        if (selectedRow >= 0) {
            novosFuncionariosParaSalvar.remove(selectedRow);

            DefaultTableModel model = (DefaultTableModel) jTabDeptFunc.getModel();
            model.removeRow(selectedRow);

            JOptionPane.showMessageDialog(this, "Funcionário removido da lista com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um funcionário na tabela para excluir.", "Nenhum item selecionado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnRemoverActionPerformed

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        // 1. Verifica se um departamento foi selecionado antes
        if (departamentoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Você precisa buscar e selecionar um departamento primeiro!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Pega os dados dos campos de texto
        String nome = jTxtFuncNome.getText();
        String dataNascStr = jTxtFuncDataNasc.getText();
        String salarioStr = jTxtFuncSalario.getText();

        // 3. Validação dos campos
        if (nome.trim().isEmpty() || dataNascStr.trim().isEmpty() || salarioStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos do funcionário devem ser preenchidos.", "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataNascStr, formatadorData);

            salarioStr = salarioStr.replace(".", "").replace(",", "."); 
            double salario = Double.parseDouble(salarioStr);

            Funcionario novoFuncionario = new Funcionario();
            novoFuncionario.setNome(nome);
            novoFuncionario.setNascimento(dataNascimento);
            novoFuncionario.setSalario(salario);
            novoFuncionario.setDepartamento(departamentoSelecionado);
            // O ID será gerado pelo banco de dados no momento do INSERT

            // 6. Adiciona o novo funcionário à nossa lista de espera
            novosFuncionariosParaSalvar.add(novoFuncionario);

            // 7. Adiciona a representação visual na JTable
            DefaultTableModel model = (DefaultTableModel) jTabDeptFunc.getModel();
            
            Object[] rowToAdd = new Object[] {
                departamentoSelecionado.getNome(), // Valor para a Coluna 1
                novoFuncionario.getNome()          // Valor para a Coluna 2
            };

            model.addRow(rowToAdd);

            // 8. Limpa os campos para o usuário poder adicionar o próximo funcionário
            limparCamposFuncionario();

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido! Use dd/MM/yyyy.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de salário inválido! Use apenas números.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        // 1. Verifica se há funcionários na lista de espera para salvar
        if (novosFuncionariosParaSalvar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum novo funcionário foi adicionado para salvar.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // 2. Itera sobre a lista de objetos Funcionario (que é a forma correta e segura)
        for (Funcionario funcParaSalvar : novosFuncionariosParaSalvar) {
            funcionarioBO.salvar(funcParaSalvar);
        }

        // 4. Se tudo deu certo, exibe mensagem de sucesso
        JOptionPane.showMessageDialog(this, 
            novosFuncionariosParaSalvar.size() + " funcionário(s) salvo(s) com sucesso!", 
            "Sucesso", 
            JOptionPane.INFORMATION_MESSAGE);

        // 5. Limpa tudo para uma nova operação
        novosFuncionariosParaSalvar.clear();
        limparTabela();
        limparCamposFuncionario();
        
        // Opcional: limpar também os campos do departamento
        jTxtDeptID.setText("");
        jTxtDeptNome.setText("");
        this.departamentoSelecionado = null;
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FormDepartamentoFuncionario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnRemover;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<Departamento> jCmbDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabDeptFunc;
    private javax.swing.JTextField jTxtConsultarDept;
    private javax.swing.JTextField jTxtDeptID;
    private javax.swing.JTextField jTxtDeptNome;
    private javax.swing.JTextField jTxtFuncDataNasc;
    private javax.swing.JTextField jTxtFuncID;
    private javax.swing.JTextField jTxtFuncNome;
    private javax.swing.JTextField jTxtFuncSalario;
    // End of variables declaration//GEN-END:variables
}
