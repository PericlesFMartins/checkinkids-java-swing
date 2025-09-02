/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.periclesfmartins.checkinkids.service;

import io.github.periclesfmartins.checkinkids.model.Estadia;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author pericles
 */
public class EstadiaService {
     private static final double VALOR_POR_MINUTO = 1.50;

    // ANÁLISE E MUDANÇAS:
    // 1. A lógica de cálculo foi movida da classe 'Estadia' para cá.
    //    Isso é bom porque se a regra de cálculo mudar, mexemos apenas no serviço, não no modelo.
    public double calcularValor(Estadia estadia) {
        int tempo = estadia.getTempoUtilizadoMinutos();
        double valorBase = tempo * VALOR_POR_MINUTO;
        double descontoPercentual = 0.0;

        if (tempo > 60) {
            descontoPercentual = 0.15; // 15%
        } else if (tempo > 40) {
            descontoPercentual = 0.10; // 10%
        } else if (tempo > 20) {
            descontoPercentual = 0.05; // 5%
        }

        return valorBase * (1 - descontoPercentual);
    }

    // ANÁLISE E MUDANÇAS:
    // 1. A criação da string de resumo foi movida da tela para cá.
    //    A tela agora só precisa chamar este método, sem se preocupar com a formatação.
    public String gerarResumo(Estadia estadia) {
        double valorFinal = calcularValor(estadia);
        // Formata o valor para o padrão de moeda brasileiro (R$)
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        return String.format("""
            --- Resumo da Estadia ---
            
            [DADOS DO RESPONSÁVEL]
            Nome: %s
            CPF: %s
            
            [DADOS DA CRIANÇA]
            Nome: %s
            Idade: %d anos
            
            [DADOS DA ESTADIA]
            Tempo no Brinquedo: %d minutos
            Valor a Pagar: %s
            """,
            estadia.getResponsavel().getNome(),
            estadia.getResponsavel().getCpf(),
            estadia.getCrianca().getNome(),
            estadia.getCrianca().getIdade(),
            estadia.getTempoUtilizadoMinutos(),
            formatadorMoeda.format(valorFinal)
        );
    }  
}
