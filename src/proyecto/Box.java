package proyecto;

import java.io.Serializable;
import java.util.ArrayList;

// clase cola
public class Box implements Serializable {
    private static int nextId = 0;

    public final int id;
    public String type;
    public boolean preferential;

    private ArrayList<Client> queue = new ArrayList<Client>();

    public Box(String type, boolean preferential) {
        this.id = nextId++;
        this.type = type;
        this.preferential = preferential;
    }

    public void enqueue(Client client) {
        queue.add(client);
    }

    public Client dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public Client peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}