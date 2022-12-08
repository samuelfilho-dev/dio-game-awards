package me.dio.diogameawards.service.impl;

import me.dio.diogameawards.domain.Game;
import me.dio.diogameawards.domain.GameRepositoty;
import me.dio.diogameawards.service.GameService;
import me.dio.diogameawards.service.exepetion.BusinessException;
import me.dio.diogameawards.service.exepetion.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepositoty repositoty;

    @Override
    public List<Game> findAll() {
        List<Game> games = repositoty.findAll(Sort.by(Sort.Direction.DESC,"votes"));
        return games;
    }

    @Override
    public Game findById(Long id) {
        Optional<Game> game = repositoty.findById(id);
        return game.orElseThrow(() -> new NoContentException());
    }

    @Override
    public void insert(Game game) {
        if (Objects.nonNull(game.getId())) throw new BusinessException("O ID é Diferente de Null");
        repositoty.save(game);
    }

    @Override
    public void update(Long id, Game game) {
        Game gameDb = findById(id);
        if (gameDb.getId().equals(game.getId())){
            repositoty.save(game);
        }else{
            throw new BusinessException("Os IDs Para Alteração são Divergentes");
        }
    }

    @Override
    public void delete(Long id) {
        Game gameDb = findById(id);
        repositoty.delete(gameDb);
    }

    @Override
    public void vote(Long id) {
        Game gameDb = findById(id);
        gameDb.setVotes(gameDb.getVotes() + 1);
        update(id,gameDb);
    }
}
