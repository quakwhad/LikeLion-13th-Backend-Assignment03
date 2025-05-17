package com.likelion.likelionassignmentcrud.emplyee.api.dto.request;

import com.likelion.likelionassignmentcrud.department.domain.Part;

public record EmployeeSaveRequestDto(
        Long departmentId,
        String name,
        int age,
        String responsibilities,
        Part part
) {
}
