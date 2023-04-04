package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veitingar
{

    //Tilviksbreytur
    private StringProperty rettir = new SimpleStringProperty();

    private IntegerProperty verd = new SimpleIntegerProperty();

    /**
     * Smiður fyrir Veitingar
     *
     * @param rettir Rétturinn
     * @param verd   Verðið á honum
     */
    public Veitingar(String rettir, int verd)
    {
        this.rettir.setValue(rettir);
        this.verd.setValue(verd);
    }

    //Getterar og seterar fyrir tilviksbreytur
    public String getRettir()
    {
        return rettir.get();
    }

    public StringProperty rettirProperty()
    {
        return rettir;
    }

    public int getVerd()
    {
        return verd.get();
    }

    public IntegerProperty verdProperty()
    {
        return verd;
    }

    //toString aðferð
    public String toString()
    {
        return rettir.getValue() + " " + verd.getValue() + "kr";
    }
}
