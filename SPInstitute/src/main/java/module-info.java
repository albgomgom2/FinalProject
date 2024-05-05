module com.finalproject.agg2324.spinstitute {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.finalproject.agg2324.spinstitute to javafx.fxml;
    exports com.finalproject.agg2324.spinstitute;
}