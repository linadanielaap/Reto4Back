package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Score;
import com.co.Reto3.repositorio.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public Score saveScore(Score nota){
        return scoreRepository.saveScore(nota);
    }
}
