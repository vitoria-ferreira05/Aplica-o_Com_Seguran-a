import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        for (Usuario usuario: usuariosCadastrados) {
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senhaCriptografada)){
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente novamente");
            }
        }

//        for (Map.Entry<String, Usuario> usuario : usuariosCadastrados.entrySet()) {
//            if(usuariosCadastrados.containsKey(email)){
//                usuariosCadastrados.v
//            } else {
//                System.out.println("Ocorreu um erro! Tente novamente");
//            }
//        }
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
    }

    public static String criptografarSenha(String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bty = senha.getBytes();
            md.update(bty, 0, senha.length());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}