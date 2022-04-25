import javax.management.openmbean.CompositeType;

public class TestaConta {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.nomeCompleto = "Kaioken";

        Data hoje = new Data();
        hoje.dia = 25;
        hoje.mes = 4;
        hoje.ano = 2022;

        Conta contaCorrente = new Conta();
        contaCorrente.agencia = "001";
        contaCorrente.numero = "1112-1";
        contaCorrente.ativa = true;
        contaCorrente.cliente = cliente;
        contaCorrente.dataDeAbertura = hoje;
        contaCorrente.limite = 400;
        contaCorrente.saldo = 100;
        contaCorrente.tipo = "Conta Corrente";

        
        Conta contaPoupanca = new Conta();
        contaPoupanca.agencia = "001";
        contaPoupanca.numero = "1112-1";
        contaPoupanca.ativa = true;
        contaPoupanca.cliente = cliente;
        contaPoupanca.dataDeAbertura = hoje;
        contaPoupanca.limite = 0;
        contaPoupanca.saldo = 1000;
        contaPoupanca.tipo = "Conta Poupança";
        
        if (contaCorrente == contaPoupanca) {
            System.out.println("Contas iguais. ");
        } else {
            System.out.println("Contas diferentes. ");
        }
        
        double rendimentoAbril = contaPoupanca.calcularRendimentoMensal(0.1);
        System.out.println("O rendimento de abril é " + rendimentoAbril);
        
        System.out.println(contaPoupanca.recuperarDadosParaImpressao());
        
    }
}
