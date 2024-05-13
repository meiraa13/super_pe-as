package br.com.masterclass.superpecas.dto.piece;

import jakarta.validation.constraints.NotNull;

public record PieceUpdateDTO(
        @NotNull
        Integer id,

        @NotNull
        String pieceName,

        @NotNull
        String description,

        @NotNull
        String serialNumber,

        @NotNull
        String pieceManufacturer,

        @NotNull
        Integer carId,

        @NotNull
        String carModel
) {
}
