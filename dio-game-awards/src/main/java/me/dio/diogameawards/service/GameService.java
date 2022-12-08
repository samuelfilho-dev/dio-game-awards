package me.dio.diogameawards.service;

import me.dio.diogameawards.domain.Game;
import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game findById(Long id);

    void insert(Game game);

    void update(Long id,Game game);

    void delete(Long id);

    void vote(Long id);
}
