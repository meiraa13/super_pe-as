package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.piece.PieceRequestDTO;
import br.com.masterclass.superpecas.model.Car;
import br.com.masterclass.superpecas.model.Piece;
import br.com.masterclass.superpecas.repository.CarRepository;
import br.com.masterclass.superpecas.repository.PieceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PieceService {
    private final PieceRepository pieceRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public Piece createPiece(PieceRequestDTO body){
        Car car = this.carRepository
                .findById(body.carId())
                .orElseThrow(()-> new EntityNotFoundException("car not found"));

        Piece piece = new Piece();
        piece.setPieceName(body.pieceName());
        piece.setDescription(body.description());
        piece.setPieceManufacturer(body.pieceManufacturer());
        piece.setSerialNumber(body.serialNumber());
        piece.setCar(car);
        piece.setCarModel(body.carModel());

        this.pieceRepository.save(piece);
        return piece;
    }

}
