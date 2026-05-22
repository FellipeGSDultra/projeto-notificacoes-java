package servico;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ServicoUsuario {
    
    private List<Usuario> bancoDeUsuarios;

    public ServicoUsuario() {
        this.bancoDeUsuarios = new ArrayList<>();
        // Usuários padrão do sistema para testes
        bancoDeUsuarios.add(new Usuario("admin", "admin123", "Admin"));
        bancoDeUsuarios.add(new Usuario("fellipe", "1234", "Cliente"));
    }

    // Apenas cadastra e insere na lista
    public boolean cadastrarCliente(String novoLogin, String novaSenha) {
        for (Usuario u : bancoDeUsuarios) {
            if (u.getLogin().equalsIgnoreCase(novoLogin)) {
                System.out.println("\nErro: Este login já está cadastrado no sistema.");
                return false; 
            }
        }

        Usuario novoCliente = new Usuario(novoLogin, novaSenha, "Cliente");
        bancoDeUsuarios.add(novoCliente);
        
        System.out.println("\nConta de Cliente criada com sucesso para o usuário: " + novoLogin);
        return true;
    }

    // Método auxiliar para buscar um usuário se as credenciais baterem
    public Usuario buscarPorCredenciais(String login, String senha) {
        for (Usuario u : bancoDeUsuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null; // Retorna nulo se não achar ninguém
    }
}