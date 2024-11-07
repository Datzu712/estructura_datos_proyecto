package proyecto;

import java.io.Serializable;

public class Nodo<T> implements Serializable {
    private T currentValue;
    private Nodo<T> nextValue;

    public Nodo(T currentValue) {
        this.currentValue = currentValue;
        this.nextValue = null;
    }

    public void setNextValue(T nextValue) {
        this.nextValue = new Nodo<T>(nextValue);
    }
    public void setNextValue(Nodo<T> nextValue) {
        this.nextValue = nextValue;
    }

    public Nodo<T> getNextValue() {
        return this.nextValue;
    }

    public T getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(T currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "Nodo{" + "currentValue=" + this.currentValue + '}';
    }
}
