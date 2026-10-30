module com.fu.ch08 {
    requires javafx.controls;
    requires javafx.fxml;

    // Common utilities
    exports com.fu.ch08.common;

    // B1–B3: UI viết bằng code thuần → chỉ cần exports
    exports com.fu.ch08.b1;
    exports com.fu.ch08.b2;
    exports com.fu.ch08.b3;

    // B4: FXML + Controller → cần opens cho javafx.fxml reflection
    opens com.fu.ch08.b4 to javafx.fxml;
    exports com.fu.ch08.b4;

    // Hỗ trợ demo login ban đầu (nếu chạy HelloApplication)
    opens com.fu.demologin to javafx.fxml;
    exports com.fu.demologin;
}
