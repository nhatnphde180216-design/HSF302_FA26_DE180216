package com.hsf302.student.repository;

import com.hsf302.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Derived Query: Tìm kiếm theo mã SV hoặc họ tên chứa từ khóa (không phân biệt hoa thường), sắp xếp id tăng dần
    List<Student> findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrderByIdAsc(
            String studentCode, String fullName);

    // Derived Query: Kiểm tra mã sinh viên đã tồn tại (dùng khi thêm mới)
    boolean existsByStudentCodeIgnoreCase(String studentCode);

    // Derived Query: Kiểm tra mã sinh viên trùng ở bản ghi khác (dùng khi cập nhật, bỏ qua id hiện tại)
    boolean existsByStudentCodeIgnoreCaseAndIdNot(String studentCode, Long id);
}
