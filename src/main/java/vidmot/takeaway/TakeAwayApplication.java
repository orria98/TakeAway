package vidmot.takeaway;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TakeAwayApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(PontunController.class.getResource("pontun-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 980, 720);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.MAIN);
        stage.setTitle("Take Away!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
