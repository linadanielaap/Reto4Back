package com.co.Reto3.repositorio.crud;

import com.co.Reto3.modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
