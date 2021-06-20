package app.ui;

import app.ui.console.RegisterClientUI;
import app.ui.console.RegisterTestUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RepMenu {
    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    @FXML
    void registerClient(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        RegisterClientUI rc = new RegisterClientUI();
        rc.run();
    }

    @FXML
    void registerTest(ActionEvent actionEvent) {
        RegisterTestUI rt = new RegisterTestUI();
        rt.run();
    }

    @FXML
    void exit(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = loader.load();

        FXMLController mainMenu = loader.getController();

        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
