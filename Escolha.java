public class Escolha {
    private String texto;
    Capitulo prox;

    public Escolha(String texto, Capitulo proximo) {
        this.texto = texto;
        this.prox = proximo;
    }

    public String getTexto() {
        return this.texto;
    }

    public Capitulo getProximo() {
        return this.prox;
    }
}
