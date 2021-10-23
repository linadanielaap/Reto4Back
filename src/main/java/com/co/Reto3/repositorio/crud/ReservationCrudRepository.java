package com.co.Reto3.repositorio.crud;

import com.co.Reto3.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
