module edu.farmingdale.csc311_week_09_regex_and_javadoc_assignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;

    opens edu.farmingdale.csc311_week_09_regex_and_javadoc_assignment to javafx.fxml;
    exports edu.farmingdale.csc311_week_09_regex_and_javadoc_assignment;
}