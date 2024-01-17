package com.unionistashop.crud_app_1.mappers;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.entities.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface  EmployeeMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void  employeeFromDto(UpdateEmployeeDto dto, @MappingTarget Employee entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void employeeFromDto(CreateEmployeeDto dto, @MappingTarget Employee entity);
}
