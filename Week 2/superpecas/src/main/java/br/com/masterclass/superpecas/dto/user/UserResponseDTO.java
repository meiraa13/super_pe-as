package br.com.masterclass.superpecas.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private String id;
    private String name;
    private String email;
    private boolean isAdmin;

}
