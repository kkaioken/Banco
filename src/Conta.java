public class Conta {
    boolean ativa;
    String agencia;
    String numero;
    double limite;
    String tipo;
    double saldo;
    Data dataDeAbertura;
    Cliente cliente;

    boolean sacar(double quantidade) {
        double novoSaldo = this.saldo - quantidade;
        if (novoSaldo >= 0) {
            this.saldo = novoSaldo;
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    void depositar(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Valor invalido!");
        } else {
            this.saldo += quantidade;
        }
    }

    void pix(double valorPIx, Conta contaDestino) {
        if (this.sacar(valorPIx)) {
            contaDestino.depositar(valorPIx);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    double calcularRendimentoMensal(double taxa) {
        return this.saldo * taxa;
    }

    String recuperarDadosParaImpressao() {
        return "nome do titular: " + this.cliente.nomeCompleto + "\n" +
                "AG: " + this.agencia + "\n" +
                "CC: " + this.numero + "\n" +
                "Data de abertura: " + this.dataDeAbertura.toString() + "\n" +
                "Saldo: " + String.format("%.2f", this.saldo);
                
    }

}
