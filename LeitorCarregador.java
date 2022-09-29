import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LeitorCarregador {

    public HashMap<String, Personagem> lerPersonagens(String caminhoArquivoPersonagens) {

        HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();
        File arquivoPersonagens = new File(caminhoArquivoPersonagens);

        try {
            Scanner escaneadorArquivoPersonagens = new Scanner(arquivoPersonagens, "UTF-8");

            String nomePersonagem = "";
            String linhaEscaneada = "";
            int energiaPersonagem = 0;

            while (escaneadorArquivoPersonagens.hasNextLine()) {

                while (!linhaEscaneada.equals("PERSONAGEM")) {
                    linhaEscaneada = escaneadorArquivoPersonagens.nextLine();
                }
                linhaEscaneada = escaneadorArquivoPersonagens.nextLine(); // NOME
                nomePersonagem = escaneadorArquivoPersonagens.nextLine();
                linhaEscaneada = escaneadorArquivoPersonagens.nextLine(); // ENERGIA
                energiaPersonagem = Integer.parseInt(escaneadorArquivoPersonagens.nextLine());
                personagens.put(nomePersonagem, new Personagem(nomePersonagem, energiaPersonagem));
            }

            escaneadorArquivoPersonagens.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return personagens;

    }

    public HashMap<String, Capitulo> lerCapitulos(String caminhoArquivoCapitulos,
            HashMap<String, Personagem> personagens,
            Scanner escaneadorConsole) {

        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();
        File arquivoCapitulos = new File(caminhoArquivoCapitulos);

        try {
            Scanner escaneadorArqvCap = new Scanner(arquivoCapitulos, "UTF-8");

            String linhaEscaneada = "";

            while (escaneadorArqvCap.hasNextLine()) {

                while (!linhaEscaneada.equals("CAPITULO") && !linhaEscaneada.equals("ESCOLHA")) {

                    linhaEscaneada = escaneadorArqvCap.nextLine();
                }
                if (linhaEscaneada.equals("CAPITULO")) {

                    lerCapitulo(personagens,
                            escaneadorConsole,
                            capitulos,
                            escaneadorArqvCap);

                    linhaEscaneada = "";
                }

                else if (linhaEscaneada.equals("ESCOLHA")) {

                    lerEscolha(capitulos, escaneadorArqvCap);
                    linhaEscaneada = "";
                }
            }

            escaneadorArqvCap.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        return capitulos;

    }

    private void lerCapitulo(HashMap<String, Personagem> personagens, Scanner escaneadorConsole,
            HashMap<String, Capitulo> capitulos, Scanner escaneadorArqvCap) {
        String nomeCapitulo;
        String textoCapitulo;
        String nomePersonagem;
        int variacaoEnergia;
        String linhaEscaneada;
        linhaEscaneada  = escaneadorArqvCap.nextLine();             // NOME
        nomeCapitulo    = escaneadorArqvCap.nextLine();
        linhaEscaneada  = escaneadorArqvCap.nextLine();             // TEXTO
        textoCapitulo   = escaneadorArqvCap.nextLine();
        linhaEscaneada  = escaneadorArqvCap.nextLine();             // PERSONAGEM
        nomePersonagem  = escaneadorArqvCap.nextLine();
        linhaEscaneada  = escaneadorArqvCap.nextLine();             // VARIAÇÃO DE ENERGIA
        variacaoEnergia = Integer.parseInt(escaneadorArqvCap.nextLine());
        capitulos.put(nomeCapitulo, new Capitulo(nomeCapitulo,
                textoCapitulo,
                personagens.get(nomePersonagem),
                variacaoEnergia,
                escaneadorConsole));
    }

    private void lerEscolha(HashMap<String, Capitulo> capitulos, Scanner escaneadorArqvCap) {
        String nomeCapAnterior;
        String textoCap;
        String nomeProxCap;
        String linhaEscaneada;
        linhaEscaneada      = escaneadorArqvCap.nextLine();         // CAPITULO DE ANTERIOR
        nomeCapAnterior  = escaneadorArqvCap.nextLine();
        linhaEscaneada      = escaneadorArqvCap.nextLine();         // TEXTO
        textoCap        = escaneadorArqvCap.nextLine();
        linhaEscaneada      = escaneadorArqvCap.nextLine();         // CAPITULO DE DESTINO
        nomeProxCap = escaneadorArqvCap.nextLine();

        Capitulo capAnterior = capitulos.get(nomeCapAnterior);
        Capitulo capProx = capitulos.get(nomeProxCap);
        capAnterior.adicionarEscolha(new Escolha(textoCap, capProx));
    }
}