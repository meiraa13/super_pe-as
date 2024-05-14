package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.car.CarIdDTO;
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

    @Tag(name = "GET CAR", description = "GET methods for Cars")
    @GetMapping("/listaTodos")
    public ResponseEntity<List<CarResponseDTO>> getCars(){
        List<CarResponseDTO> cars = this.carService.getCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @Tag(name = "CREATE A CAR")
    @PostMapping
    public ResponseEntity<CarIdDTO> createCar(@RequestBody CarRequestDTO body){
        CarIdDTO carId = this.carService.createCar(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(carId);

    }

    @Tag(name = "GET CAR", description = "GET methods for Cars")
    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getCarById(@PathVariable Integer id){
        CarResponseDTO car = this.carService.findById(id);
        return ResponseEntity.ok().body(car);
    }

    @Tag(name = "DELETE A CAR")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer id){

        this.carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "UPDATE A CAR" )
    @Operation(summary = "updates a car", description = "updates all car fields")
    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> updateCar(@PathVariable Integer id, @RequestBody CarUpdateDTO body){

        CarResponseDTO updatedCar = this.carService.updateCar(body, id);
        return ResponseEntity.ok().body(updatedCar);
    }

    @Tag(name = "GET CAR", description = "GET methods for Cars")
    @GetMapping("/listaTodosFabricantes")
    public ResponseEntity<List<String>> getAllManufacturers(){
        List<String> manufacturers = this.carService.getAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(manufacturers);
    }

    @Tag(name = "GET CAR", description = "GET methods for Cars")
    @GetMapping("/listaTodosPaginado")
    public ResponseEntity<Page<CarResponseDTO>> getPaginatedCars(@PageableDefault(size = 10) Pageable pagination){
        Page<CarResponseDTO> cars = this.carService.getPaginatedCar(pagination);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @Tag(name = "GET CAR", description = "GET methods for Cars")
    @GetMapping("/listaTop10CarroComMaisPecas")
    public ResponseEntity<List<CarResponseDTO>> getTop10CarsWithPieces(){
        List<CarResponseDTO> cars = carService.getTop10CarsWithPieces();
        return ResponseEntity.ok().body(cars);
    }

    @Tag(name = "GET CAR", description = "GET methods for Cars")
    @GetMapping("/listaTop10Fabricantes")
    public ResponseEntity<List<CarResponseDTO>> getTopManufacturers(){
        List<CarResponseDTO> cars = carService.getTopManufacturers();
        return ResponseEntity.ok().body(cars);
    }
}
