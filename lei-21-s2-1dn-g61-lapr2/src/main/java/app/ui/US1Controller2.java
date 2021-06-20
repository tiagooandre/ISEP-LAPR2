package app.ui;

import app.controller.ViewClientResultsController;
import app.domain.model.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Miguel Chen 1190897
 */
public class US1Controller2 implements Initializable {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private TextArea result;

    private ViewClientResultsController vc = new ViewClientResultsController();

    public US1Controller2() throws IOException, ClassNotFoundException {
        // this is a constructor empty
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.vc = new ViewClientResultsController();
        }   catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sair12(ActionEvent event){
        System.exit(0);
    }
    @FXML
    void view(Test code){
        this.result.setText(this.vc.getResultsForThisTest(code).toString());
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US1.fxml"));
        root = loader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
