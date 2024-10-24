package proyecto;

import java.time.LocalDateTime;

public class Ticket {
    private static int nextId = 0;

    public String nombre;
    public int id;
    public int edad;
    public LocalDateTime createdAt;
    public LocalDateTime attendedAt;
    public String transaction;
    public String type; // preferencial, solo tramite, dos o mas tramites


    // todo: change for a builder pattern like Bank to avoid so many parameters D:
    public Ticket(String nombre, int edad, String transaction, String type) {
        this.id = nextId++;
        this.nombre = nombre;
        this.edad = edad;
        this.createdAt = LocalDateTime.now();
        this.attendedAt = null;
        this.transaction = transaction;
        this.type = type;
    }
}
