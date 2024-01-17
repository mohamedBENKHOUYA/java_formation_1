package com.unionistashop.crud_app_1.crud_app_2.mappers;

import com.unionistashop.crud_app_1.DTOs.CreateEmployeeDto;
import com.unionistashop.crud_app_1.DTOs.UpdateEmployeeDto;
import com.unionistashop.crud_app_1.crud_app_2.entity.Employee2;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface Employee2Mapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void Employee2FromDto(UpdateEmployeeDto data, @MappingTarget Employee2 entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void Employee2FromDto(CreateEmployeeDto data, @MappingTarget Employee2 entity);




}
