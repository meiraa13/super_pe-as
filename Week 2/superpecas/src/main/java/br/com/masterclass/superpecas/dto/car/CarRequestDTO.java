package br.com.masterclass.superpecas.dto.car;

import jakarta.validation.constraints.NotNull;

public record CarRequestDTO(
        @NotNull
        String modelName,

        @NotNull
        String manufacturer,

        @NotNull
        String uniqueCode
) { }
