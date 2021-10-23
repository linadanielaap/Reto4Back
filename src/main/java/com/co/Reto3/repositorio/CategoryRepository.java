package com.co.Reto3.repositorio;

import com.co.Reto3.modelo.Category;
import com.co.Reto3.repositorio.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository crud;

    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }

    public Optional<Category> getCategoria(int id){
        return crud.findById(id);
    }

    public Category save(Category Categoria){
        return crud.save(Categoria);
    }

    public void delete (Category category){crud.delete(category);}
}
