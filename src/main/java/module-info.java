module com.example.project8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project8 to javafx.fxml;
    exports com.example.project8;
}