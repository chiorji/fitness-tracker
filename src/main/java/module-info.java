module com.fitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fitnesstracker to javafx.fxml;
    exports com.fitnesstracker;
}