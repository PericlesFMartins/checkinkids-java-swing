/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.periclesfmartins.checkinkids.ui;

import io.github.periclesfmartins.checkinkids.model.Responsavel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author pericles
 */
public class TelaResponsavel extends JFrame {
    private JTextField nomeField, cpfField, telefoneField, emailField, enderecoField, idadeField;

    public TelaResponsavel(){
        // Configurações básicas da janela
        setTitle("Etapa 1 de 3 - Dados do Responsável");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null); // Centraliza a janela

        // ANÁLISE E MUDANÇAS:
        // 1. Trocado GridLayout por GridBagLayout para melhor alinhamento.
        // 2. A criação dos componentes foi movida para um método separado (initComponents).
        initComponents();   
    }
    
    private void initComponents(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adiciona campos ao painel
        nomeField = addFormField(panel, gbc, "Nome Completo:", 0);
        cpfField = addFormField(panel, gbc, "CPF:", 1);
        telefoneField = addFormField(panel, gbc, "Telefone:", 2);
        emailField = addFormField(panel, gbc, "Email:", 3);
        enderecoField = addFormField(panel, gbc, "Endereço:", 4);
        idadeField = addFormField(panel, gbc, "Idade:", 5);

        // Botão Avançar
        JButton avancarButton = new JButton("Avançar");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(avancarButton, gbc);

        // ANÁLISE E MUDANÇAS:
        // 1. Usando Lambda Expression para o ActionListener. Fica mais limpo e moderno.
        // 2. A lógica foi movida para um método 'avancar()'.
        avancarButton.addActionListener(e -> avancar());
        
        add(panel);
    }
    
    // Método auxiliar para adicionar um label e um campo de texto
    private JTextField addFormField(JPanel panel, GridBagConstraints gbc, String labelText, int yPos) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        gbc.weightx = 0.1;
        panel.add(label, gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = yPos;
        gbc.weightx = 0.9;
        panel.add(textField, gbc);
        return textField;
    }

    private void avancar() {
        try {
            // Coleta e valida os dados
            int idade = Integer.parseInt(idadeField.getText());
            
            Responsavel responsavel = new Responsavel(
                nomeField.getText(),
                cpfField.getText(),
                telefoneField.getText(),
                emailField.getText(),
                enderecoField.getText(),
                idade
            );

            // Passa para a próxima tela
            new TelaCrianca(responsavel).setVisible(true);
            dispose(); // Fecha a tela atual

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "O campo 'Idade' deve ser um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
