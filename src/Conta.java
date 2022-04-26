import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conta {
    private boolean ativa;
    private String agencia;
    private String numero;
    private double limite;
    private String tipo;
    private double saldo;
    private LocalDateTime dataDeAbertura;
    private Cliente cliente;
    private static int contador;

    Conta(Cliente cliente, String agencia, String numero, String tipo) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numero = numero;
        this.ativa = true;
        this.tipo = tipo;
        this.saldo = 0;
        this.dataDeAbertura = LocalDateTime.now();
        Conta.contador++;
    }

    boolean sacar(double quantidade) {
        double novoSaldo = this.saldo - quantidade;
        if (novoSaldo >= 0) {
            this.saldo = novoSaldo;
            return true;
        } else {
            mensagemSaldoInsuficiente();
            return false;
        }
    }

    private void mensagemSaldoInsuficiente() {
        System.out.println("Saldo insuficiente!");
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

    public void almentarLimite(double valor){
        this.limite += valor;
    }
    
    

    public String getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataDeAbertura() {
        return dataDeAbertura;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalDeContas(){
        return Conta.contador;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo + this.getLimite();
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    @Override
    public String toString() {
        return this.cliente + "\n" +
                "AG: " + this.agencia + "\n" +
                "CC: " + this.numero + "\n" +
                "Data de abertura: " + this.dataDeAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "Saldo: " + String.format("%.2f", this.saldo);

    }

}