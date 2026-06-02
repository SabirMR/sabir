module ru.zelmex.trainapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;
    requires jakarta.validation;

    opens com.example.trainapp to javafx.fxml;
    opens com.example.trainapp.model to org.hibernate.orm.core, javafx.base;
    exports com.example.trainapp;
    exports com.example.trainapp.controller.locomotive;
    opens com.example.trainapp.controller.locomotive to javafx.fxml;
    exports com.example.trainapp.controller.series;
    opens com.example.trainapp.controller.series to javafx.fxml;
    exports com.example.trainapp.controller.route;
    opens com.example.trainapp.controller.route to javafx.fxml;
    exports com.example.trainapp.controller.trip;
    opens com.example.trainapp.controller.trip to javafx.fxml;
    opens com.example.trainapp.util to org.hibernate.orm.core;
}