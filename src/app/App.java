package app;

import br.com.banco.*;

public class App {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Flavio", "Seixas", "123456");

        Conta conta1 = new ContaCorrente(cliente1, 1, "UFF", "03/04/2019");
        Conta conta2 = new ContaPoupanca(cliente1, 1, "UFF", "03/04/2019");
        
        try {
            conta1.depositar(1000);
        }
        catch(IllegalArgumentException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        try {
            conta1.transferir(1001, conta2);
        }
        catch(IllegalArgumentException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        catch(SaldoInsuficienteException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        System.out.println("Conta 1: " + conta1.getSaldo());
        System.out.println("Conta 2: " + conta2.getSaldo());

    }
}