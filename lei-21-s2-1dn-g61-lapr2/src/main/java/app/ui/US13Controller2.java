package app.ui;

import app.controller.CheckResultController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Miguel Chen 1190897
 */
public class US13Controller2 implements Initializable {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private ScrollPane field;
    @FXML
    private TextArea olas;
    private MainJAVAFX fx;

    private CheckResultController crc = new CheckResultController();

    public US13Controller2() throws IOException, ClassNotFoundException {
        //this is a constructor empty
    }

    @FXML
     void ss(int ola) throws IOException {

        this.olas.setText(this.crc.convert2(this.crc.getTestFromCL(this.crc.sortList().get(ola))));

    }
    public void setM(MainJAVAFX fx){
        this.fx = fx;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.crc = new CheckResultController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sair(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void continueS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US13.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
