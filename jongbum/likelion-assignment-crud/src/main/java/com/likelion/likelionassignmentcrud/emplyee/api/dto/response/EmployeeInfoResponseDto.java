package com.likelion.likelionassignmentcrud.emplyee.api.dto.response;

import com.likelion.likelionassignmentcrud.emplyee.domain.Employee;
import lombok.Builder;

@Builder
public record EmployeeInfoResponseDto(
        String name,
        int age,
        String responsibilities
) {
    public static EmployeeInfoResponseDto from(Employee employee) {
        return EmployeeInfoResponseDto.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .responsibilities(employee.getResponsibilities())
                .build();
    }
}
