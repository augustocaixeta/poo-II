package com.github.augustocaixeta.forms;

import com.github.augustocaixeta.bo.PessoaBO;
import com.github.augustocaixeta.bo.PetBO;
import com.github.augustocaixeta.objetos.Pessoa;
import com.github.augustocaixeta.objetos.Pet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FormCadastroPet extends javax.swing.JFrame {
    PetBO petBO = new PetBO();
    PessoaBO pessoaBO = new PessoaBO();
    
    private List<Pet> listaPets;
    private List<Pessoa> listaPessoas;
    
    private void preencherCombo() {
        String nome = jTxtConsultaNome.getText();
        if (!nome.isEmpty()) {
            listaPets = petBO.getPets(nome);
            jCmbPets.removeAllItems();
            listaPets.forEach(itemPet -> {
                jCmbPets.addItem(itemPet.getNome() + "[" + itemPet.getId() + "]");
            });
        } else {
            jCmbPets.removeAllItems();
        }
    }
    
    private void preencherCampos(Pet pet) {
        jTxtCodigo.setText(String.valueOf(pet.getId()));
        jTxtDataNascimento.setText(pet.getDataNascimento());
        jTxtNome.setText(pet.getNome());
        jTxtRaca.setText(pet.getRaca());
        jTxtCor.setText(pet.getCor());
        jTxtPorte.setText(pet.getPorte());
        listaPessoas = new ArrayList<>();
        listaPessoas.add(pet.getPessoa());
        jCmbPessoas.addItem(pet.getPessoa().getNome() + "[" + pet.getPessoa().getId() + "]");
        jBtnSalvar.setEnabled(false);
    }
    
    private void preencherCampos() {
        if (!listaPets.isEmpty()) {
            Pet pet = listaPets.get(jCmbPets.getSelectedIndex());
            preencherCampos(pet);
        }
    }
    
    private void preencherComboPessoa() {
        String nome = jTxtPessoaNome.getText();
        if (nome.isEmpty()) {
            listaPessoas = pessoaBO.getPessoas(nome);
            jCmbPessoas.removeAllItems();
            listaPessoas.forEach(itemPessoa -> {
                jCmbPessoas.addItem(itemPessoa.getNome() + "[" + itemPessoa.getId() + "]");
            });
        } else {
            jCmbPessoas.removeAllItems();
        }
    }
    
    private void limparCampos() {
        jTxtConsultaNome.setText("");
        jTxtCodigo.setText("");
        jTxtNome.setText("");
        jTxtDataNascimento.setText("");
        jTxtRaca.setText("");
        jTxtCor.setText("");
        jTxtPorte.setText("");
        jTxtPessoaNome.setText("");
        jCmbPessoas.removeAllItems();
        jBtnSalvar.setEnabled(true);
        
    }
    
    public FormCadastroPet() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLblTitulo = new javax.swing.JLabel();
        jPanelConsultarPet = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtConsultaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCmbPets = new javax.swing.JComboBox<>();
        jBtnConsultar = new javax.swing.JButton();
        jPanelDadosPet = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTxtDataNascimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtRaca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtCor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtPorte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtPessoaNome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jCmbPessoas = new javax.swing.JComboBox<>();
        jBtnFecar = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblTitulo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("CADASTRO PET");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLblTitulo)
                .addContainerGap())
        );

        jPanelConsultarPet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Consultar Pet"));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jTxtConsultaNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTxtConsultaNomeCaretUpdate(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Pet:");

        jBtnConsultar.setText("Consultar");
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultarPetLayout = new javax.swing.GroupLayout(jPanelConsultarPet);
        jPanelConsultarPet.setLayout(jPanelConsultarPetLayout);
        jPanelConsultarPetLayout.setHorizontalGroup(
            jPanelConsultarPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultarPetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultarPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConsultarPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtConsultaNome)
                    .addGroup(jPanelConsultarPetLayout.createSequentialGroup()
                        .addComponent(jCmbPets, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConsultar)))
                .addContainerGap())
        );
        jPanelConsultarPetLayout.setVerticalGroup(
            jPanelConsultarPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultarPetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsultarPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConsultarPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCmbPets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDadosPet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Pet"));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Código:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Data de Nascimento:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Nome:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Raça:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Cor:");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel9.setText("Porte:");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setText("Pessoa:");

        jTxtPessoaNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTxtPessoaNomeCaretUpdate(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setText("Pessoas:");

        javax.swing.GroupLayout jPanelDadosPetLayout = new javax.swing.GroupLayout(jPanelDadosPet);
        jPanelDadosPet.setLayout(jPanelDadosPetLayout);
        jPanelDadosPetLayout.setHorizontalGroup(
            jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosPetLayout.createSequentialGroup()
                        .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDataNascimento))
                    .addComponent(jTxtNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosPetLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelDadosPetLayout.createSequentialGroup()
                                .addComponent(jTxtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtPorte, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtPessoaNome)
                            .addComponent(jCmbPessoas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );

        jPanelDadosPetLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTxtCor, jTxtPorte, jTxtRaca});

        jPanelDadosPetLayout.setVerticalGroup(
            jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTxtPessoaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jCmbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnFecar.setText("Fechar");
        jBtnFecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecarActionPerformed(evt);
            }
        });

        jBtnNovo.setText("Novo");
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnEditar.setText("Editar");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
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
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDadosPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelConsultarPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnFecar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelConsultarPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDadosPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnFecar)
                    .addComponent(jBtnNovo)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnSalvar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtConsultaNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTxtConsultaNomeCaretUpdate
        preencherCombo();
    }//GEN-LAST:event_jTxtConsultaNomeCaretUpdate

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed
        preencherCampos();
    }//GEN-LAST:event_jBtnConsultarActionPerformed

    private void jTxtPessoaNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTxtPessoaNomeCaretUpdate
        preencherComboPessoa();
    }//GEN-LAST:event_jTxtPessoaNomeCaretUpdate

    private void jBtnFecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnFecarActionPerformed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        Pet pet = new Pet();
        pet.setId(Integer.parseInt(jTxtCodigo.getText()));
        int sucesso = petBO.excluir(pet);
        if (sucesso == 1) {
            limparCampos();
            JOptionPane.showMessageDialog(null, "Pet excluído com sucesso.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir este pet.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        Pet pet = new Pet();
        pet.setId(Integer.parseInt(jTxtCodigo.getText()));
        pet.setNome(jTxtNome.getText());
        pet.setDataNascimento(jTxtDataNascimento.getText());
        pet.setRaca(jTxtRaca.getText());
        pet.setCor(jTxtCor.getText());
        pet.setPorte(jTxtPorte.getText());
        pet.setPessoa(listaPessoas.get(jCmbPessoas.getSelectedIndex()));
        petBO.editar(pet);
        JOptionPane.showMessageDialog(null, "Pet editado com sucesso.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        Pet pet = new Pet();
        pet.setNome(jTxtNome.getText());
        pet.setDataNascimento(jTxtDataNascimento.getText());
        pet.setRaca(jTxtRaca.getText());
        pet.setCor(jTxtCor.getText());
        pet.setPorte(jTxtPorte.getText());
        pet.setPessoa(listaPessoas.get(jCmbPessoas.getSelectedIndex()));
        petBO.salvar(pet);
        
        int petId = pet.getId();
        if (petId >= 0) {
            jTxtCodigo.setText(String.valueOf(petId));
            JOptionPane.showMessageDialog(null, "Pet salvo com sucesso.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar este pet.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnSalvarActionPerformed

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
        
        java.awt.EventQueue.invokeLater(() -> new FormCadastroPet().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnFecar;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JComboBox<String> jCmbPessoas;
    private javax.swing.JComboBox<String> jCmbPets;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JPanel jPanelConsultarPet;
    private javax.swing.JPanel jPanelDadosPet;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtConsultaNome;
    private javax.swing.JTextField jTxtCor;
    private javax.swing.JTextField jTxtDataNascimento;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtPessoaNome;
    private javax.swing.JTextField jTxtPorte;
    private javax.swing.JTextField jTxtRaca;
    // End of variables declaration//GEN-END:variables
}
