package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matsedill
{
    //Observable listi af veitingum
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    //Getter fyrir listann
    public ObservableList<Veitingar> getVeitingar()
    {
        return veitingar;
    }

    //setur gögn í matseðil/körfu
    public void setjaGogn(Veitingar v)
    {
        veitingar.add(v);
    }

}
