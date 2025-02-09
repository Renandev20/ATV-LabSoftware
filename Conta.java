import java.util.ArrayList;
import java.util.Scanner;

class Conta {
    private String nomeDoTitular;
    private float saldo;
    private int numero;


    public Conta(String nomeDoTitular, int numero, float saldoInicial) {
        this.nomeDoTitular = nomeDoTitular;
        this.numero = numero;
        this.saldo = saldoInicial;
    }


    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public boolean sacar(float valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
            return false;
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo da conta " + numero + ": " + saldo);
    }
}
