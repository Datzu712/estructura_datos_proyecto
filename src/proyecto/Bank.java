package proyecto;

import java.io.*;

// Singleton
public class Bank implements Serializable {
    private static Bank globalInstance = null;

    public String name;
    public final BoxManager boxes = BoxManager.build();

    private Bank(String name) {
        this.name = name;
    }

    static Bank build(String name) {
        if (globalInstance == null) {
            globalInstance = new Bank(name);
        }
        return globalInstance;
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