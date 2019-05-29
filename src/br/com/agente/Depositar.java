package br.com.agente;

import java.util.List;
import br.com.banco.Conta;

/**
 * Depositar
 */
public class Depositar implements Runnable {

    private final List<Conta> contas;
    private final double valor;

    public Depositar(List<Conta> contas, double valor) {
        this.contas = contas;
        this.valor = valor;
    }

    @Override
    public void run() {
        for(Conta conta: contas) {
            conta.depositar(this.valor);
        }
    }
}