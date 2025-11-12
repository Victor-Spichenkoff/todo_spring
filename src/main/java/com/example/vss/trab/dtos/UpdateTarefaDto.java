package com.example.vss.trab.dtos;


import java.util.Date;

public record UpdateTarefaDto(String nomeTarefa,
                              String responsavel,
                              Date dataEntrega) {
}
