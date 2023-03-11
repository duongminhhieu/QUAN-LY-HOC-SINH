/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school;

import java.awt.Image;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class Student implements Serializable{

    private String id;
    private String name;
    private double score;
    private String image;
    private String address;
    private String description;

    public Student() {
    }

    public Student(String id, String name, double score, String image, String address, String description) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.image = image;
        this.address = address;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
