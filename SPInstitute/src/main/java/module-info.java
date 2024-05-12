module com.finalproject.agg2324.spinstitute {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires android.json;
    requires java.desktop;


    opens com.finalproject.agg2324.spinstitute to javafx.fxml;
    exports com.finalproject.agg2324.spinstitute;
    opens com.finalproject.agg2324.spinstitute.pojos to org.hibernate.orm.core;
    exports com.finalproject.agg2324.spinstitute.pojos;
    exports com.finalproject.agg2324.spinstitute.Controllers;
    opens com.finalproject.agg2324.spinstitute.Controllers to javafx.fxml;

}


