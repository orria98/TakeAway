package vidmot.takeaway;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vinnsla.Karfa;
import vinnsla.Veitingar;
import vinnsla.Vidskiptavinur;

import java.util.Optional;

public class PontunController
{
    @FXML
    public MatsedillView fxMatsedillView;
    @FXML
    ListView<Veitingar> fxKarfa;
    @FXML
    private Label fxNafnLabel;
    @FXML
    public Label fxHeildarverd;
    @FXML
    private Button fxSetjaIKorfu;
    @FXML
    private Button fxTakaUrKorfu;
    @FXML
    private Button fxNyskra;
    @FXML
    private Button fxInnskraning;
    @FXML
    private Button fxGreida;

    private BooleanProperty erInnskradur = new SimpleBooleanProperty(false);

    public Vidskiptavinur vidskiptavinur;

    public Karfa karfa;

    /**
     * Initialize aðferð fyrir aðal controllerinn. Inniheldur reglu fyrir nokkra takka og býr til nýja körfu.
     * Bindur heildarðverð körfunnar við label fxHeildarverd
     */
    public void initialize()
    {
        innskradurRegla();
        karfa = new Karfa();

        fxHeildarverd.textProperty().bind(karfa.heildarverdProperty().asString());

    }

    // Takki sem færir notanda í greiðslugluggann
    public void fxGreidaHandler(ActionEvent actionEvent)
    {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    /**
     * Takki sem opnar nýskráningar dialoginn "VidskiptaivnurDialog", ef notandi er búinn að skrá sig verður
     * "erInnskradur" satt og takkinn "Innskráning" verður virkur
     *
     * @param actionEvent
     */
    public void fxNyskraHandler(ActionEvent actionEvent)
    {
        VidskiptavinurDialog d = new VidskiptavinurDialog();
        vidskiptavinur = d.getNafnVidskiptavinar();
        if (vidskiptavinur != null) {
            erInnskradur.set(true);
        }

    }

    /**
     * Takki sem opnar innskráningar dialoginn "LoginDialog", ef viðskiptavinur hefur skráð sig inn með lykilorði
     * birtist nafn hans í aðalviðmótinu.
     *
     * @param actionEvent
     */
    public void fxInnskraningHandler(ActionEvent actionEvent)
    {
        Dialog<String> loginDialog = new LoginDialog(vidskiptavinur);
        Optional<String> lykilord = loginDialog.showAndWait();
        if (lykilord.isPresent()) {
            fxNafnLabel.textProperty().bind(vidskiptavinur.nafnProperty());
        }

    }

    //Setur valinn rétt í körfuna og í listview gluggann
    public void fxSetjaIKorfuHandler(ActionEvent actionEvent)
    {
        Veitingar valinnRettur = fxMatsedillView.getSelectionModel().getSelectedItem();
        if (valinnRettur != null) {
            karfa.setjaGogn(valinnRettur);
            fxKarfa.getItems().add(valinnRettur);
        }
    }

    //Tekur valinn rétt úr körfunni og úr listview glugganum
    public void fxTakaUrKorfuHandler(ActionEvent actionEvent)
    {
        Veitingar valinnRettur = fxKarfa.getSelectionModel().getSelectedItem();
        if (valinnRettur != null) {
            fxKarfa.getItems().remove(valinnRettur);
            karfa.takaUrKorfu(valinnRettur);
        }

    }

    //Regla sem gerir innskráning og greiðsla takkana óvirka ef notandi er ekki nýskráður
    private void innskradurRegla()
    {
        fxInnskraning.disableProperty().bind(erInnskradur.not());
        fxGreida.disableProperty().bind(erInnskradur.not());
    }
}
