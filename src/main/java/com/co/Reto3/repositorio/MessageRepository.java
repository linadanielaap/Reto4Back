package com.co.Reto3.repositorio;


import com.co.Reto3.modelo.Message;
import com.co.Reto3.repositorio.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageRepository;

    public List<Message> getAllMsj(){
        return (List<Message>) messageRepository.findAll();

    }

    public Optional<Message> getMessage(int id){
        return messageRepository.findById(id);
    }

    public Message saveMessage(Message mensaje){
        return messageRepository.save(mensaje);
    }

    public void delete(Message message){messageRepository.delete(message);}
}
