/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.periclesfmartins.checkinkids.ui;

import io.github.periclesfmartins.checkinkids.model.Crianca;
import io.github.periclesfmartins.checkinkids.model.Estadia;
import io.github.periclesfmartins.checkinkids.model.Responsavel;
import io.github.periclesfmartins.checkinkids.service.EstadiaService;
   
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author pericles
 */
public class TelaEstadia extends JFrame {
    private final Responsavel responsavel;
    private final Crianca crianca;
    private JTextField tempoUtilizadoField;

    public TelaEstadia(Responsavel responsavel, Crianca crianca) {
        this.responsavel = responsavel;
        this.crianca = crianca;

        setTitle("Etapa 3 de 3 - Dados da Estadia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 200);
        setLocationRelativeTo(null); // Centraliza

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Adiciona o campo de tempo
        tempoUtilizadoField = addFormField(panel, gbc, "Tempo Utilizado (minutos):", 0);

        // Botão de Calcular
        JButton calcularButton = new JButton("Calcular e Mostrar Resumo");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(calcularButton, gbc);

        // ANÁLISE E MUDANÇAS:
        // 1. A lógica agora está no método 'calcularEExibirResumo()'.
        calcularButton.addActionListener(e -> calcularEExibirResumo());

        add(panel);
    }
    
    private JTextField addFormField(JPanel panel, GridBagConstraints gbc, String labelText, int yPos) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = yPos;
        panel.add(textField, gbc);
        return textField;
    }

    private void calcularEExibirResumo() {
        try {
            int tempoUtilizado = Integer.parseInt(tempoUtilizadoField.getText());
            
            // 1. Cria o objeto Estadia
            Estadia estadia = new Estadia(responsavel, crianca, tempoUtilizado);
            
            // 2. Cria uma instância do nosso serviço de lógica de negócio
            EstadiaService service = new EstadiaService();
            
            // 3. Pede para o serviço gerar o resumo formatado
            String resumo = service.gerarResumo(estadia);
            
            // 4. Exibe o resumo
            JOptionPane.showMessageDialog(
                this, 
                resumo, 
                "Resumo da Estadia", 
                JOptionPane.INFORMATION_MESSAGE
            );

            // 5. Finaliza a aplicação após exibir o resumo.
            //    Este é o fim do fluxo do programa.
            dispose();
            System.exit(0);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "O campo 'Tempo' deve ser um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }
}
