package app.ui;

import app.controller.ViewClientResultsController;
import app.domain.model.Test;
import app.mappers.dto.TestDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.System.*;
/**
 *
 * @author Miguel Chen 1190897
 */
public class US1Controller implements Initializable {
    @FXML
    private TextField test;

    @FXML
    private TextArea testes;

    private Parent root;

    private Stage stage;

    private Scene scene;

    private ViewClientResultsController vc = new ViewClientResultsController();

    public US1Controller() throws IOException, ClassNotFoundException {
        // this is a constructor empty
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.vc = new ViewClientResultsController();
        }  catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sair1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
        root = loader.load();

        ClientMenu clientMenu = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //System.exit(0);
    }
    @FXML
    void view(){
        List<TestDTO> lstTestsDTO = vc.getTestsDTOCompleteForThisClient();
        List<Test> lstTest = vc.getTestsOrdered(lstTestsDTO);
        this.testes.setText(lstTest.toString());

    }
    @FXML
    void seeResult(ActionEvent event) throws IOException {

        List<TestDTO> lstTestsDTO = vc.getTestsDTOCompleteForThisClient();
        List<Test> lstTest = vc.getTestsOrdered(lstTestsDTO);
        String b = "";
        String[] list = new String[lstTest.size()];
        int x =0;
        for (Test t : lstTest){
            b = t.getNHScode();

            list[x] = b;
            out.println(list[x]);
            x++;
        }
        String a = this.test.getText();
        out.println(a);
        int cont =0;
        for (int i = 0; i<list.length;i++){
            if (a.compareTo(list[i])==0){
                cont++;
            }
        }
        out.println(cont);
        if (cont!=0){
            Test t = this.vc.getTestByNhsCode(this.test.getText());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US1_2.fxml"));
            root = loader.load();

            US1Controller2 u2 = loader.getController();
            u2.view(t);

            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            alerta1(a);
        }

    }
    void alerta1(String code){
        String error =code  + " this code is invalid!";
        Alert alert = new Alert(Alert.AlertType.ERROR, error);
        alert.showAndWait();
    }

}
