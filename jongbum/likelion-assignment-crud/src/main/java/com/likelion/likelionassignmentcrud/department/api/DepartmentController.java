package com.likelion.likelionassignmentcrud.department.api;

import com.likelion.likelionassignmentcrud.department.api.dto.request.DepartmentSaveRequestDto;
import com.likelion.likelionassignmentcrud.department.api.dto.response.DepartmentInfoResponseDto;
import com.likelion.likelionassignmentcrud.department.api.dto.response.DepartmentListResponseDto;
import com.likelion.likelionassignmentcrud.department.application.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    // 부서 저장
    @PostMapping("/save")
    public ResponseEntity<String> departmentSave(@RequestBody DepartmentSaveRequestDto departmentSaveRequestDto) {
        departmentService.departmentSave(departmentSaveRequestDto);
        return new ResponseEntity<>("부서 저장!", HttpStatus.CREATED);
    }
    
    // 부서 전체 조회
    @GetMapping("/all")
    public ResponseEntity<DepartmentListResponseDto> departFindAll() {
        DepartmentListResponseDto departmentListResponseDto = departmentService.departmentFindAll();

        return new ResponseEntity<>(departmentListResponseDto, HttpStatus.OK);
    }

    // 부서 id를 통해 특정 부서 조회
    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentInfoResponseDto> departmentFindOne(@PathVariable("departmentId") Long departmentId) {
        DepartmentInfoResponseDto departmentInfoResponseDto = departmentService.departmentFindOne(departmentId);
        return new ResponseEntity<>(departmentInfoResponseDto, HttpStatus.OK);
    }
}
