package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.car.CarIdDTO;
import br.com.masterclass.superpecas.dto.car.CarRequestDTO;
import br.com.masterclass.superpecas.dto.car.CarResponseDTO;
import br.com.masterclass.superpecas.model.Car;
import br.com.masterclass.superpecas.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    private CarResponseDTO convertToDto(Car car){
        return modelMapper.map(car, CarResponseDTO.class);
    }

    public List<CarResponseDTO> getCars(){
        return this.carRepository.findAll().stream().map(this::convertToDto).toList();

    }

    public Page<CarResponseDTO> getPaginatedCar(Pageable pagination){
        return this.carRepository.findAll(pagination).map(this::convertToDto);

    }

    public CarIdDTO createCar(CarRequestDTO body){
        Car newCar = new Car();
        newCar.setModelName(body.modelName());
        newCar.setManufacturer(body.manufacturer());
        newCar.setUniqueCode(body.uniqueCode());

        this.carRepository.save(newCar);

        return modelMapper.map(newCar, CarIdDTO.class);
    }

    public void deleteCar(Integer carId){
        this.carRepository.deleteById(carId);

    }

    public Optional<Car> findById(Integer id){
        return this.carRepository.findById(id);
    }

    public CarResponseDTO updateCar(CarRequestDTO body, Integer id){
        Car updatedCar = this.carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("car not found"));
        updatedCar.setModelName(body.modelName());
        updatedCar.setManufacturer(body.manufacturer());
        updatedCar.setUniqueCode(body.uniqueCode());

        this.carRepository.save(updatedCar);

        return modelMapper.map(updatedCar, CarResponseDTO.class);

    }

    public List<String> getAllManufacturers(){
        List<Car> cars = this.carRepository.findAll();

        List<String> carList = new ArrayList<>();

        for(Car car: cars){
            String manufacturer = car.getManufacturer();
            carList.add(manufacturer);
        }

        return carList;
    }
}
