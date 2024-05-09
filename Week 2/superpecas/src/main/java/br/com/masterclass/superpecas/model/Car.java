package br.com.masterclass.superpecas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class Car {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(nullable = false)
    String modelName;

    @Column(nullable = false)
    String manufacturer;

    @Column(nullable = false, unique = true)
    String uniqueCode;

}
