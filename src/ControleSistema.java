import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleSistema {
    static Scanner entrada = new Scanner(System.in);
    static List<Usuario> usuariosCadastrados = new ArrayList<>();

    public static void entrar(){
        System.out.print("Digite o email: ");
        String email = entrada.nextLine();

        if (!email.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }

        System.out.print("Digite a senha: ");
        String senha = entrada.nextLine();
        String senhaCriptografada = criptografarSenha(senha);

        if(usuariosCadastrados.isEmpty()){
            System.out.println("Usuário não cadastrado!");
        } else{
            for (Usuario usuario: usuariosCadastrados) {
                if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senhaCriptografada)){
                    System.out.println("Login realizado com sucesso!");
                } else {
                    System.out.println("Email ou senha inválida!");
                }
            }
        }
    }

    public static void cadastrar(){
        System.out.print("Digite o email: ");
        String email = entrada.nextLine();

        if (!email.contains("@")) {
            throw new EmailSemArrobaException("Email invalido");
        }

        System.out.print("Digite a senha: ");
        String senha = entrada.nextLine();
        String senhaCriptografada = criptografarSenha(senha);

        usuariosCadastrados.add(new Usuario(email, senhaCriptografada));

        System.out.println("Usuário Cadastrado Com Sucesso!");

    }

    public static void mostrarUsuariosCadastrados() {
        if(usuariosCadastrados.isEmpty()){
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for(Usuario usuario : usuariosCadastrados){
                System.out.println(usuario.toString());
            }
        }
    }

    private static String criptografarSenha(String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bty = senha.getBytes();
            md.update(bty, 0, senha.length());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
