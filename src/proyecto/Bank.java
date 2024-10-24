package proyecto;

import java.util.List;
import java.io.*;

public class Bank implements Serializable {
    public String name;

    public final BoxManager boxes = BoxManager.build();

    // me da cringe ver tantos parámetros
    public Bank(String name) {
        this.name = name;
    }

    public Bank save(String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this);

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
    public static Bank load(String filename) {
        Bank bank = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            bank = (Bank) in.readObject();

            in.close();
            file.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bank;
    }
    
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", preferentialBox=" + this.boxes.preferentialBox +
                ", quickTransactionsBox=" + this.boxes.quickTransactionsBox +
                ", generalBoxes=" + this.boxes.generalBoxes +
                '}';
    }
}