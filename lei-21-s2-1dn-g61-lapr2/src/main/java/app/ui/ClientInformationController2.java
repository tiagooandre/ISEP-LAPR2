package app.ui;

import app.controller.ClientInformationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ClientInformationController2 {

    ClientInformationController vcrc= new ClientInformationController();

    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    @FXML
    TextArea informationArea;

    @FXML
    TextField attributeField;

    @FXML
    TextField newField;

    public ClientInformationController2() throws IOException, ClassNotFoundException {
        //this is a constructor empty
    }

    @FXML
    void showInfo(ActionEvent actionEvent){
        vcrc.getClient();
        informationArea.setText(vcrc.clientData());
    }


    @FXML
    void updateInfo(ActionEvent actionEvent) {
        int i = Integer.parseInt(attributeField.getText());
        if(i>0 && i<8){
            String info = newField.getText();
            try{
                vcrc.changeData(i, info);
                Alert updated = new Alert(Alert.AlertType.INFORMATION, "Your personal information was updated\nFor security reasons restart the login session");
                updated.showAndWait();
            }catch(IllegalArgumentException e){
                Alert invalid = new Alert(Alert.AlertType.WARNING, "The introduced information is invalid");
                invalid.showAndWait();
            }
        }
        else{
            Alert canceled = new Alert(Alert.AlertType.WARNING, "Invalid attribute number");
            canceled.showAndWait();
        }
        showInfo(null);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
        root = loader.load();

        ClientMenu clientMenu = loader.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
