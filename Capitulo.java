import java.util.ArrayList;
import java.util.Scanner;

public class Capitulo {
    private String nome;
    private String texto;
    private Personagem personagem;
    private int alterarEnergia;
    private Scanner escaneador;
    private ArrayList<Escolha> escolhas;

    public Capitulo(String nome,
            String texto,
            Personagem personagem,
            int alterarEnergia,
            Scanner escaneador) {

        this.nome = nome;
        this.texto = texto;
        this.personagem = personagem;
        this.alterarEnergia = alterarEnergia;
        this.escaneador = escaneador;
        this.escolhas = new ArrayList<Escolha>();
    }

    public void Mostrar() {
        System.out.println("\n ___________________________________________________________________________________________________\n");
        System.out.println(this.nome);
        System.out.println(this.texto);
        this.personagem.alterarEnergia(this.alterarEnergia);
        System.out.println();

        if (escolhas.size()>0){
            int a = Escolher();
            this.escolhas.get(a).prox.Mostrar();
        }
    }

    private int Escolher() {
        Scanner asdf = new Scanner(System.in);
        int f = asdf.nextInt();
        return f;
    }

    public void adicionarEscolha(Escolha escolha) {
        this.escolhas.add(escolha);
    }
}