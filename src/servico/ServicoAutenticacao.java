package servico;

import modelo.Usuario;

public class ServicoAutenticacao {
    
    // A autenticação agora depende do serviço de usuários para funcionar
    private ServicoUsuario servicoUsuario;

    // Recebemos o ServicoUsuario através do construtor
    public ServicoAutenticacao(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }

    // A única responsabilidade desta classe: Autenticar
    public Usuario fazerLogin(String loginDigitado, String senhaDigitada) {
        // Pede para o ServicoUsuario buscar as credenciais
        Usuario usuarioEncontrado = servicoUsuario.buscarPorCredenciais(loginDigitado, senhaDigitada);

        if (usuarioEncontrado != null) {
            System.out.println("\nAcesso concedido! Bem-vindo, " + usuarioEncontrado.getLogin() + ".");
            return usuarioEncontrado;
        } else {
            System.out.println("\nErro: Login ou senha incorretos.");
            return null;
        }
    }
}