package proyecto;

import java.time.LocalDateTime;
import java.io.Serializable;

// Nodo
public class Ticket implements Serializable {
    private Client currentClient = null;
    private Ticket nextTicket = null;

    public final LocalDateTime createdAt;
    public LocalDateTime attendedAt;
    public String transaction;
    public String type; // preferencial, solo tramite, dos o mas tramites


    // todo: change for a builder pattern like Bank to avoid so many parameters D:
    public Ticket(String transaction, String type) {
        this.createdAt = LocalDateTime.now();
        this.attendedAt = null;
        this.transaction = transaction;
        this.type = type;
    }

    public void setNextTicket(Ticket nextTicket) {
        this.nextTicket = nextTicket;
    }

    public Ticket getNextTicket() {
        return this.nextTicket;
    }

    public void setCurrentClient(Client client) {
        this.currentClient = client;
    }

    public Client getCurrentClient() {
        return this.currentClient;
    }

    public String toString() {
        return "Ticket{" +
            "createdAt=" + this.createdAt +
            ", attendedAt=" + this.attendedAt +
            ", transaction='" + this.transaction + '\'' +
            ", type='" + this.type + '\'' +
            '}';
    }
}
