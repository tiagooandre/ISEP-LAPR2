package app.ui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainJAVAFX extends Application {

    private static final double SCENE_WIDTH = 600;
    private static final double SCENE_HEIGHT = 400;
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/US1.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/US13.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/US13.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/US17.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/US18.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/ClientMenu.fxml"));

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /*public Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainJAVAFX.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainJAVAFX.class.getResource(fxml));
        Pane page;
        try {
            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().add("/styles/Styles.css");
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        return (Initializable) loader.getController();
    }
    public void toTestScene(int ola) {
        try {
            US13Controller2 u2 = (US13Controller2) replaceSceneContent("/fxml/US13.2.fxml");
            u2.setM(this);
            u2.ss(ola);
        } catch (Exception ex) {
            Logger.getLogger(MainJAVAFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
