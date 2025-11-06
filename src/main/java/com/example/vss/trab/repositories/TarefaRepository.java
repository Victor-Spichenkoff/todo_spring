package com.example.vss.trab.repositories;

import com.example.vss.trab.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
