package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
