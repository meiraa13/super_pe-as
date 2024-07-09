package br.com.masterclass.superpecas.dto.user;

import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotNull
        String name,

        @NotNull
        String email,

        @NotNull
        String password,

        boolean isAdmin

) { }
