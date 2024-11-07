package proyecto;

import java.time.LocalDateTime;
import java.io.Serializable;

// Nodo
public class Ticket implements Serializable {
    private static int nextId = 1;

    public final int id = nextId++;
    private Client currentClient = null;

    public final LocalDateTime createdAt;
    public LocalDateTime attendedAt;
    public final String transaction;
    public final TicketType type; // preferencial, solo tramite, dos o mas tramites

    public Box assignedBox = null;

    // todo: change for a builder pattern like Bank to avoid so many parameters D:
    public Ticket(String transaction, TicketType type) {
        this.createdAt = LocalDateTime.now();
        this.attendedAt = null;
        this.transaction = transaction;
        this.type = type;
    }

    public void setCurrentClient(Client client) {
        this.currentClient = client;
    }

    public Client getCurrentClient() {
        return this.currentClient;
    }
    public String toString() {
        return "Ticket {" +
            "createdAt=" + this.createdAt + ", " +
            "attendedAt=" + this.attendedAt + ", " +
            "transaction='" + this.transaction + ", " +
            "type='" + this.type  + ", " +
            "client=" + this.currentClient + ", " +
            "id=" + this.id +
        '}';
    }
}
