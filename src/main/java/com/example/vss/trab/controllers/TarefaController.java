package com.example.vss.trab.controllers;

import com.example.vss.trab.dtos.CreateTarefaDto;
import com.example.vss.trab.dtos.mappers.TarefaMapper;
import com.example.vss.trab.models.Tarefa;
import com.example.vss.trab.repositories.TarefaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private final TarefaRepository tarefaRepository;
    private final TarefaMapper mapper;

    public TarefaController(TarefaRepository tarefaRepository, TarefaMapper mapper) {
        this.tarefaRepository = tarefaRepository;
        this.mapper = mapper;
    }


    @GetMapping("")
    public ResponseEntity<List<Tarefa>> getAll() {
        var tarefas = tarefaRepository.findAll();
        return ResponseEntity.ok().body(tarefas);
    }


    @PostMapping("")
    public ResponseEntity<Tarefa> create(@RequestBody CreateTarefaDto tarefaDto)  {
        var tarefa = new Tarefa();
        tarefa.setNomeTarefa(tarefaDto.nomeTarefa());
        tarefa.setResponsavel(tarefaDto.responsavel());
        tarefa.setDataEntrega(tarefaDto.dataEntrega());
        var createdTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok().body(createdTarefa);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tarefa> update(
            @Param("id") int id,
            @RequestBody CreateTarefaDto updateTarefaDto) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        mapper.updateUserFromDto(updateTarefaDto, tarefa);

        var result = tarefaRepository.save(tarefa);

        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/{id}")
    public String delete(@Param("id") int id) {
        var tarefa = tarefaRepository.findById(id);
        if(tarefa.isEmpty())
            return "Não existe";

        tarefaRepository.delete(tarefa.get());

        return "ID " + id + "\nDeletado!";
    }
}
