package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Klasinn sem heldur utanum Viðskiptavini
 */
public class Vidskiptavinur {
    //Tilviksbreytur
    private StringProperty nafn = new SimpleStringProperty();

    private StringProperty heimilisfang = new SimpleStringProperty();

    /**
     * Smiður fyrir Vidskiptavinur klasann
     *
     * @param nafn         - nafn viðskiptavinar
     * @param heimilisfang - heimilisfang viðskiptavinar
     */
    public Vidskiptavinur(String nafn, String heimilisfang) {
        this.nafn.setValue(nafn);
        this.heimilisfang.setValue(heimilisfang);
    }

    //Getter-ar og seter-ar fyrir tilviksbreytur
    public String getHeimilisfang() {
        return heimilisfang.get();
    }

    public StringProperty heimilisfangProperty() {
        return heimilisfang;
    }

    public void setHeimilisfang(String heimilisfang) {
        this.heimilisfang.set(heimilisfang);
    }

    public String getNafn() {
        return nafn.get();
    }

    public StringProperty nafnProperty() {
        return nafn;
    }

    public void setNafn(String nafn) {
        this.nafn.set(nafn);
    }
}
