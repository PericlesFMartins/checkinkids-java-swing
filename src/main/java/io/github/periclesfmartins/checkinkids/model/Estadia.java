/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.periclesfmartins.checkinkids.model;

import java.util.Objects;

/**
 *
 * @author pericles
 */
public class Estadia {
    private Responsavel responsavel;
    private Crianca crianca;
    private int tempoUtilizadoMinutos;
    
    // ANÁLISE E MUDANÇAS:
    // 1. O nome da variável 'tempoUtilizado' foi melhorado para 'tempoUtilizadoMinutos' para maior clareza.
    // 2. Adicionada validação para tempo não negativo.
    public Estadia(Responsavel responsavel, Crianca crianca, int tempoUtilizadoMinutos) {
        if (tempoUtilizadoMinutos < 0) {
            throw new IllegalArgumentException("O tempo utilizado não pode ser negativo.");
        }
        this.responsavel = Objects.requireNonNull(responsavel);
        this.crianca = Objects.requireNonNull(crianca);
        this.tempoUtilizadoMinutos = tempoUtilizadoMinutos;
    }

    // Getters
    public Responsavel getResponsavel() { return responsavel; }
    public Crianca getCrianca() { return crianca; }
    public int getTempoUtilizadoMinutos() { return tempoUtilizadoMinutos; }
}
