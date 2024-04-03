public class Ladro extends Thread{
    public String nome;
    public String cognome;
    public int matricola;
    public boolean scoperto = false;
    private Cassaforte c;

    public Ladro(String nome, String cognome, int matricola, Cassaforte c) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.c = c;
    }

    public void run() {
        while (!scoperto) {
            try {
                System.out.println("Il ladro " + nome + " " + cognome + " sta aspettando il momento giusto.");
                Thread.sleep((long)Math.random() * 100000);
                System.out.println("Il ladro " + nome + " " + cognome + " sta cercando di rubare.");
                c.apri(matricola);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Il ladro " + nome + " " + cognome + " è stato scoperto e cacciato.");
    }
}