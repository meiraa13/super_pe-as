package br.com.masterclass.superpecas.controller;


import br.com.masterclass.superpecas.dto.piece.PieceRequestDTO;
import br.com.masterclass.superpecas.model.Piece;
import br.com.masterclass.superpecas.service.PieceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
