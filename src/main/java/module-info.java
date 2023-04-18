module vidmot.takeaway {
    requires javafx.controls;
    requires javafx.fxml;
    requires algs4;
    requires junit;

    opens vidmot.takeaway to javafx.fxml;
    exports vidmot.takeaway;
    exports vinnsla to junit;
}
