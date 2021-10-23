package com.co.Reto3.servicio;

import com.co.Reto3.modelo.Admin;
import com.co.Reto3.modelo.Client;
import com.co.Reto3.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return adminRepository.getAdmins();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin saveAdmin(Admin admin){
        if(admin.getIdAdmin()== null){
            return adminRepository.saveAdmin(admin);
        }else {
            Optional<Admin> e= adminRepository.getAdmin(admin.getIdAdmin());
            if (e.isEmpty()){
                return adminRepository.saveAdmin(admin);
            }else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> e= adminRepository.getAdmin(admin.getIdAdmin());
            if(!e.isEmpty()){
                if(admin.getNameAdmin()!=null){
                    e.get().setNameAdmin(admin.getNameAdmin());
                }
                if(admin.getPasswordAdmin()!=null){
                    e.get().setPasswordAdmin(admin.getPasswordAdmin());
                }
                if(admin.getEmailAdmin()!=null){
                    e.get().setEmailAdmin(admin.getEmailAdmin());
                }
                adminRepository.saveAdmin(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean deleteAdmin(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
