package me.dio.diogameawards.controller.games;

import me.dio.diogameawards.controller.BaseRestController;
import me.dio.diogameawards.domain.Game;
import me.dio.diogameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GameRestController extends BaseRestController {

    @Autowired
    private GameService buninessLayer;

    @GetMapping("games")
    public ResponseEntity<List<Game>> findAll(){
        List<Game> games = buninessLayer.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("games/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        Game game = buninessLayer.findById(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping("games")
    public ResponseEntity<Game> insert(@RequestBody Game game){
        buninessLayer.insert(game);
        return ResponseEntity.ok(game);
    }

    @PutMapping("games/{id}")
    public ResponseEntity<Game> update (@PathVariable Long id, @RequestBody Game game){
        buninessLayer.update(id,game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("games/{id}")
    public ResponseEntity<Game> delete (@PathVariable Long id){
        buninessLayer.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("games/{id}/vote")
    public ResponseEntity<Game> update(@PathVariable Long id){
        buninessLayer.vote(id);
        return ResponseEntity.ok().build();
    }

}
