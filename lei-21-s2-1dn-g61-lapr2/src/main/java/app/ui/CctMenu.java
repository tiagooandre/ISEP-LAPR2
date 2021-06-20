package app.ui;

import app.ui.console.CheckResultUI;
import app.ui.console.RegisterTestResultUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CctMenu  {
    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    @FXML
    void registerTR(ActionEvent event) throws IOException, ClassNotFoundException {
        RegisterTestResultUI reg = new RegisterTestResultUI();
        reg.run();

    }

    @FXML
    void viewCT(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US13.fxml"));
        root = loader.load();

        US13Controller u13 = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = loader.load();

        FXMLController mainMenu = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
