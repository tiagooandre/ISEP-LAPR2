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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Miguel Chen 1190897
 */
public class US18Controller implements Initializable {
    @FXML
    private TextField interval;
    @FXML
    private TextField it;
    @FXML
    private MenuButton alg;

    private ManualReportController mc = new ManualReportController();

    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    private String a = "";

    public US18Controller() throws IOException, ClassNotFoundException {
        // this is a constructor empty
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.mc = new ManualReportController();
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void exit18 (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdmMenu.fxml"));
        root = loader.load();

        AdmMenu u2 = loader.getController();


        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    /*@FXML
    void choseOne(){
        this.item1 = new MenuItem("Linear");
        this.item2 = new MenuItem("Multi");
        this.alg = new MenuButton("Select one",null,item1,item2);*/
    //}
    @FXML
    void save18(ActionEvent event) throws IOException {

        String its = this.interval.getText();

        String alg = this.it.getText();
        if (alg.equals("Linear")|| alg.equals("Multi")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US18_2.fxml"));
            root = loader.load();

            US18Controller2 u2 = loader.getController();
            u2.view(alg,its);

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            aaalert(alg);
        }
    }
    void aaalert(String alg){
        String error = alg + " this Algorithm is invalid!";
        Alert alert = new Alert(Alert.AlertType.ERROR, error);
        alert.showAndWait();
    }
}

