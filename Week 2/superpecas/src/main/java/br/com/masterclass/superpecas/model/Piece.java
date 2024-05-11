package br.com.masterclass.superpecas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pieces")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Piece {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String pieceName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String pieceManufacturer;

    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private Car car;

    @Column(nullable = false)
    private String carModel;
}
