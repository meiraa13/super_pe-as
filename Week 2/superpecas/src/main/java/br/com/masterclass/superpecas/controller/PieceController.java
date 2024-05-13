package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.dto.piece.PieceRequestDTO;
import br.com.masterclass.superpecas.dto.piece.PieceResponseDTO;
import br.com.masterclass.superpecas.dto.piece.PieceUpdateDTO;
import br.com.masterclass.superpecas.model.Piece;
import br.com.masterclass.superpecas.service.PieceService;
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

    @PostMapping
    public ResponseEntity<Piece> createPiece(@RequestBody @Valid PieceRequestDTO body){
        Piece newPiece = this.pieceService.createPiece(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPiece);

    }

    @GetMapping("listaTodosPaginado")
    public ResponseEntity<Page<PieceResponseDTO>> getAllPieces(Pageable pagination){
        Page<PieceResponseDTO> pieces = this.pieceService.getAllPieces(pagination);
        return ResponseEntity.status(HttpStatus.OK).body(pieces);
    }

    @GetMapping("{id}")
    public ResponseEntity<PieceResponseDTO> getPieceById(@PathVariable Integer id){
        PieceResponseDTO piece = this.pieceService.getPieceById(id);
        return ResponseEntity.ok().body(piece);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePiece(@PathVariable Integer id){
        this.pieceService.deletePiece(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<PieceResponseDTO> updatePiece(@RequestBody PieceUpdateDTO body){
        PieceResponseDTO updatedPiece = this.pieceService.updatePiece(body);
        return ResponseEntity.ok().body(updatedPiece);
    }
}
