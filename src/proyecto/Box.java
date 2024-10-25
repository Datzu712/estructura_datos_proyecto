package proyecto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Box implements Serializable {
    private static int nextId = 0;

    private Ticket currentTicket, nexTicket = null;
    private int size = 0;

    public final int id;
    public String type;
    public boolean preferential;


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

        // todo: Only change attendedAt if the ticket is not already attended and don't remove it from the queue
        Ticket ticket = currentTicket;
        currentTicket = currentTicket.getNextTicket();

        ticket.attendedAt = LocalDateTime.now();

        size--;
        return ticket;
    }

    public void enqueue(Ticket ticket) {
        if (currentTicket == null) {
            currentTicket = ticket;
        } else {
            Ticket lastTicket = currentTicket;
            while (lastTicket.getNextTicket() != null) {
                lastTicket = lastTicket.getNextTicket();
            }
            lastTicket.setNextTicket(ticket);
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String output = "";
        Ticket ticket = currentTicket;
        while (ticket != null) {
            output += ticket.toString() + "\n";
            ticket = ticket.getNextTicket();
        }

        return output;
    }
}