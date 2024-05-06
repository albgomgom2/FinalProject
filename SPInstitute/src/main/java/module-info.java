module com.finalproject.agg2324.spinstitute {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.desktop;
    requires org.hibernate.orm.core;


    opens com.finalproject.agg2324.spinstitute to javafx.fxml;
    exports com.finalproject.agg2324.spinstitute;
    exports com.finalproject.agg2324.spinstitute.pojos;
    opens com.finalproject.agg2324.spinstitute.pojos to javafx.fxml;
}