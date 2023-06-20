import java.math.BigInteger;
import java.security.MessageDigest;

public class Usuario {

    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = ControleSistema.criptografarSenha(senha);
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
