package edu.farmingdale.csc311_week_09_regex_and_javadoc_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {


    @FXML
    private Button create_your_account;

    @FXML
    private TextField passwordL_text_field;

    @FXML
    private Pane root;

    @FXML
    private Button sign_in_with_username;

    @FXML
    private TextField usernameL_text_field;

    @FXML
    private Label welcomeText;

    @FXML
    void handleCreateAccount(ActionEvent event) {

        try {
            // Load the registration page FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration-page.fxml"));
            Scene registrationScene = new Scene(fxmlLoader.load());

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(registrationScene);
            currentStage.setTitle("Registration Page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
