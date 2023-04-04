package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;

/**
 * Karfa klasinn sem erfir frá Matsedill klasanum
 */
public class Karfa extends Matsedill
{
    //Heildarverð pöntunar
    private IntegerProperty heildarverd = new SimpleIntegerProperty();

    /**
     * Smiður fyrir Karfa klasann, inniheldur List Change Listener sem breytir heildarverði pöntunnar
     */
    public Karfa()
    {
        veitingar.addListener((ListChangeListener<Veitingar>) change ->
        {
            while (change.next()) {
                if (change.wasAdded()) {
                    heildarverd.set(heildarverd.get() + change.getAddedSubList().stream().mapToInt(Veitingar::getVerd).sum());
                } else if (change.wasRemoved()) {
                    heildarverd.set(heildarverd.get() - change.getRemoved().stream().mapToInt(Veitingar::getVerd).sum());
                }
            }
        });
    }

    //Getter og setter fyrir heildarverd
    public int getHeildarverd()
    {
        return heildarverd.get();
    }

    public void setHeildarverd(int heildarverd)
    {
        this.heildarverd.set(heildarverd);
    }

    public IntegerProperty heildarverdProperty()
    {
        return heildarverd;
    }

    //Tekur hlut úr körfunni
    public void takaUrKorfu(Veitingar v)
    {
        veitingar.remove(v);
    }

    //Hreinsar körfuna
    public void hreinsaKorfu()
    {
        veitingar.clear();
    }
}
