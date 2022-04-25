public class Banco {
    public static void main(String[] args) throws Exception {
        Conta conta = new Conta();
        conta.ativa = true;
        conta.agencia = "77666";
        conta.numero = "12346789";
        conta.tipo = "Conta Corrente";
        conta.limite = 5000;
        conta.depositar(70);

        Conta novaConta = new Conta();
        novaConta.ativa = true;
        novaConta.agencia = "77636";
        novaConta.numero = "11346789";
        novaConta.tipo = "Conta Corrente";
        novaConta.limite = 5000;
        novaConta.depositar(20);
        
        conta.pix(60, novaConta);

        System.out.println("Saldo na conta é: R$" + conta.saldo);
        System.out.println("Saldo da nova conta é: R$" + novaConta.saldo);

        Cliente cliente = new Cliente();
        cliente.nomeCompleto = "Kaioken Rodrigues";
        cliente.cpf = "022.544.777-11";
        cliente.dataNascimento = "22/09/2003";
        Endereco endereco = new Endereco();
        endereco.cep = "11779-120";
        endereco.bairro = "Vila Nasser";
        endereco.rua = "Rua Benedito Pache Terra";
        endereco.casa = "399";
        cliente.endereco = endereco;

        conta.cliente = cliente;
    }
}
