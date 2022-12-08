package me.dio.diogameawards.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepositoty  extends JpaRepository<Game, Long> {

}
