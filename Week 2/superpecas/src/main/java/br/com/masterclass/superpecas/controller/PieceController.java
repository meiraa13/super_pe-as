package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.piece.PieceRequestDTO;
import br.com.masterclass.superpecas.dto.piece.PieceResponseDTO;
import br.com.masterclass.superpecas.dto.piece.PieceUpdateDTO;
import br.com.masterclass.superpecas.model.Piece;
import br.com.masterclass.superpecas.service.PieceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peca")
@RequiredArgsConstructor
public class PieceController {
    private final PieceService pieceService;

    @Tag(name = "CREATE A PIECE")
    @PostMapping
    public ResponseEntity<Piece> createPiece(@RequestBody @Valid PieceRequestDTO body){
        Piece newPiece = this.pieceService.createPiece(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPiece);

    }

    @Tag(name = "GET PIECE", description = "GET methods for Pieces")
    @GetMapping("listaTodosPaginado")
    public ResponseEntity<Page<PieceResponseDTO>> getAllPieces(Pageable pagination){
        Page<PieceResponseDTO> pieces = this.pieceService.getAllPieces(pagination);
        return ResponseEntity.status(HttpStatus.OK).body(pieces);
    }

    @Tag(name = "GET PIECE", description = "GET methods for Pieces")
    @GetMapping("{id}")
    public ResponseEntity<PieceResponseDTO> getPieceById(@PathVariable Integer id){
        PieceResponseDTO piece = this.pieceService.getPieceById(id);
        return ResponseEntity.ok().body(piece);
    }

    @Tag(name = "DELETE PIECE")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePiece(@PathVariable Integer id){
        this.pieceService.deletePiece(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "UPDATE PIECE")
    @Operation(summary = "update a piece", description = "updates all piece fields")
    @PutMapping
    public ResponseEntity<PieceResponseDTO> updatePiece(@RequestBody PieceUpdateDTO body){
        PieceResponseDTO updatedPiece = this.pieceService.updatePiece(body);
        return ResponseEntity.ok().body(updatedPiece);
    }
}
