module com.finalproject.agg2324.spinstitute {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.desktop;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens com.finalproject.agg2324.spinstitute to javafx.fxml;
    exports com.finalproject.agg2324.spinstitute;
    opens com.finalproject.agg2324.spinstitute.pojos to javafx.fxml;
    exports com.finalproject.agg2324.spinstitute.pojos;
}


