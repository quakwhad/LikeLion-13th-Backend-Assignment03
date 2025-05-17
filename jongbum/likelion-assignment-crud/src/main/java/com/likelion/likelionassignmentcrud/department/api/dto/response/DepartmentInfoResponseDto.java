package com.likelion.likelionassignmentcrud.department.api.dto.response;

import com.likelion.likelionassignmentcrud.department.domain.Department;
import com.likelion.likelionassignmentcrud.department.domain.Part;
import lombok.Builder;

@Builder
public record DepartmentInfoResponseDto(
        Part part
) {
    public static DepartmentInfoResponseDto from(Department department) {
        return DepartmentInfoResponseDto.builder()
                .part(department.getPart())
                .build();
    }
}
