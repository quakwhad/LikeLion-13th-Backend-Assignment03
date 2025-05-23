package com.likelion.likelionassignmentcrud.emplyee.api.application;

import com.likelion.likelionassignmentcrud.department.api.dto.request.DepartmentSaveRequestDto;
import com.likelion.likelionassignmentcrud.department.domain.Department;
import com.likelion.likelionassignmentcrud.department.domain.repository.DepartmentRepository;
import com.likelion.likelionassignmentcrud.emplyee.api.dto.request.EmployeeSaveRequestDto;
import com.likelion.likelionassignmentcrud.emplyee.api.dto.response.EmployeeInfoResponseDto;
import com.likelion.likelionassignmentcrud.emplyee.api.dto.response.EmployeeListResponseDto;
import com.likelion.likelionassignmentcrud.emplyee.domain.Employee;
import com.likelion.likelionassignmentcrud.emplyee.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    // 직원 저장
    @Transactional
    public void employeeSave(EmployeeSaveRequestDto employeeSaveRequestDto) {
        Department department = departmentRepository.findById(employeeSaveRequestDto.departmentId()).orElseThrow(IllegalAccessError::new);

        Employee employee = Employee.builder()
                .name(employeeSaveRequestDto.name())
                .age(employeeSaveRequestDto.age())
                .responsibilities(employeeSaveRequestDto.responsibilities())
                .department(department)
                .build();

        employeeRepository.save(employee);
    }

    // 특정 부서의 직원 목록 조회
    public EmployeeListResponseDto employeeFindDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(IllegalArgumentException::new);

        List<Employee> employees = employeeRepository.findByDepartment(department);
        List<EmployeeInfoResponseDto> employeeInfoResponseDtos = employees.stream()
                .map(EmployeeInfoResponseDto::from)
                .toList();

        return EmployeeListResponseDto.from(employeeInfoResponseDtos);
    }
}
