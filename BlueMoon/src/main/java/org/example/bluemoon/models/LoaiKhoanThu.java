package org.example.bluemoon.models;

public enum LoaiKhoanThu {
    TU_NGUYEN("Tự nguyện"),
    BAT_BUOC("Bắt buộc");
    private final String LoaiKhoanThuVN;

    LoaiKhoanThu(String loaiKhoanThuVN) {
        LoaiKhoanThuVN = loaiKhoanThuVN;
    }

    public String getLoaiKhoanThuVN() {
        return LoaiKhoanThuVN;
    }
}
