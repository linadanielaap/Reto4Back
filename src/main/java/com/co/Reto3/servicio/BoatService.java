package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Boat;
import com.co.Reto3.repositorio.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository metodosCrud;

    public List<Boat> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBoat(int boatId) {
        return metodosCrud.getBike(boatId);
    }

    public Boat save(Boat bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Optional<Boat> e=metodosCrud.getBike(bike.getId());
            if(e.isEmpty()){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }

    public Boat update(Boat boat){
        if(boat.getId()!=null){
            Optional<Boat> e=metodosCrud.getBike(boat.getId());
            if(!e.isEmpty()){
                if(boat.getName()!=null){
                    e.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    e.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    e.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    e.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    e.get().setCategory(boat.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }


    public boolean deleteBoat(int boatId) {
        Boolean aBoolean = getBoat(boatId).map(boat -> {
            metodosCrud.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
