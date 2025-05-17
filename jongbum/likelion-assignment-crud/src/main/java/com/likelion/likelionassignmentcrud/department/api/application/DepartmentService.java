package com.likelion.likelionassignmentcrud.department.api.application;

import com.likelion.likelionassignmentcrud.department.api.dto.request.DepartmentSaveRequestDto;
import com.likelion.likelionassignmentcrud.department.api.dto.response.DepartmentInfoResponseDto;
import com.likelion.likelionassignmentcrud.department.api.dto.response.DepartmentListResponseDto;
import com.likelion.likelionassignmentcrud.department.domain.Department;
import com.likelion.likelionassignmentcrud.department.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    
    // 부서 정보 저장
    @Transactional
    public void departmentSave(DepartmentSaveRequestDto departmentSaveRequestDto) {
        Department department = Department.builder()
                .name(departmentSaveRequestDto.name())
                .part(departmentSaveRequestDto.part())
                .build();
        departmentRepository.save(department);
    }
    
    // 부서 모두 조회
    public DepartmentListResponseDto departmentFindAll() {
        List<Department> departments =departmentRepository.findAll();
        List<DepartmentInfoResponseDto> departmentInfoResponseDtoList = departments.stream()
                .map(DepartmentInfoResponseDto::from)
                .toList();
        return DepartmentListResponseDto.from(departmentInfoResponseDtoList);
    }
    
    // 단일 부서 조회
    public DepartmentInfoResponseDto departmentFindOne(Long departmentId) {
        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(IllegalAccessError::new);
        return DepartmentInfoResponseDto.from(department);
    }
}
