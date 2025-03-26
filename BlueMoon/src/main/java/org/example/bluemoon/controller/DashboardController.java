package org.example.bluemoon.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.bluemoon.dao.HoKhauDAO;
import org.example.bluemoon.dao.NhanKhauDAO;
import org.example.bluemoon.util.SceneUtil;

public class DashboardController {
    @FXML
    private Button logoutButton;
    @FXML
    private Label tongHoKhau;

    @FXML
    private Label tongNhanKhau;

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    public void initialize() {
        tongHoKhau.setText(String.valueOf(new HoKhauDAO().tongSoHoKhau()));
        tongNhanKhau.setText(String.valueOf(new NhanKhauDAO().tongSoNhanKhau()));
        // Đặt danh mục cho trục X
        xAxis.setCategories(FXCollections.observableArrayList("Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5"));

        // Cấu hình trục y để không tự động mở rộng phạm vi
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(300);  // Đặt giá trị tối đa, tùy chỉnh theo dữ liệu
        yAxis.setTickUnit(50);     // Định nghĩa bước nhảy giữa các mốc trên trục y
        // Cấu hình dữ liệu ban đầu
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Số hộ khẩu");

// Thêm dữ liệu vào biểu đồ
        series.getData().add(new XYChart.Data<>("Quận 1", 150));
        series.getData().add(new XYChart.Data<>("Quận 2", 200));
        series.getData().add(new XYChart.Data<>("Quận 3", 180));
        series.getData().add(new XYChart.Data<>("Quận 4", 220));
        series.getData().add(new XYChart.Data<>("Quận 5", 170));


        barChart.getData().add(series);
        barChart.setLegendVisible(false);
    }

    @FXML
    private void logout(ActionEvent event) {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        SceneUtil.changeScene(stage, "/org/example/bluemoon/views/login.fxml");
        stage.centerOnScreen();
    }

}