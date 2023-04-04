package vidmot.takeaway;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Vidskiptavinur;

import java.io.IOException;
import java.util.Optional;

/**
 * Dialog fyrir nýskráningu, notandi þarf að setja inn nafn og heimilisfang
 */
public class VidskiptavinurDialog extends Dialog<Vidskiptavinur>
{

    @FXML
    private TextField fxNafn;
    @FXML
    private TextField fxHeimilisfang;
    @FXML
    private ButtonType fxILagi;


    /**
     * Smiður fyrir dialoginn, stillir á lesaVidskiptavinurDialog dialog pane, inniheldur regly fyrir "í lagi" takkann
     * og er með set result converter sem skilar nýjum viðskiptavin þegar notandi smellir á í lagi
     */
    public VidskiptavinurDialog()
    {
        setDialogPane(lesaVidskiptavinurDialog());

        iLagiRegla();

        setResultConverter(b ->
        {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return new Vidskiptavinur(fxNafn.getText(), fxHeimilisfang.getText());
            } else {
                return null;
            }
        });
    }

    //Dialog pane sem hleður inn fxml skránni vidskiptavinur-view
    private DialogPane lesaVidskiptavinurDialog()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vidskiptavinur-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //Regla sem gerir "í lagi" takkann óvirkann ef notandi hefur ekki sett inn nafn og heimilisfang
    private void iLagiRegla()
    {
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty().bind(fxNafn.textProperty().isEmpty().or(fxHeimilisfang.textProperty().isEmpty()));
    }

    //Getter fyrir Viðskiptavininn sem notandinn býr til í dialoginum
    public Vidskiptavinur getNafnVidskiptavinar()
    {
        Optional<Vidskiptavinur> vv = showAndWait();
        return vv.orElse(null);
    }
}
