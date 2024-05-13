package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.car.CarIdDTO;
import br.com.masterclass.superpecas.dto.car.CarRequestDTO;
import br.com.masterclass.superpecas.dto.car.CarResponseDTO;
import br.com.masterclass.superpecas.model.Car;
import br.com.masterclass.superpecas.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/listaTodos")
    public ResponseEntity<List<CarResponseDTO>> getCars(){
        List<CarResponseDTO> cars = this.carService.getCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @PostMapping
    public ResponseEntity<CarIdDTO> createCar(@RequestBody @Valid CarRequestDTO body){
        CarIdDTO carId = this.carService.createCar(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(carId);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable Integer id){
        Optional<Car> car = this.carService.findById(id);
        if(car.isEmpty()){
            throw new EntityNotFoundException("car not found");
        }

        return ResponseEntity.ok().body(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id){
        Optional<Car> car = this.carService.findById(id);
        if(car.isEmpty()){
            throw new EntityNotFoundException("car not found");
        }

        this.carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> updateCar(@PathVariable Integer id, @RequestBody CarRequestDTO body){

        CarResponseDTO updatedCar = this.carService.updateCar(body, id);
        return ResponseEntity.ok().body(updatedCar);
    }

    @GetMapping("/listaTodosFabricantes")
    public ResponseEntity<List<String>> getAllManufacturers(){
        List<String> manufacturers = this.carService.getAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
    }

    @GetMapping("/listaTodosPaginado")
    public ResponseEntity<Page<CarResponseDTO>> getPaginatedCars(@PageableDefault(size = 10) Pageable pagination){
        Page<CarResponseDTO> cars = this.carService.getPaginatedCar(pagination);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }
}
