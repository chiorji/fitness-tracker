module com.trainmax {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.trainmax to javafx.fxml;
    exports com.trainmax;
}