module com.example.gamedemo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamedemo1 to javafx.fxml;
    exports com.example.gamedemo1;
}