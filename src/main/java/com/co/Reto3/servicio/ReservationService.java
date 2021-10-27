package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Reservation;
import com.co.Reto3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author linad
 */
@Service
public class ReservationService {
    /**
     *
     * Variable del repositorio de Reservación
     */
    @Autowired
    private ReservationRepository bookRepository;

    /**
     *
     * Método para traer todas las reservaciones
     */
    public List<Reservation> getAllBooks (){
        return bookRepository.getAllBooks();
    }
    /**
     *
     * Método para traer una reservación por id
     */
    public Optional<Reservation> getReservation(int id){
        return bookRepository.getReservation(id);
    }
    /**
     *
     * Método para guardar una reservación
     */
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
    /**
     *
     * Método para actualizar una reservación
     */
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

    /**
     *
     * Método para eliminar una reservación por id
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            bookRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
