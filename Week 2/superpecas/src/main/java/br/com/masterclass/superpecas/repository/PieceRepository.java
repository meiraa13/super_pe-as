package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PieceRepository extends JpaRepository<Piece, Integer> {
}
