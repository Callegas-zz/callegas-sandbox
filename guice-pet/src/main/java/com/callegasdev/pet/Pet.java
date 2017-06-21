package com.callegasdev.pet;

public class Pet {
    private String name;
    private String race;
    private Integer id;
    private Integer age;

    public Pet(String name, String race, Integer age) {
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public Pet(){
        this.name = "not registered";
    };

    @Override
    public String toString() {
        return  "pet"+id+": "+name+" "+race+" "+age+" years";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
