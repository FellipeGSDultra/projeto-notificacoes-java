import modelo.Usuario;
import servico.ServicoAutenticacao;
import servico.ServicoUsuario;
import servico.ServicoNotificacoes;
import visao.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializando os serviços e a interface
        ServicoUsuario servicoUsuario = new ServicoUsuario();
        ServicoAutenticacao auth = new ServicoAutenticacao(servicoUsuario);
        ServicoNotificacoes servicoNotificacoes = new ServicoNotificacoes();
        InterfaceUsuario ui = new InterfaceUsuario();
        
        boolean rodandoSistema = true;

        while (rodandoSistema) {
            int opcaoInicial = ui.interfaceInicial();

            if (opcaoInicial == 1) { // LOGIN
                System.out.println("\n--- TELA DE LOGIN ---");
                String login = ui.lerTexto("Digite seu login: ");
                String senha = ui.lerTexto("Digite sua senha: ");
                
                Usuario usuarioLogado = auth.fazerLogin(login, senha);

                if (usuarioLogado != null) {
                    boolean rodandoPainel = true;

                    // ==========================================
                    // FLUXO DO CLIENTE
                    // ==========================================
                    if (usuarioLogado.getTipoUsuario().equals("Cliente")) {
                        while (rodandoPainel) {
                            int opcaoCliente = ui.interfaceClienteInicial(usuarioLogado.getLogin());
                            
                            if (opcaoCliente == 1) {
                                System.out.println("\n[Módulo de Compras em desenvolvimento...]");
                            } 
                            else if (opcaoCliente == 2) {
                                String tipoNotificacao = ui.interfaceClienteEnviarNotificacoes();
                                
                                if (tipoNotificacao.equals("Cancelar")) {
                                    System.out.println("\nEnvio cancelado.");
                                } else if (tipoNotificacao.equals("Invalido")) {
                                    System.out.println("\n⚠️ Opção de notificação inválida! Tente novamente.");
                                } else {
                                    String mensagem = ui.lerTexto("Digite sua mensagem: ");
                                    servicoNotificacoes.armazenarNotificacaoEnviada(tipoNotificacao, usuarioLogado.getLogin(), mensagem);
                                }
                            } 
                            else if (opcaoCliente == 3) {
                                System.out.println("\nSaindo da conta...");
                                rodandoPainel = false; // Sai do laço do cliente e volta pro menu inicial
                            } 
                            else {
                                System.out.println("\n⚠️ Opção inválida! Escolha uma opção válida do menu.");
                            }
                        }
                    } 
                    // ==========================================
                    // FLUXO DO ADMIN
                    // ==========================================
                    else if (usuarioLogado.getTipoUsuario().equals("Admin")) {
                        while (rodandoPainel) {
                            int opcaoAdmin = ui.interfaceAdminInicial();
                            
                            if (opcaoAdmin == 1) {
                                System.out.println("\n[Módulo de Cadastrar Funcionário em desenvolvimento...]");
                            } 
                            else if (opcaoAdmin == 2) {
                                boolean lendoNotificacoes = true;
                                while (lendoNotificacoes) {
                                    int opcaoLer = ui.interfaceAdminLerNotificacoes();
                                    
                                    if (opcaoLer == 1) {
                                        servicoNotificacoes.exibirNotificacaoNaoLida();
                                    } else if (opcaoLer == 2) {
                                        servicoNotificacoes.exibirNotificacaoLida();
                                    } else if (opcaoLer == 3) {
                                        lendoNotificacoes = false; // Volta pro menu do Admin
                                    } else {
                                        System.out.println("\n⚠️ Opção inválida! Escolha 1, 2 ou 3.");
                                    }
                                }
                            } 
                            else if (opcaoAdmin == 3) {
                                System.out.println("\nSaindo da conta...");
                                rodandoPainel = false; // Sai do laço do admin e volta pro menu inicial
                            } 
                            else {
                                System.out.println("\n⚠️ Opção inválida! Escolha uma opção válida do menu.");
                            }
                        }
                    }
                }
            } 
            else if (opcaoInicial == 2) { // CRIAR CONTA
                System.out.println("\n--- CRIAR CONTA (NOVO CLIENTE) ---");
                String novoLogin = ui.lerTexto("Digite o login desejado: ");
                String novaSenha = ui.lerTexto("Digite a senha desejada: ");
                servicoUsuario.cadastrarCliente(novoLogin, novaSenha);
            } 
            else if (opcaoInicial == 3) { // SAIR
                System.out.println("\nSaindo do sistema. Até mais!");
                rodandoSistema = false;
            } 
            else {
                // Captura opções fora de 1, 2, 3 e também captura o erro de letras (-1)
                System.out.println("\n⚠️ Opção inválida! Por favor, digite 1, 2 ou 3.");
            }
        }
    }
}