package servico;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ServicoAutenticacao {
    
    private List<Usuario> bancoDeUsuarios;

    public ServicoAutenticacao() {
        this.bancoDeUsuarios = new ArrayList<>();
        bancoDeUsuarios.add(new Usuario("fellipe", "1234", "Admin"));
        bancoDeUsuarios.add(new Usuario("cliente1", "senha1", "Cliente"));
    }

    public Usuario fazerLogin(String loginDigitado, String senhaDigitada) {
        for (Usuario u : bancoDeUsuarios) {
            if (u.getLogin().equals(loginDigitado) && u.getSenha().equals(senhaDigitada)) {
                System.out.println("Acesso concedido! Bem-vindo, " + u.getLogin());
                return u;
            }
        }
        
        System.out.println("Erro: Login ou senha incorretos.");
        return null;
    }
}