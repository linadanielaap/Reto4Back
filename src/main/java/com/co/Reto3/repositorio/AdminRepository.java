package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Admin;
import com.co.Reto3.repositorio.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminRepository;

    public List<Admin> getAdmins (){
        return (List<Admin>) adminRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public void delete(Admin admin){adminRepository.delete(admin);}

}
