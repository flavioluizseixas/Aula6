package app;

import java.util.Arrays;
import java.util.List;
import br.com.agente.Depositar;
import br.com.banco.*;

public class App {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Flavio", "Seixas", "123456");

        Conta conta1 = new ContaCorrente(cliente1, 1, "UFF", "03/04/2019");
        Conta conta2 = new ContaCorrente(cliente1, 2, "UFF", "03/04/2019");
        Conta conta3 = new ContaCorrente(cliente1, 3, "UFF", "03/04/2019");
        Conta conta4 = new ContaCorrente(cliente1, 4, "UFF", "03/04/2019");

        List<Conta> contas = Arrays.asList(conta1, conta2, conta3, conta4);

        Thread t1 = new Thread(new Depositar(contas, 1000));
        Thread t2 = new Thread(new Depositar(contas, 1000));
        Thread t3 = new Thread(new Depositar(contas, 1000));
        Thread t4 = new Thread(new Depositar(contas, 1000));
        Thread t5 = new Thread(new Depositar(contas, 1000));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        for (Conta conta: contas) {
            System.out.println("Conta numero " + conta.getNumero() + ". Saldo é " + conta.getSaldo());
        }

    }
}