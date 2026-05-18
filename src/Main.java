import modelo.Usuario;
import servico.ServicoAutenticacao;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServicoAutenticacao auth = new ServicoAutenticacao();
        Scanner leitor = new Scanner(System.in);

        System.out.println("=== SISTEMA DE NOTIFICAÇÕES ===");
        
        System.out.print("Digite seu login: ");
        String login = leitor.nextLine(); 
        
        System.out.print("Digite sua senha: ");
        String senha = leitor.nextLine();

        Usuario usuarioLogado = auth.fazerLogin(login, senha);

        if (usuarioLogado != null) {
            System.out.println("O seu nível de acesso é: " + usuarioLogado.getTipoUsuario());
            
        }
        leitor.close();
    }
}