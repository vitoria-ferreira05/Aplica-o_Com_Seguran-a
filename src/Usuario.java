import java.math.BigInteger;
import java.security.MessageDigest;

public class Usuario {

    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = criptografarSenha(senha);
    }

    private static String criptografarSenha(String senha){
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

    public String getSenha() {
        return senha;
    }
}
