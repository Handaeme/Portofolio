module com.pbo.mhscrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens com.pbo.mhscrud to javafx.fxml;
    exports com.pbo.mhscrud;
}