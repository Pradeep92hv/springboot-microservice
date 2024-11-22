package net.javaguides.department_service.service.serviceImpl;


import lombok.AllArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.mapper.DepartmentMapper;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

//    @Override
//    public DepartmentDto getDepartmentByCode(String departmentCode) {
//
//        Department department = departmentRepository.findByDepartmentCode(departmentCode);
//
//        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
//
//        return departmentDto;
//    }
}

