package proyecto;

public enum TicketType {
    PREFERENTIAL("preferencial"),
    SINGLE_TRANSACTION("solo tramite"),
    MULTIPLE_TRANSACTION("dos o mas tramites");

    private final String value;

    TicketType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
