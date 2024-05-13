package br.com.masterclass.superpecas.dto.car;

import br.com.masterclass.superpecas.model.Piece;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarResponseDTO {

    private Integer id;
    private String modelName;
    private String manufacturer;
    private String uniqueCode;
    @JsonIgnoreProperties("car")
    private List<Piece> pieces;
}
