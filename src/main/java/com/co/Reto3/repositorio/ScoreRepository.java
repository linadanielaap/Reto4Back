package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Score;
import com.co.Reto3.repositorio.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreRepository;

    public Score saveScore(Score nota){
        return scoreRepository.save(nota);
    }

    public void delete(Score score){scoreRepository.delete(score);}
}
