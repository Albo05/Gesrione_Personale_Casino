// Classe Caveau
import java.util.ArrayList;
import java.util.List;

public class Caveau {
    private double saldo;
    private Cassaforte cassaforte;
    private List<String> operazioni;

    public Caveau(double saldoIniziale, Cassaforte cassaforte) {
        this.saldo = saldoIniziale;
        this.cassaforte = cassaforte;
        this.operazioni = new ArrayList<>();
    }

    public void deposita(double importo) {
        saldo += importo;
        registraOperazione("Deposito di " + importo);
        System.out.println("Deposito effettuato.");
    }

    public void preleva(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
            registraOperazione("Prelievo di " + importo);
            System.out.println("Prelievo effettuato.");
        } else {
            System.out.println("Saldo insufficiente per il prelievo.");
        }
    }

    private void registraOperazione(String operazione) {
        operazioni.add(operazione); // Registra l'operazione nella lista
    }

    public void visualizzaSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    public void visualizzaOperazioni() {
        System.out.println("Elenco operazioni:");
        for (String operazione : operazioni) {
            System.out.println("    " + operazione);
        }
    }
}
