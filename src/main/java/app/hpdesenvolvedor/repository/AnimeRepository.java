package app.hpdesenvolvedor.repository;

import app.hpdesenvolvedor.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
