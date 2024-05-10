module com.finalproject.finalproject.pruebas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.javadoc;


    opens com.finalproject.finalproject.pruebas to javafx.fxml;
    exports com.finalproject.finalproject.pruebas;
}