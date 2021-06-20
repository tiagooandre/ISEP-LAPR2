package app.ui;

import app.controller.ManualReportController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Miguel Chen 1190897
 */
public class US18Controller2 implements Initializable {
    @FXML
    private TextArea fd;

    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;
    private ManualReportController mc = new ManualReportController();

    public US18Controller2() throws IOException, ClassNotFoundException {
        // this is a constructor empty
    }

    @FXML
    void view(String ola, String ola2) throws IOException {
        this.fd.setText(this.mc.showReport(ola, ola2));
    }
    @FXML
    void send(ActionEvent event){
        this.mc.send(this.fd.getText());
        alerta();

    }
    @FXML
    void exit182(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdmMenu.fxml"));
        root = loader.load();

        AdmMenu adm = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.mc = new ManualReportController();
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
    void alerta(){
        String ola = "Report Sent";
        Alert alert = new Alert(Alert.AlertType.INFORMATION, ola);
        alert.showAndWait();
    }
}
