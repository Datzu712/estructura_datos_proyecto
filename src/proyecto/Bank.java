package proyecto;

import java.io.Serializable;
import java.util.List;

public class Bank implements Serializable {
    public String name;
    public Box preferentialBox = null;
    public Box quickTransactionsBox = null;
    public List<Box> generalBoxes = null;

    // me da cringe ver tantos parámetros
    public Bank(String name) {
        this.name = name;
    }

    // class builder
    public Bank setPreferentialBox(Box preferentialBox) {
        this.preferentialBox = preferentialBox;

        return this;
    }
    public Bank setQuickTransactionsBox(Box quickTransactionsBox) {
        this.quickTransactionsBox = quickTransactionsBox;

        return this;
    }
    public Bank setGeneralBoxes(List<Box> generalBoxes) {
        this.generalBoxes = generalBoxes;

        return this;
    }
}