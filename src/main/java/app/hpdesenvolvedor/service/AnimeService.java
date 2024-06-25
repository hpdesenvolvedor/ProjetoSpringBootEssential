package app.hpdesenvolvedor.service;

import app.hpdesenvolvedor.domain.Anime;
import app.hpdesenvolvedor.repository.AnimeRepository;
import app.hpdesenvolvedor.request.AnimePostRequestBody;
import app.hpdesenvolvedor.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AnimeService {
    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {

        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));

    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime saveAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(saveAnime.getId())
                .name(animePutRequestBody.getName())
                .build();

        animeRepository.save(anime);

    }
}
