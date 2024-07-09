package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.user.UserRequestDTO;
import br.com.masterclass.superpecas.dto.user.UserResponseDTO;
import br.com.masterclass.superpecas.model.User;
import br.com.masterclass.superpecas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponseDTO createUser(UserRequestDTO body) {
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        newUser.setPassword(body.password());
        newUser.setAdmin(body.isAdmin());
        this.userRepository.save(newUser);
        return modelMapper.map(newUser, UserResponseDTO.class);
    }
}
