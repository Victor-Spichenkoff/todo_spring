package com.example.vss.trab.dtos.mappers;

import com.example.vss.trab.dtos.CreateTarefaDto;
import com.example.vss.trab.models.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TarefaMapper {
    void updateUserFromDto(CreateTarefaDto dto, @MappingTarget Tarefa entity);

}