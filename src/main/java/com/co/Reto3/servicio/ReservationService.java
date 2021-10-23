package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.modelo.Reservation;
import com.co.Reto3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository bookRepository;

    public List<Reservation> getAllBooks (){
        return bookRepository.getAllBooks();
    }

    public Optional<Reservation> getReservation(int id){
        return bookRepository.getReservation(id);
    }

    public Reservation saveReservation(Reservation reserva){
        if(reserva.getIdReservation()== null){
            return bookRepository.saveReservation(reserva);
        }else {
            Optional<Reservation> e= bookRepository.getReservation(reserva.getIdReservation());
            if (e.isEmpty()){
                return bookRepository.saveReservation(reserva);
            }else {
                return reserva;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= bookRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                bookRepository.saveReservation(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            bookRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
