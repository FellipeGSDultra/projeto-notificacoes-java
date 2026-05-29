package modelo;

public class Notificacao {
    private String tipo;
    private String nomeUsuario;
    private String mensagem;
    private boolean lida;

    public Notificacao(String tipo, String nomeUsuario, String mensagem) {
        this.tipo = tipo;
        this.nomeUsuario = nomeUsuario;
        this.mensagem = mensagem;
        this.lida = false; // Toda notificação nasce como "Não Lida"
    }

    // Método que formata a notificação exatamente no layout que você pediu
    public String formatarParaExibicao() {
        String status = this.lida ? "Lida" : "Não Lida";
        return "[" + this.tipo + "] " + this.nomeUsuario + " : '" + this.mensagem + "' . [" + status + "]";
    }

    public void marcarComoLida() {
        this.lida = true;
    }

    public boolean isLida() {
        return lida;
    }
}