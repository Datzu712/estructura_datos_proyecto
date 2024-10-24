package proyecto;

public class Client {
    private static int nextId = 0;

    public final int id;
    public String name;

    public Client(String name) {
        this.id = Client.nextId++;
        this.name = name;
    }
}
