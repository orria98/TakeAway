package vidmot.takeaway;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Vidskiptavinur;

import java.io.IOException;

/**
 * Dialogur fyrir innskráningu.
 */
public class LoginDialog extends Dialog<String>
{
    @FXML
    public Label fxNafn;
    public TextField fxLykilord;
    public ButtonType fxILagi;

    /**
     * Smiður fyrir login dialog-inn sem stillir á dialogpane fyrir innskráningu, nafn notanda birtist fyrir ofan
     * lykilorðið. Inniheldur reglu fyrir "í lagi" takkann og er svo með set result converter sem skilar lykilorðinu
     * sem notandi slær inn.
     *
     * @param v tekur inn Vidskiptavinur hlut
     */
    public LoginDialog(Vidskiptavinur v)
    {
        setDialogPane(lesaLoginDialog());

        iLagiRegla();

        setResultConverter(b ->
        {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return fxLykilord.getText();
            } else {
                return null;
            }
        });
        fxNafn.setText(v.getNafn());
    }

    // DialogPane sem sækir login-view fxml skrá
    private DialogPane lesaLoginDialog()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    // Regla sem gerir "í lagi" takkann óvirkan ef notandi hefur ekki slegið inn lykilorði
    private void iLagiRegla()
    {
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty().bind(fxLykilord.textProperty().isEmpty());

    }

}
