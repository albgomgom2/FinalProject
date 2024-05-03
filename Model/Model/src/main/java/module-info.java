module com.agg2324.finalproject.model {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.sql;


    opens com.agg2324.finalproject.model to javafx.fxml;
    exports com.agg2324.finalproject.model;
}