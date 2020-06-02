package kr.co.bikeda.store;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StoreMain extends Application {
	private File path = new File("");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start( Stage stage ) throws Exception {
    	
    	FXMLLoader loader = new FXMLLoader( new File(path.getAbsolutePath()+ "/resources/fxml/view/Login.fxml").toURL() );
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.TRANSPARENT);
//		stage.getIcons().add(new Image("/image/symbol.png"));
		stage.centerOnScreen();
		stage.setScene(scene);
		stage.show();
    }

}
