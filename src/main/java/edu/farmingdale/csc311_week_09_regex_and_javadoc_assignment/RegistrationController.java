package edu.farmingdale.csc311_week_09_regex_and_javadoc_assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class RegistrationController {

    @FXML
    private TextField date_of_birthday_text_field;

    @FXML
    private TextField email_text_field;

    @FXML
    private TextField first_name_text_field;

    @FXML
    private TextField last_name_text_field;

    @FXML
    private Button register_button;

    @FXML
    private TextField zipcode_text_field;

    @FXML
    private TextField password_text_field;

    // Regex patterns for validation
    private static final String NAME_PATTERN = "^[A-Za-z]{2,25}$";
    private static final String DOB_PATTERN = "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$";
    private static final String EMAIL_PATTERN = "^[a-z]+\\d*@farmingdale\\.edu$";
    private static final String ZIP_CODE_PATTERN = "^\\d{5}$";
    private static final String PASSWORD_PATTERN = "^[0-9A-Za-z]{8,20}$";

    /**
     * Initializes event listeners for each input field to provide validation feedback
     * and to enable the register button only when all fields are valid.
     */
    @FXML
    public void initialize() {
        register_button.setDisable(true);

        first_name_text_field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateField(first_name_text_field, NAME_PATTERN);
            enableRegisterButton();
        });

        last_name_text_field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateField(last_name_text_field, NAME_PATTERN);
            enableRegisterButton();
        });

        date_of_birthday_text_field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateField(date_of_birthday_text_field, DOB_PATTERN);
            enableRegisterButton();
        });

        email_text_field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateField(email_text_field, EMAIL_PATTERN);
            enableRegisterButton();
        });

        zipcode_text_field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateField(zipcode_text_field, ZIP_CODE_PATTERN);
            enableRegisterButton();
        });

        password_text_field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) validateField(password_text_field, PASSWORD_PATTERN);
            enableRegisterButton();
        });
    }

    /**
     * Validates the given TextField's input against the specified regex pattern.
     * Changes the TextField border color based on validity.
     *
     * @param textField The TextField to validate.
     * @param pattern   The regex pattern for validation.
     * @throws IllegalArgumentException if the text field or pattern is null.
     */
    private void validateField(TextField textField, String pattern) {
        if (!textField.getText().matches(pattern)) {
            textField.setStyle("-fx-border-color: red;");
            textField.setPromptText("Invalid input");
        } else {
            textField.setStyle("-fx-border-color: green;");
        }
    }

    /**
     * Enables the register button if all fields are valid, otherwise disables it.
     */
    private void enableRegisterButton() {
        boolean allValid = first_name_text_field.getText().matches(NAME_PATTERN) &&
                last_name_text_field.getText().matches(NAME_PATTERN) &&
                date_of_birthday_text_field.getText().matches(DOB_PATTERN) &&
                email_text_field.getText().matches(EMAIL_PATTERN) &&
                zipcode_text_field.getText().matches(ZIP_CODE_PATTERN) &&
                password_text_field.getText().matches(PASSWORD_PATTERN);

        register_button.setDisable(!allValid);
    }

    @FXML
    void handleRegister(ActionEvent event) {
        // Logic to navigate to the new UI upon successful registration
        System.out.println("Registration successful!");
    }
}
