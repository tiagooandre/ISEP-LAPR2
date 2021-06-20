package app.ui;

import app.controller.CheckResultController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
/**
 *
 * @author Miguel Chen 1190897
 */
public class US13Controller implements Initializable {


    @FXML
    private TextArea text;

    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;



        @FXML
        private TextField numberField;

        @FXML
        private ScrollPane listC;

        @FXML
        private Button okButton;

        private CheckResultController crc = new CheckResultController();

    public US13Controller() throws IOException, ClassNotFoundException {
        // this is a constructor empty
    }


    public MainJAVAFX getFx(){
            return this.fx;
        }
        public void setMain(MainJAVAFX fx){
            this.fx = fx;
        }

        public CheckResultController getController() {
            return this.crc;
        }
    @FXML
        void showClients() throws IOException {

            this.text.setText(this.crc.convert(this.crc.sortList()));
        }
    @FXML
          void view(ActionEvent event) throws IOException {
            int a = Integer.parseInt(numberField.getText());
             if (a < this.crc.sizeMatters(this.crc.sortList()) && a>-1  )  {
                /* US13Controller2 u2 = new US13Controller2();
                 u2.ss(a);*/
                 //this.fx.toTestScene(a);
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/US13_2.fxml"));
                 root = loader.load();

                 US13Controller2 u2 = loader.getController();
                 u2.ss(a);

                 stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                 scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();


            }else{
                 aalert(a);
             }


        }
        void aalert(int size){
            String error = size + " this number is invalid!";
            Alert alert = new Alert(Alert.AlertType.ERROR, error);
            alert.showAndWait();
        }

    @FXML
    void sair(ActionEvent event) throws IOException {
        FXMLLoader loader10 = new FXMLLoader(getClass().getResource("/fxml/CctMenu.fxml"));
        root = loader10.load();

        CctMenu c = loader10.getController();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

        public void initialize(URL url, ResourceBundle resourceBundle) {
            try {
                this.crc = new CheckResultController();
            }  catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        @FXML
    void enable(ActionEvent event){
        this.okButton.setDisable(false);
        }

    }






