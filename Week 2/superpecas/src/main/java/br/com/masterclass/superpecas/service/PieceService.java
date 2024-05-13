package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.dto.piece.PieceRequestDTO;
import br.com.masterclass.superpecas.dto.piece.PieceResponseDTO;
import br.com.masterclass.superpecas.dto.piece.PieceUpdateDTO;
import br.com.masterclass.superpecas.model.Car;
import br.com.masterclass.superpecas.model.Piece;
import br.com.masterclass.superpecas.repository.CarRepository;
import br.com.masterclass.superpecas.repository.PieceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Page<PieceResponseDTO> getAllPieces(Pageable pagination) {
        return this.pieceRepository.findAll(pagination).map(piece -> modelMapper.map(piece, PieceResponseDTO.class));
    }

    public PieceResponseDTO getPieceById(Integer id) {
       Optional<Piece> piece = this.pieceRepository.findById(id);
       if(piece.isEmpty()){
           throw new EntityNotFoundException();
       }
       return modelMapper.map(piece, PieceResponseDTO.class);
    }

    public void deletePiece(Integer id) {
        Optional<Piece> piece = this.pieceRepository.findById(id);
        if(piece.isEmpty()){
            throw new EntityNotFoundException("piece not found");
        }
        this.pieceRepository.deleteById(id);
    }

    public PieceResponseDTO updatePiece(PieceUpdateDTO body) {
        Piece piece = this.pieceRepository.findById(body.id()).orElseThrow(EntityNotFoundException::new);

        piece.setPieceName(body.pieceName());
        piece.setPieceManufacturer(body.pieceManufacturer());
        piece.setSerialNumber(body.serialNumber());
        piece.setCarModel(body.carModel());

        return modelMapper.map(piece, PieceResponseDTO.class);
    }
}
