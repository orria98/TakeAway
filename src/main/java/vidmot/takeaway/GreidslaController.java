package vidmot.takeaway;

import edu.princeton.cs.algs4.StdRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vinnsla.Karfa;
import vinnsla.Vidskiptavinur;


public class GreidslaController
{
    public Label fxAfhending;
    @FXML
    public Label fxTilGreidslu;
    public Vidskiptavinur vv;
    public Karfa k;
    public Label fxTilbuin;
    private PontunController pontunController;

    /**
     * Initialize aðferð fyrir Greiðsla Controller, sækir pontuncontrollerinn og setur vv og k sem vidskiptavinur
     * og karfa úr pontuncontroller. Bindur einnig heildarverðið úr körfunni við label fxTilGreidslu
     */
    public void initialize()
    {
        pontunController = (PontunController) ViewSwitcher.lookup(View.MAIN);
        vv = pontunController.vidskiptavinur;
        k = pontunController.karfa;

        fxTilGreidslu.textProperty().bind(k.heildarverdProperty().asString());
    }


    /**
     * Takki sem tekur notanda til baka í aðalvalmynd
     *
     * @param actionEvent
     */
    public void fxTilBakaHandler(ActionEvent actionEvent)
    {
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Takki til að staðfesta pöntun, birtir streng sem segir notanda hvenær pöntun verður tilbúin (Slembitala á
     * bilinu 15-40). Hreinsar svo körfuna, bæði körfuna sjálfa og listview körfuna.
     *
     * @param actionEvent
     */
    public void fxStadfestaHandler(ActionEvent actionEvent)
    {
        fxTilbuin.setText("Pöntunin þín verður tilbúin til afhendingar innan " + StdRandom.uniform(15, 41) + " mínutna á: ");
        fxAfhending.textProperty().bind(vv.heimilisfangProperty());
        pontunController.fxKarfa.getItems().clear();
        k.hreinsaKorfu();
    }
}
