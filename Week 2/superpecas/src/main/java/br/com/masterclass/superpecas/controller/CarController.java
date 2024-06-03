package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.car.CarUpdateDTO;
import br.com.masterclass.superpecas.dto.car.CarResponseDTO;
import br.com.masterclass.superpecas.dto.car.CarRequestDTO;
import br.com.masterclass.superpecas.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @Tag(name = "Cars")
    @Operation(summary = "get all cars")
    @GetMapping("/listaTodos")
    public ResponseEntity<List<CarResponseDTO>> getCars(){
        List<CarResponseDTO> cars = this.carService.getCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @Tag(name = "Cars")
    @Operation(summary = "create a car")
    @PostMapping
    public ResponseEntity<CarResponseDTO> createCar(@RequestBody CarRequestDTO body){
        CarResponseDTO car = this.carService.createCar(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(car);

    }

    @Tag(name = "Cars")
    @Operation(summary = "get car by id")
    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getCarById(@PathVariable Integer id){
        CarResponseDTO car = this.carService.findById(id);
        return ResponseEntity.ok().body(car);
    }

    @Tag(name = "Cars")
    @Operation(summary = "delete a car")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id){

        this.carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "Cars")
    @Operation(summary = "update a car", description = "updates all car fields")
    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> updateCar(@PathVariable Integer id, @RequestBody CarUpdateDTO body){

        CarResponseDTO updatedCar = this.carService.updateCar(body, id);
        return ResponseEntity.ok().body(updatedCar);
    }

    @Tag(name = "Cars")
    @Operation(summary = "get all manufacturers")
    @GetMapping("/listaTodosFabricantes")
    public ResponseEntity<List<String>> getAllManufacturers(){
        List<String> manufacturers = this.carService.getAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
    }

    @Tag(name = "Cars")
    @Operation(summary = "get paginated cars")
    @GetMapping("/listaTodosPaginado")
    public ResponseEntity<Page<CarResponseDTO>> getPaginatedCars(@PageableDefault(size = 10) Pageable pagination){
        Page<CarResponseDTO> cars = this.carService.getPaginatedCar(pagination);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @Tag(name = "Cars")
    @Operation(summary = "get top10 cars with more pieces")
    @GetMapping("/listaTop10CarroComMaisPecas")
    public ResponseEntity<List<CarResponseDTO>> getTop10CarsWithPieces(){
        List<CarResponseDTO> cars = carService.getTop10CarsWithPieces();
        return ResponseEntity.ok().body(cars);
    }

    @Tag(name = "Cars")
    @Operation(summary = "get top10 manufacturers")
    @GetMapping("/listaTop10Fabricantes")
    public ResponseEntity<List<CarResponseDTO>> getTopManufacturers(){
        List<CarResponseDTO> cars = carService.getTopManufacturers();
        return ResponseEntity.ok().body(cars);
    }
}
