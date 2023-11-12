package br.com.alunoonline.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatchNotasRequest {

    private Double nota1;
    private Double nota2;

}

