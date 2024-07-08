package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
