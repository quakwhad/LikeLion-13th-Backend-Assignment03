package com.likelion.likelionassignmentcrud.emplyee.api.dto.request;

public record EmployeeSaveRequestDto(
        Long departmentId,
        String name,
        int age,
        String responsibilities
) {
}
