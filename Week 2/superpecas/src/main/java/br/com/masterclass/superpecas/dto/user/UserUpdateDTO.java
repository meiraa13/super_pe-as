package br.com.masterclass.superpecas.dto.user;


public record UserUpdateDTO(
        String name,
        String email,
        String password,
        boolean isAdmin
) { }
