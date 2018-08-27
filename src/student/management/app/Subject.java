/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.management.app;

/**
 *
 * @author matt.maree
 */
class Subject {
    
    private int id;
    private String name;
    private int weight;
    private int duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Subject(int id, String name, int weight, int duration) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.duration = duration;
    }

    
    
    
    
}
