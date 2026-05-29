package servico;

import modelo.Notificacao;
import java.util.ArrayList;
import java.util.List;

public class ServicoNotificacoes {
    private List<Notificacao> bancoDeNotificacoes;

    public ServicoNotificacoes() {
        this.bancoDeNotificacoes = new ArrayList<>();
    }

    // 3.2.1. Armazenar notificação enviada
    public void armazenarNotificacaoEnviada(String tipo, String nomeUsuario, String mensagem) {
        Notificacao novaNotificacao = new Notificacao(tipo, nomeUsuario, mensagem);
        bancoDeNotificacoes.add(novaNotificacao);
        System.out.println("\nNotificação enviada com sucesso ao administrador!");
    }

    // 3.2.2. Exibir Notificações Lidas
    public void exibirNotificacaoLida() {
        System.out.println("\n--- NOTIFICAÇÕES LIDAS ---");
        boolean encontrou = false;
        for (Notificacao notif : bancoDeNotificacoes) {
            if (notif.isLida()) {
                System.out.println(notif.formatarParaExibicao());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma notificação lida encontrada.");
        }
    }

    // 3.2.3. Exibir Notificações Não Lidas (e já marca como lida após exibir)
    public void exibirNotificacaoNaoLida() {
        System.out.println("\n--- NOTIFICAÇÕES NÃO LIDAS ---");
        boolean encontrou = false;
        for (Notificacao notif : bancoDeNotificacoes) {
            if (!notif.isLida()) {
                System.out.println(notif.formatarParaExibicao());
                notif.marcarComoLida(); // O Admin acabou de ler, então muda o status
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Oba! Nenhuma notificação nova.");
        }
    }
}