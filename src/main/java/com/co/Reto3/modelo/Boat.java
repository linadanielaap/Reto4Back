package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.Integer;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author linad
 */
@Entity
@Table (name="boat")
public class Boat implements Serializable {
    /**
     *
     * Variable id del barco
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *
     * Variable nombre del barco
     */
    private String name;
    /**
     *
     * Variable maarca del barco
     */
    private String brand;
    /**
     *
     * Variable modelo del barco
     */
    private Integer year;
    /**
     *
     * Variable descripcion del barco
     */
    private String description;
    /**
     *
     * Variable categoria del barco
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("boats")
    private Category category;
    /**
     *
     * Variable mensajes del barco
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<Message> messages;
    /**
     *
     * Variable reservaciones del barco
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<Reservation> reservations;
    /**
     *
     * Metodo get del id
     */
    public Integer getId() {
        return id;
    }
    /**
     *
     * Metodo set del id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     *
     * Metodo get del nombre
     */
    public String getName() {
        return name;
    }
    /**
     *
     * Metodo set del nombre
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * Metodo get de la marca
     */
    public String getBrand() {
        return brand;
    }
    /**
     *
     * Metodo set de la marca
     * */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     *
     * Metodo get del modelo
     */
    public Integer getYear() {
        return year;
    }
    /**
     *
     * Metodo set del modelo
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     *
     * Metodo get de la descripcion
     */
    public String getDescription() {
        return description;
    }
    /**
     *
     * Metodo set de la descripcion
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     * Metodo get de la categoria
     */
    public Category getCategory() {
        return category;
    }
    /**
     *
     * Metodo set de la categoria
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     *
     * Metodo get del mensaje
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     *
     * Metodo set del mensaje
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     *
     * Metodo get de las reservaciones
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     *
     * Metodo set de las reservaciones
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
