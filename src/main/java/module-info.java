module com.example.lab5_try2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab5_try2 to javafx.fxml;
    exports com.example.lab5_try2;
}