//prof,lê o readme que eu fiz que lá eu explico o codigo, caso seja necessário
import java.util.Scanner;

interface MetodoPagamento {
    void processarPagamento(double valor);
    String verificarStatus();
}

class CartaoCredito implements MetodoPagamento {
    private String status;

    @Override
    public void processarPagamento(double valor) {
        if (valor <= 1000.00) {
            status = "Aprovado";
        } else {
            status = "Recusado";
        }
    }

    @Override
    public String verificarStatus() {
        return status;
    }
}

class Pix implements MetodoPagamento {
    private String status;

    @Override
    public void processarPagamento(double valor) {
        status = "Aprovado";
    }

    @Override
    public String verificarStatus() {
        return status;
    }
}

class Boleto implements MetodoPagamento {
    private String status;

    public Boleto() {
        status = "Pendente";
    }

    @Override
    public void processarPagamento(double valor) {
        status = "Pendente";
    }

    public void aprovarPagamento() {
        status = "Aprovado";
    }

    public void recusarPagamento() {
        status = "Recusado";
    }

    @Override
    public String verificarStatus() {
        return status;
    }
}

public class PagamentoSimples {
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
                System.out.println("não tem essa opçao irmão.");
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
}
