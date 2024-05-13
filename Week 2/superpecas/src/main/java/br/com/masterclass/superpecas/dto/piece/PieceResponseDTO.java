package br.com.masterclass.superpecas.dto.piece;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PieceResponseDTO {

    private Integer id;
    private String pieceName;
    private String description;
    private String serialNumber;
    private String pieceManufacturer;
    private String carModel;
}
