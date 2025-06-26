module org.example.app {
    requires javafx.controls;
    requires javafx.fxml;
//    requires rxtx;
    requires obd.java.api;
    requires RXTXcomm;


    opens org.example.app to javafx.fxml;
    exports org.example.app;
    exports org.example.app.controller;
    opens org.example.app.controller to javafx.fxml;
}