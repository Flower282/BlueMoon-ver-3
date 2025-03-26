package org.example.bluemoon.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"KhoanThu\"", schema = "schema_duong")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class KhoanThu {
    @Id
    private int id;

    @Column(name = "ten_khoan_thu")
    private String tenKhoanThu;

    @Column(name = "loai_khoan_thu")
    @Enumerated(EnumType.STRING)
    private LoaiKhoanThu loaiKhoanThu;

    @Column(name = "so_tien")
    private Long soTien;

    @Column(name = "thoi_han")
    private LocalDate thoiHan;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    //Mỗi khoản thu có thể có nhiều người nộp
    @OneToMany(mappedBy = "khoanThu", cascade = CascadeType.MERGE)
    private List<NopTien> nopTienList = new ArrayList<>();
}
