package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.car.CarIdDTO;
import br.com.masterclass.superpecas.dto.car.CarRequestDTO;
import br.com.masterclass.superpecas.dto.car.CarResponseDTO;
import br.com.masterclass.superpecas.model.Car;
import br.com.masterclass.superpecas.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<CarIdDTO> createCar(@RequestBody CarRequestDTO body){
        CarIdDTO carId = this.carService.createCar(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(carId);

    }
}
