package app.ui;

import app.controller.AuthController;
import app.controller.SerialController;
import app.domain.model.AutoReportNHS;
import app.domain.shared.Constants;
import app.ui.console.*;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static java.lang.System.*;

public class FXMLController implements Initializable {

    private MainJAVAFX fx;

    private Parent root;

    private Stage stage;

    private Scene scene;

    private AuthController ctrl;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField emailText;

    @FXML
    void login(ActionEvent event) throws IOException, ClassNotFoundException {
        ctrl = new AuthController();

        boolean success = doLogin();

        if (success)
        {
            List<UserRoleDTO> roles = this.ctrl.getUserRoles();
            if ( (roles == null) || (roles.isEmpty()) )
            {
                Alert a = new Alert(Alert.AlertType.WARNING, "User has not any role assigned.");
            }
            else
            {
                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role))
                {
                    List<MenuItem> rolesUI = getMenuItemForRoles();
                    this.redirectToRoleUI(rolesUI,role, event);
                }
                else
                {
                    Alert a = new Alert(Alert.AlertType.WARNING, "User did not select a role.");
                }
            }
        }
        //this.logout();
    }

    private List<MenuItem> getMenuItemForRoles()
    {
        List<MenuItem> rolesUI = new ArrayList<>();
        rolesUI.add(new MenuItem(Constants.ROLE_ADMIN, new AdminUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_RECEPTIONIST, new ReceptionistUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_LABORATORYCOORDINATOR, new LabCuUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_MEDICALLABTECHNICIAN, new MedicalLabTechnicianUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_SPECIALISTDOCTOR,  new SpecialistDoctorUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST,  new ClinicalTecUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_CLIENT,new ClientUI()));

        return rolesUI;
    }

    private boolean doLogin(){
        int maxAttempts = 3;
        boolean success = false;
        do
        {
            maxAttempts--;
            String id = emailText.getText();
            String pwd = passwordText.getText();

            success = ctrl.doLogin(id, pwd);
            if (!success)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Invalid UserId and/or Password. \n You have  " + maxAttempts + " more attempt(s).");
                alertInvalidUser();
            }

        } while (!success && maxAttempts > 0);
        return success;
    }

    private void logout()
    {
        ctrl.doLogout();
    }

    private void redirectToRoleUI(List<MenuItem> rolesUI, UserRoleDTO role, ActionEvent event) throws IOException {

        //Client
        if (role.getId().compareTo("CLIENT") == 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenu.fxml"));
            root = loader.load();

            ClientMenu clientMenu = loader.getController();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            if (role.getId().compareTo("CLINICAL CHEMISTRY TECHNOLOGIST") == 0) {
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/fxml/CctMenu.fxml"));
                root = loader1.load();

                CctMenu cctMenu = loader1.getController();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                if (role.getId().compareTo("SPECIALIST DOCTOR") == 0) {
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/fxml/SpMenu.fxml"));
                    root = loader2.load();

                    SpMenu spMenu = loader2.getController();

                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    if (role.getId().compareTo("ADMINISTRATOR") == 0) {
                        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/AdmMenu.fxml"));
                        root = loader3.load();

                        AdmMenu cctMenu = loader3.getController();

                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    } else {
                        if (role.getId().compareTo("RECEPTIONIST") == 0) {
                            FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/fxml/RecepMenu.fxml"));
                            root = loader4.load();

                            RepMenu repMenu = loader4.getController();

                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();

                        } else {
                            if (role.getId().compareTo("LABORATORY COORDINATOR") == 0) {
                                FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/fxml/LabcMenu.fxml"));
                                root = loader4.load();

                                LabcMenu labcMenu = loader4.getController();

                                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();

                            } else {
                                if (role.getId().compareTo("MEDICAL LAB TECHNICIAN") == 0) {
                                    FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/fxml/MltMenu.fxml"));
                                    root = loader4.load();

                                    MltMenu mltMenu = loader4.getController();

                                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.show();

                                } else {
                                    out.println("id was" + role.getId());

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }

    void alertInvalidUser() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "This user doesn't exist.");
        alert.showAndWait();
    }


    @FXML
    void exit(ActionEvent event) throws IOException, ClassNotFoundException {
        //AutoReportNHS.timer.cancel();
        SerialController sp = new SerialController();
        sp.serializeList();
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void go_consola(ActionEvent actionEvent) {
        Main.main(null);

    }
}
