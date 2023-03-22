module com.example.sistemaparagerenciamento {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.sistemaparagerenciamento to javafx.fxml;
    exports com.example.sistemaparagerenciamento;
}