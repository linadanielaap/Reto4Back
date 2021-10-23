package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Reservation;
import com.co.Reto3.repositorio.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository bookRepository;

    public List<Reservation> getAllBooks(){
        return (List<Reservation>) bookRepository.findAll();

    }

    public Optional<Reservation> getReservation(int id){
        return bookRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reserva){
        return bookRepository.save(reserva);
    }

    public void delete(Reservation reservation){bookRepository.delete(reservation);}
}
