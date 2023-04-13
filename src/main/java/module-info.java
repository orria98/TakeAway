module vidmot.takeaway {
    requires javafx.controls;
    requires javafx.fxml;
    requires algs4;
    requires org.junit.jupiter.api;
    requires junit;
    requires org.junit.jupiter.engine;


    opens vidmot.takeaway to javafx.fxml;
    exports vidmot.takeaway;
    exports vinnsla to junit;
}
