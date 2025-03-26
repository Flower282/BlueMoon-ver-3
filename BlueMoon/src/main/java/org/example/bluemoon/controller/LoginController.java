package org.example.bluemoon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.bluemoon.models.User;
import org.example.bluemoon.services.LoginService;
import org.example.bluemoon.util.SceneUtil;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label text_empty;
    @FXML
    private Label pass_empty;
    @FXML
    private Label login_failed;
    @FXML
    private Label forgot_password;
    @FXML
    private Button login_button;

    @FXML
    private void initialize() {
        text_empty.setVisible(false);
        pass_empty.setVisible(false);
        login_failed.setVisible(false);
        forgot_password.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Quên mật khẩu");
            alert.setHeaderText("Quên thì thôi, nhớ thì đăng nhập");
            alert.getDialogPane().getStylesheets().add(getClass().getResource("/org/example/bluemoon/style/alert-style.css").toExternalForm());
            alert.setGraphic(null);

            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait();
        });
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        text_empty.setVisible(username.isEmpty());
        pass_empty.setVisible(password.isEmpty());
        login_failed.setVisible(false);
        // Nếu bất kỳ ô nào trống, dừng luôn (return)
        if (username.isEmpty() || password.isEmpty()) {
            return;
        }
        User user = new LoginService().login(username, password);
        if (user != null) {
            Stage stage = (Stage) login_button.getScene().getWindow();
            SceneUtil.changeScene(stage, "/org/example/bluemoon/views/dashboard.fxml");
            stage.centerOnScreen();
        }else {
            login_failed.setVisible(true);
        }
    }


}