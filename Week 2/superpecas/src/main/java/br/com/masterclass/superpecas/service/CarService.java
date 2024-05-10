package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.car.CarIdDTO;
import br.com.masterclass.superpecas.dto.car.CarRequestDTO;
import br.com.masterclass.superpecas.dto.car.CarResponseDTO;
import br.com.masterclass.superpecas.model.Car;
import br.com.masterclass.superpecas.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public List<CarResponseDTO> getCars(){
        List<Car> cars = this.carRepository.findAll();

        List<CarResponseDTO> carList = new ArrayList<>();

        for(Car car: cars){
            CarResponseDTO carEntityToDto = modelMapper.map(car, CarResponseDTO.class);
            carList.add(carEntityToDto);
        }

        return carList;
    }

    public CarIdDTO createCar(CarRequestDTO body){
        Car newCar = new Car();
        newCar.setModelName(body.modelName());
        newCar.setManufacturer(body.manufacturer());
        newCar.setUniqueCode(body.uniqueCode());

        this.carRepository.save(newCar);

        return modelMapper.map(newCar, CarIdDTO.class);
    }
}
