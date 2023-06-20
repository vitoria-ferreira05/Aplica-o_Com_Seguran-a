import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;
        do{
            System.out.println("""
                    \nBem vindo! O que deseja fazer?
                    \t1 - Entrar
                    \t2 - Cadastrar
                    \t3 - Sair
                    """);
            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    ControleSistema.entrar();
                    break;
                case 2:
                    ControleSistema.cadastrar();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida! Tente novamente!");
            }
        }while (opcao!=3);

    }
}
