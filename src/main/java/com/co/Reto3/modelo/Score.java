package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer value;
    @Column(length = 250)
    private String textScore;
    @OneToOne
    @JoinColumn(name = "idReserva")
    @JsonIgnoreProperties("reserva")
    private Reservation reserva;




    public Reservation getReserva() {
        return reserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setReserva(Reservation reserva) {
        this.reserva = reserva;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getTextScore() {
        return textScore;
    }

    public void setTextScore(String textScore) {
        this.textScore = textScore;
    }

}
