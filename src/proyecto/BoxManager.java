package proyecto;

import java.util.List;
import java.io.Serializable;

// singleton pattern / We only need 1 instance of this class
public class BoxManager implements Serializable {
    private static BoxManager globalInstance = null;

    public Box preferentialBox = null;
    public Box quickTransactionsBox = null;
    public List<Box> generalBoxes = null;

    private BoxManager() {}

    public static BoxManager build() {
        if (BoxManager.globalInstance == null) {
            BoxManager.globalInstance = new BoxManager();
        }
        return BoxManager.globalInstance;
    }

    // class builders
    public BoxManager setPreferentialBox(Box preferentialBox) {
        this.preferentialBox = preferentialBox;

        return this;
    }
    public BoxManager setQuickTransactionsBox(Box quickTransactionsBox) {
        this.quickTransactionsBox = quickTransactionsBox;

        return this;
    }
    public BoxManager setGeneralBoxes(List<Box> generalBoxes) {
        this.generalBoxes = generalBoxes;

        return this;
    }
}
