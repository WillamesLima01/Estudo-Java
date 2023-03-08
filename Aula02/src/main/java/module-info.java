module com.example.aula01_helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aula01_helloworld to javafx.fxml;
    exports com.example.aula01_helloworld;
}