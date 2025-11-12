package com.example.vss.trab.dtos.mappers;

import com.example.vss.trab.dtos.UpdateTarefaDto;
import com.example.vss.trab.models.Tarefa;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TarefaMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UpdateTarefaDto dto, @MappingTarget Tarefa entity);

}