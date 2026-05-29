package visao;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner leitor;

    public InterfaceUsuario() {
        this.leitor = new Scanner(System.in);
    }

    // ==========================================
    // MÉTODO AUXILIAR (Tratamento de Erro Único)
    // ==========================================
    private int lerOpcaoSegura() {
        String entrada = leitor.nextLine(); // Lê como texto
        try {
            return Integer.parseInt(entrada); // Tenta converter para número
        } catch (NumberFormatException e) {
            return -1; // Se der erro, devolve -1 (o Main vai tratar como opção inválida)
        }
    }

    // ==========================================
    // MENUS DO SISTEMA
    // ==========================================

    public int interfaceInicial() {
        System.out.println("\n======================");
        System.out.println("Seja Bem-Vindo ao Sistema");
        System.out.println("======================");
        System.out.println("Selecione a opção desejada:");
        System.out.println("1. Login");
        System.out.println("2. Criar Conta");
        System.out.println("3. Sair");
        System.out.print("Opção: ");
        
        return lerOpcaoSegura(); 
    }

    public int interfaceClienteInicial(String nomeCliente) {
        System.out.println("\nOlá, " + nomeCliente + "! Seja bem-vindo!");
        System.out.println("Selecione a opção desejada:");
        System.out.println("1. Comprar");
        System.out.println("2. Enviar Notificação");
        System.out.println("3. Sair da conta");
        System.out.print("Opção: ");
        
        return lerOpcaoSegura();
    }

    public String interfaceClienteEnviarNotificacoes() {
        System.out.println("\nQual o tipo de notificação que deseja enviar:");
        System.out.println("1. Feedback");
        System.out.println("2. Problemas com a conta");
        System.out.println("3. Reclamação");
        System.out.println("4. Cancelar");
        System.out.print("Opção: ");
        
        int opcao = lerOpcaoSegura();
        
        switch (opcao) {
            case 1: return "Feedback";
            case 2: return "Problemas com a conta";
            case 3: return "Reclamação";
            case 4: return "Cancelar";
            default: return "Invalido";
        }
    }

    public int interfaceAdminInicial() {
        System.out.println("\nSeja bem-vindo, Admin!");
        System.out.println("Selecione a opção desejada:");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Ler Notificações");
        System.out.println("3. Sair da conta");
        System.out.print("Opção: ");
        
        return lerOpcaoSegura();
    }

    public int interfaceAdminLerNotificacoes() {
        System.out.println("\n1. Ler Notificações Não Vistas");
        System.out.println("2. Ler Notificações Vistas");
        System.out.println("3. Voltar");
        System.out.print("Opção: ");
        
        return lerOpcaoSegura();
    }

    public String lerTexto(String prompt) {
        System.out.print(prompt);
        return leitor.nextLine();
    }
}