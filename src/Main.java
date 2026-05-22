import modelo.Usuario;
import servico.ServicoAutenticacao;
import servico.ServicoUsuario; // <-- Novo import
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializa o banco de usuários primeiro
        ServicoUsuario servicoUsuario = new ServicoUsuario();
        
        // 2. Entrega o banco de usuários para a autenticação poder trabalhar
        ServicoAutenticacao auth = new ServicoAutenticacao(servicoUsuario);
        
        Scanner leitor = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n======================");
            System.out.println("Seja Bem-Vindo ao Sistema");
            System.out.println("======================");
            System.out.println("Selecione a opção desejada :");
            System.out.println("1. Login");
            System.out.println("2. Criar Conta");
            System.out.println("3. Sair do Sistema");
            System.out.print("Opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n--- TELA DE LOGIN ---");
                    System.out.print("Digite seu login: ");
                    String login = leitor.nextLine();
                    
                    System.out.print("Digite sua senha: ");
                    String senha = leitor.nextLine();

                    Usuario usuarioLogado = auth.fazerLogin(login, senha);

                    if (usuarioLogado != null) {
                        System.out.println("Nível de acesso confirmado: " + usuarioLogado.getTipoUsuario());
                        rodando = false; 
                    }
                    break;

                case 2:
                    System.out.println("\n--- CRIAR CONTA (NOVO CLIENTE) ---");
                    System.out.print("Digite o login desejado: ");
                    String novoLogin = leitor.nextLine();
                    
                    System.out.print("Digite a senha desejada: ");
                    String novaSenha = leitor.nextLine();

                    // O MAIN agora fala diretamente com o ServicoUsuario para cadastrar
                    servicoUsuario.cadastrarCliente(novoLogin, novaSenha);
                    break;

                case 3:
                    System.out.println("\nSaindo... Até mais!");
                    rodando = false;
                    break;

                default:
                    System.out.println("\nOpção inválida. Escolha entre 1, 2 ou 3.");
                    break;
            }
        }
        
        System.out.println("\n[Redirecionando para o painel de Mensagens e Notificações...]");
        leitor.close();
    }
}