package br.com.masterclass.superpecas.dto.car;

import jakarta.validation.constraints.NotNull;

public record CarUpdateDTO(
        @NotNull
        String modelName,

        @NotNull
        String manufacturer,

        @NotNull
        String uniqueCode
) { }
