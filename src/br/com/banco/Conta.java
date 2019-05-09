package br.com.banco;

/**
 * Conta
 */
abstract public class Conta {

    private Cliente titular;
    private int numero;
    private String agencia;
    private double saldo;
    private String dataAbertura;

    public Conta(Cliente titular, int numero, String agencia, String dataAbertura) {
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 0;
        this.dataAbertura = dataAbertura;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        this.saldo -= valor;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        this.saldo += valor;
    }

    abstract public double calcularRendimento(int periodo);

    abstract public double calcularTributacao(int periodo);

    public void transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double calcularSaldoFuturo(int periodo) {

        return this.saldo *
            (1 + this.calcularRendimento(periodo) -
            this.calcularTributacao(periodo));

    }
}