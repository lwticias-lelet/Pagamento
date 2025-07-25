

pra rodar p codigo é so dar debug, ou se preferir pelo  comando  java PagamentoSimples
- Desenvolva um sistema de processamento de pagamentos que deve suportar múltiplas formas de pagamento (Cartão de Crédito, PIX e Boleto). Para garantir
flexibilidade e desacoplamento, utilize interface para definir o comportamento comum de cada método de pagamento. (7 pts)
 Foi declarado a interface e as 3 classes usam este inertafcem e a implemntam ultilizando diferentes metodos respeitando a particularidade de cada e  no main
 temos o desacoplamento pois não depende de classes especifiicas e há o polimorfismo.
Requisitos:
1. Crie uma interface MetodoPagamento com os seguintes métodos:
*void processarPagamento (double valor) : Processa o pagamento
* String verificarStatus( ) : Retorna o status do pagamento ("Aprovado", "Pendente", "Recusado")

2. Implemente três classes que implementam MetodoPagamento:
*CartaoCredito (deve ter um limite máximo de R$ 1.000,00 por transação)
* Pix (sempre processa instantaneamente)
* Boleto (sempre inicia como "Pendente" e pode ser alterado posteriormente)

3. Crie o método main para simular o processamento de cada um, exibindo seus status.
 este é o metodo main, é solicitado para o usuario escolher um metodo de pagamento, o valor e em seguida e exbidio seu sttatus de acordo com    
 a particularidade do pagamento escolhido.
 -- copiei do codigo aqui a parte main--
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Escolha o método de pagamento:");
    System.out.println("1 - Cartão de Crédito");
    System.out.println("2 - PIX");
    System.out.println("3 - Boleto");
    int escolha = scanner.nextInt();

    System.out.print("Digite o valor do pagamento: R$ ");
    double valor = scanner.nextDouble();

    MetodoPagamento pagamento = null;

    switch (escolha) {
        case 1:
            pagamento = new CartaoCredito();
            break;
        case 2:
            pagamento = new Pix();
            break;
        case 3:
            pagamento = new Boleto();
            break;
        default:
            System.out.println("Opção inválida.");
            System.exit(0);
    }

    pagamento.processarPagamento(valor);
    System.out.println("Status inicial: " + pagamento.verificarStatus());

    if (pagamento instanceof Boleto) {
        System.out.print("Deseja aprovar (A) ou recusar (R) o boleto? ");
        String opcao = scanner.next();

        if (opcao.equalsIgnoreCase("A")) {
            ((Boleto) pagamento).aprovarPagamento();
        } else if (opcao.equalsIgnoreCase("R")) {
            ((Boleto) pagamento).recusarPagamento();
        }

        System.out.println("Status atualizado: " + pagamento.verificarStatus());
    }

    scanner.close();
}
 o scanner é usado para ler os dados do console 