import java.time.LocalDate;
import java.time.Month;

public class TestaConta {
    public static void main(String[] args) {

        LocalDate dataNacimento = LocalDate.of(2003, Month.SEPTEMBER, 22);
        Cliente cliente = new Cliente("Kaioken", "02222222-12", dataNacimento, new Endereco());

        Conta contaCorrente = new Conta(cliente, "001", "1112-1", "Conta Corrente");
        contaCorrente.depositar(100);
        System.out.println(Conta.getTotalDeContas());

        double rendimentoAbril = contaCorrente.calcularRendimentoMensal(0.1);
        System.out.println("O rendimento de abril é " + rendimentoAbril);

        System.out.println(contaCorrente);

        Conta contaPoupanca = new Conta(cliente, "001", "1112-1", "Conta Poupança");
        contaPoupanca.depositar(1100);
        System.out.println(Conta.getTotalDeContas());

    }
}