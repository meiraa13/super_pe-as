package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("SELECT c FROM Car c ORDER BY SIZE(c.pieces) DESC")
    List<Car> findByTop10ByOrderByPieceCountDesc();

    @Query("SELECT c.manufacturer, COUNT(c.manufacturer) AS manufacturerCount " +
            "FROM Car c " +
            "GROUP BY c.manufacturer " +
            "ORDER BY manufacturerCount DESC")
    List<Car> findByTop10Manufacturers();

    Optional<Car> findByUniqueCode(String uniqueCode);
}
