import java.util.List;

public class Bodyguard extends Impiegato {
    private String areaResponsabilita;
    private int inServizio;
    final private int[] orari;
    public Cassaforte cassaforte;
    private List<Ladro> ladri;

    public Bodyguard(String nome, String cognome, int matricola, double stipendio, String areaResponsabilita, int[] orari, Cassaforte cassaforte, List<Ladro> ladri) {
        super(nome, cognome, matricola, stipendio, "Bodyguard");
        this.areaResponsabilita = areaResponsabilita;
        this.orari = orari;
        this.cassaforte = cassaforte;
        this.ladri = ladri;
    }

    @Override
    public double calcolaStipendio() {
        //base + bonus per area di responsabilità
        return stipendio + 200.0;
    }

    @Override
    public void assegnaTurno(){}

    public void assegnaCompito(int tempo) {
        inServizio = tempo;
    }

    public void assegnaAreaResponsabilita(String nuovaArea) {
        this.areaResponsabilita = nuovaArea;
        System.out.println("L'area di responsabilità è stata cambiata a: " + nuovaArea);
    }

    public void run() {
        while (java.time.ZonedDateTime.now().getHour() < orari[1] || java.time.ZonedDateTime.now().getHour() > orari[0]) {
            if (inServizio > 0) {
                try {
                    Thread.sleep((long)inServizio * 1000);
                    inServizio = inServizio - 1;
                    if(inServizio%5 == 0) {
                        System.out.println("Il bodyguard " + nome + " " + cognome + " sta svolgendo un servizio di protezione nell'area " + areaResponsabilita + ".");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(cassaforte.allarme) {
                for (Ladro l: ladri) {
                    if(cassaforte.ultimoOperatore == l.matricola) {
                        System.out.println("Il bodyguard " + nome + " " + cognome + " ha catturato e buttato fuori il ladro " + l.nome + " " + l.cognome);
                        l.scoperto = true;
                        cassaforte.disattivaAllarme();
                    }
                }
            }
        }
    }
}