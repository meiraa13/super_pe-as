package br.com.masterclass.superpecas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(nullable = false)
    private String pieceName;

    @NotNull
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private String serialNumber;

    @NotNull
    @Column(nullable = false)
    private String pieceManufacturer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private Car car;

    @NotNull
    @Column(nullable = false)
    private String carModel;
}
