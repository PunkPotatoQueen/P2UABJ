public class Personagem {
    private String nome;
    private int energia;

    public Personagem(String nome, int energia) {
        this.nome = nome;
        this.energia = energia;
    }

    public void alterarEnergia(int a) {
        this.energia = this.energia + a;

        if (a > 0) {
            System.out.println("\n Neste capítulo, os personagens recuperaram " + a + " de energia! Você fez uma boa escolha!");
        } 
        else if (a == 0) {
            System.out.println("\n Neste capítulo a energia se manteve.");
        }
        else{
            System.out.println("\n Neste capítulo, os personagens perderam " + a + " de energia...");      
        }

        if (this.energia <= 0) {
            this.energia = 0;
            System.out.println("\n A party foi derrotada.");
        }
    }
}
