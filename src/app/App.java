package app;

import br.com.banco.*;

public class App {
    public static void main(String[] args) throws Exception {

        Cliente cliente1 = new Cliente("Flavio", "Seixas", "123456");

        Conta conta1 = new ContaCorrente(cliente1, 1, "UFF", "03/04/2019");
        Conta conta2 = new ContaPoupanca(cliente1, 1, "UFF", "03/04/2019");
        
        conta1.depositar(1000);
        conta2.depositar(1000);

        System.out.println("Saldo futuro para conta corrente: " + conta1.calcularSaldoFuturo(5));
        System.out.println("Saldo futuro para conta poupanca: " + conta2.calcularSaldoFuturo(5));


    }
}