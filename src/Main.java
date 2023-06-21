import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        do{
            System.out.println("""
                    \nBem vindo! O que deseja fazer?
                    \t1 - Entrar
                    \t2 - Cadastrar
                    \t3 - Mostrar Usuários Cadastrados
                    \t4 - Sair
                    """);
            int opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    ControleSistema.entrar();
                    break;
                case 2:
                    ControleSistema.cadastrar();
                    break;
                case 3:
                    ControleSistema.mostrarUsuariosCadastrados();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida! Tente novamente!");
            }
        }while (true);
    }
}
