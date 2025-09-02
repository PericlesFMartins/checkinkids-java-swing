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
public class Crianca {
    private String nome;
    private int idade;
    private String sexo;
    private Responsavel responsavel;
    
    // ANÁLISE E MUDANÇAS:
    // 1. Adicionada a mesma validação para campos de texto.
    public Crianca(String nome, int idade, String sexo, Responsavel responsavel) {
        if (idade <= 0 || idade > 10) {
            throw new IllegalArgumentException("A criança deve ter entre 1 e 10 anos.");
        }
        this.nome = requireNonBlank(nome, "O campo 'Nome da Criança' é obrigatório.");
        this.sexo = requireNonBlank(sexo, "O campo 'Sexo' é obrigatório.");
        this.idade = idade;
        this.responsavel = Objects.requireNonNull(responsavel, "A criança deve ter um responsável.");
    }
    
    private String requireNonBlank(String value, String message) {
        if (Objects.requireNonNull(value, message).isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    // Getters
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getSexo() { return sexo; }
    public Responsavel getResponsavel() { return responsavel; }   
}
