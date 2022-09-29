import java.util.HashMap;
import java.util.Scanner;

public class App {
        public static void main(String[] args) {
                Scanner escaneador = new Scanner(System.in);
                LeitorCarregador leitor = new LeitorCarregador();
                HashMap<String, Personagem> personagens = leitor.lerPersonagens("Txts/Personagens.txt");
                HashMap<String, Capitulo> capitulos = leitor.lerCapitulos("Txts/Capitulos.txt", personagens,
                                escaneador);

                Capitulo raiz = capitulos.get("BEM VINDO À DUNGEON");

                raiz.Mostrar();

                escaneador.close();
        }
}