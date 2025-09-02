/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.periclesfmartins.checkinkids.ui;

import io.github.periclesfmartins.checkinkids.model.Crianca;
import io.github.periclesfmartins.checkinkids.model.Responsavel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author pericles
 */
public class TelaCrianca extends JFrame{
     private final Responsavel responsavel;
    private JTextField nomeField, idadeField, sexoField;

    public TelaCrianca(Responsavel responsavel) {
        this.responsavel = responsavel;

        // Configurações básicas da janela
        setTitle("Etapa 2 de 3 - Dados da Criança");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null); // Centraliza a janela

        // ANÁLISE E MUDANÇAS:
        // 1. A estrutura da UI foi padronizada com a tela anterior, usando um método dedicado.
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adiciona os campos ao painel
        nomeField = addFormField(panel, gbc, "Nome da Criança:", 0);
        idadeField = addFormField(panel, gbc, "Idade:", 1);
        sexoField = addFormField(panel, gbc, "Sexo (M/F):", 2);

        // Botão Avançar
        JButton avancarButton = new JButton("Avançar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(avancarButton, gbc);

        // ANÁLISE E MUDANÇAS:
        // 1. Lógica do botão movida para o método 'avancar()'.
        // 2. Usando lambda para o ActionListener.
        avancarButton.addActionListener(e -> avancar());

        add(panel);
    }
    
    // Método auxiliar reutilizado para adicionar campos
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
            int idade = Integer.parseInt(idadeField.getText());

            Crianca crianca = new Crianca(
                nomeField.getText(),
                idade,
                sexoField.getText(),
                this.responsavel // Objeto 'responsavel' recebido no construtor
            );

            // Passar para a próxima tela
            new TelaEstadia(this.responsavel, crianca).setVisible(true);
            dispose(); // Fecha a tela atual

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "O campo 'Idade' deve ser um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }   
}
