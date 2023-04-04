package vidmot.takeaway;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import vinnsla.Matsedill;
import vinnsla.Veitingar;

import java.io.IOException;

/**
 * Sérhæfði klasinn MatsedillView
 */
public class MatsedillView extends ListView<Veitingar>
{
    /**
     * Smiður fyrir MatsedillView, smíðir nýjan matseðil og setur í listann, hleður einnig inn fxml skránni
     * matsedill-view
     */
    public MatsedillView()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        Matsedill m = new Matsedill();
        m.setjaGogn(new Veitingar("Marinara", 1090));
        m.setjaGogn(new Veitingar("Margherita", 1990));
        m.setjaGogn(new Veitingar("Diavola", 2090));
        m.setjaGogn(new Veitingar("Parma", 2490));
        m.setjaGogn(new Veitingar("Padrino", 2590));
        m.setjaGogn(new Veitingar("Nduja", 2590));
        m.setjaGogn(new Veitingar("Umberto", 2790));
        m.setjaGogn(new Veitingar("Tartufo", 2790));

        setItems(m.getVeitingar());
    }
}
