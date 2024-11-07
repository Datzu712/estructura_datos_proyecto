package proyecto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Iterator;

public class Box implements Serializable, Iterable<Ticket> { 
    private static int nextId = 0;

    private Nodo<Ticket> currentNodo, lastNodo = null;
    private int size = 0;

    public final int id;
    public final String type;
    public final boolean preferential;

    public Box(String type, boolean preferential) {
        this.id = nextId++;
        this.type = type;
        this.preferential = preferential;
    }

    public int getSize() {
        return size;
    }
    public void setCurrentTicket(Ticket ticket) {
        this.currentNodo = new Nodo<Ticket>(ticket);
    }

    public Ticket getCurrentTicket() {
        return this.currentNodo.getCurrentValue();
    }

    public void setNextTicket(Ticket ticket) {
        this.currentNodo.setNextValue(ticket);
    }

    public Ticket getNextTicket() {
        return this.currentNodo.getCurrentValue();
    }

    public Ticket getLastTicket() {
        if (lastNodo == null) {
            return null;
        }

        return this.lastNodo.getCurrentValue();
    }

    public Ticket attend() {
        if (currentNodo == null) {
            Logger.log("No hay tickets en la cola");
            return null;
        }
        Nodo<Ticket> attendedTicket = currentNodo;
        currentNodo = currentNodo.getNextValue();

        Ticket ticket = attendedTicket.getCurrentValue();

        ticket.attendedAt = LocalDateTime.now();

        size--;
        return ticket;
    }

    public void enqueue(Ticket ticket) {
        Nodo<Ticket> newLastNodo = new Nodo<Ticket>(ticket);
        if (currentNodo == null) {
            currentNodo = newLastNodo;
            lastNodo = newLastNodo;
        } else {
            lastNodo.setNextValue(newLastNodo);
            lastNodo = newLastNodo;
        }
        ticket.assignedBox = this;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String output = "";

        for (Ticket ticket : this) {
            output += ticket + "\n";
        }
        return output;
    }

    @Override
    public Iterator<Ticket> iterator() {
        return new Box.BoxIterator(currentNodo);
    }

    private static class BoxIterator implements Serializable, Iterator<Ticket> {
        private Nodo<Ticket> currentIteratorNode;
    
        public BoxIterator(Nodo<Ticket> currentTicket) {
            this.currentIteratorNode = currentTicket;
        }
    
        @Override
        public boolean hasNext() {
            return currentIteratorNode != null;
        }
    
        @Override
        public Ticket next() {
            Nodo<Ticket> currentTicket = currentIteratorNode;
            currentIteratorNode = currentIteratorNode.getNextValue();
    
            return currentTicket.getCurrentValue();
        }
    }
}