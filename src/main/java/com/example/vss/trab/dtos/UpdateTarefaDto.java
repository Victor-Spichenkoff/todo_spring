package com.example.vss.trab.dtos;

import java.util.Date;

public record CreateTarefaDto(String nomeTarefa,
                              String responsavel,
                              Date dataEntrega) {
}
