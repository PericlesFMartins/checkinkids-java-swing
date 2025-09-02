/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.periclesfmartins.checkinkids.main;

import io.github.periclesfmartins.checkinkids.ui.TelaResponsavel;
import javax.swing.SwingUtilities;

/**
 *
 * @author pericles
 */
public class Aplicacao {
        // ANÁLISE E MUDANÇAS:
    // 1. O nome da classe foi alterado para 'Aplicacao', que é mais semântico.
    // 2. O uso de SwingUtilities.invokeLater está correto e foi mantido, é a melhor prática!
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaResponsavel().setVisible(true);
        });
    } 
}
