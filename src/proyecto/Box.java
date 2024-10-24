package proyecto;

import java.io.Serializable;

// clase cola
public class Box implements Serializable {
    private static int nextId = 0;

    private Ticket currentTicket, nexTicket = null;
    private int size = 0;

    public final int id;
    public String type;
    public boolean preferential;

    //private ArrayList<Client> queue = new ArrayList<Client>();

    public Box(String type, boolean preferential) {
        this.id = nextId++;
        this.type = type;
        this.preferential = preferential;
    }

    public int getSize() {
        return size;
    }
    public void setCurrentTicket(Ticket ticket) {
        this.currentTicket = ticket;
    }

    public Ticket getCurrentTicket() {
        return this.currentTicket;
    }

    public void setNextTicket(Ticket ticket) {
        this.nexTicket = ticket;
    }

    public Ticket getNextTicket() {
        return this.nexTicket;
    }

    public Ticket attend() {
        if (currentTicket == null) {
            System.out.println("No hay tickets en la cola");
            return null;
        }

        Ticket ticket = currentTicket;
        currentTicket = currentTicket.getNextTicket();

        size--;
        return ticket;
    }

    // public void enqueue(Client client) {
    //     queue.add(client);
    // }

    // public Client dequeue() {
    //     if (queue.isEmpty()) {
    //         return null;
    //     }
    //     return queue.remove(0);
    // }

    // public Client peek() {
    //     if (queue.isEmpty()) {
    //         return null;
    //     }
    //     return queue.get(0);
    // }

    // public boolean isEmpty() {
    //     return queue.isEmpty();
    // }

    // public int size() {
    //     return queue.size();
    // }
}