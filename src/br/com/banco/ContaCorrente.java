package br.com.banco;

/**
 * Conta
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente titular, int numero, String agencia, String dataAbertura) {
        super(titular, numero, agencia, dataAbertura);
    }    

    public double calcularRendimento(int periodo) {
        return (Math.pow(1.1, periodo) - 1);
    }

    public double calcularTributacao(int periodo) {
        return calcularRendimento(periodo) * 0.15;
    }

}