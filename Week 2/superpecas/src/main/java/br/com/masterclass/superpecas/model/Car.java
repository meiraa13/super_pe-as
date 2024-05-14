package br.com.masterclass.superpecas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String modelName;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false, unique = true)
    private String uniqueCode;

    @OneToMany(mappedBy = "car")
    @JsonIgnoreProperties("car")
    private List<Piece> pieces;


}
