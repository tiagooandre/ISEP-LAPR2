package app.ui;

import app.ui.console.MakeReportUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpMenu {
    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    @FXML
    void writeR(ActionEvent event) throws IOException, ClassNotFoundException {
        MakeReportUI mReport = new MakeReportUI();
        mReport.run();

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
