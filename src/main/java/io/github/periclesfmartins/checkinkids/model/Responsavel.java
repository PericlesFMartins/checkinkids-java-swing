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
public class Responsavel {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private int idade;

    // ANÁLISE E MUDANÇAS:
    // 1. Adicionada validação para garantir que os campos de texto não sejam nulos ou vazios.
    //    Isso torna o objeto mais robusto. A função 'requireNonBlank' foi criada para isso.
    public Responsavel(String nome, String cpf, String telefone, String email, String endereco, int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("O responsável deve ser maior de idade (18 anos ou mais).");
        }
        this.nome = requireNonBlank(nome, "O campo 'Nome' é obrigatório.");
        this.cpf = requireNonBlank(cpf, "O campo 'CPF' é obrigatório.");
        this.telefone = requireNonBlank(telefone, "O campo 'Telefone' é obrigatório.");
        this.email = email; // E-mail pode ser opcional, então não validamos
        this.endereco = requireNonBlank(endereco, "O campo 'Endereço' é obrigatório.");
        this.idade = idade;
    }

    private String requireNonBlank(String value, String message) {
        // Objects.requireNonNull garante que o valor não seja nulo.
        // value.isBlank() verifica se a string está vazia ou contém apenas espaços.
        if (Objects.requireNonNull(value, message).isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getEndereco() { return endereco; }
    public int getIdade() { return idade; }
}
