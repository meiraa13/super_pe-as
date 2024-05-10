package br.com.masterclass.superpecas.dto.car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDTO {

    private Integer id;
    private String modelName;
    private String manufacturer;
    private String uniqueCode;
}
