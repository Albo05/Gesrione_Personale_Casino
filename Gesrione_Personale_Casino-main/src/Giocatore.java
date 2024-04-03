public class Giocatore extends Thread{
    private final String nome;
    private final String cognome;
    private final int matricola;
    private int dentro;
    public Giocatore(String nome, String cognome, int matricola, int dentro) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.dentro = dentro;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getMatricola() {
        return matricola;
    }


    public void run() {
        System.out.println("Il giocatore " + nome + " " + cognome + " è entrato nel casinò");
        while (dentro > 0) {
            try {
                Thread.sleep(1000);
                dentro -= 1;
                if(Math.random()*100 < 5) {
                    System.out.println("Il giocatore " + nome + " " + cognome + " è entrato in una partita");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dentro += 100;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Il giocatore " + nome + " " + cognome + " è uscito dal casinò");
    }
}
