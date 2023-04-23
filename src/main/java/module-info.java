module com.example.sistemaparagerenciamento {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.sistemaparagerenciamento to javafx.fxml;
    exports com.example.sistemaparagerenciamento;
    exports com.example.sistemaparagerenciamento.dao;
    opens com.example.sistemaparagerenciamento.dao to javafx.fxml;
    exports com.example.sistemaparagerenciamento.dao.tecnico;
    opens com.example.sistemaparagerenciamento.dao.tecnico to javafx.fxml;
}