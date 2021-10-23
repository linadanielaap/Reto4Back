package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Message;
import com.co.Reto3.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository msjRepository;

    public List<Message> getAllMsj(){
        return msjRepository.getAllMsj();
    }

    public Optional<Message> getMessage(int id){
        return msjRepository.getMessage(id);
    }

    public Message saveMsj(Message mensaje){
        if(mensaje.getIdMessage()== null){
            return msjRepository.saveMessage(mensaje);
        }else {
            Optional<Message> e= msjRepository.getMessage(mensaje.getIdMessage());
            if (e.isEmpty()){
                return msjRepository.saveMessage(mensaje);
            }else {
                return mensaje;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= msjRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                msjRepository.saveMessage(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            msjRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
