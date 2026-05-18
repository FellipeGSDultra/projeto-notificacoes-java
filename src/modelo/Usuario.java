package modelo;

public class Usuario {
    private String login;
    private String senha;
    private String tipoUsuario;

    public Usuario(String login, String senha, String tipoUsuario) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}