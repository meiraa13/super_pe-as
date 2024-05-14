package br.com.masterclass.superpecas.dto.car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequestDTO {

    private String modelName;
    private String manufacturer;
    private String uniqueCode;
}
