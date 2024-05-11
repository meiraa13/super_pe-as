package br.com.masterclass.superpecas.dto.piece;

public record PieceRequestDTO(
        String pieceName,
        String description,
        String serialNumber,
        String pieceManufacturer,
        Integer carId,
        String carModel
) { }
