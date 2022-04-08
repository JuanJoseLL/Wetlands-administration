package model;

import java.time.LocalDate;

public class Event {
    private String name;
    private double value;
    private String descriptionEvent;
    private LocalDate date;
    private TypeEvent description;
    public Event(String name, int description, double value,LocalDate date,String descriptionEvent) {
        this.name = name;
        this.value = value;
        this.setDate(date);
        this.descriptionEvent=descriptionEvent;
        switch(description){
            case 1: this.description=TypeEvent.MAINTENANCE;
            break;
            case 2: this.description=TypeEvent.SCHOOL_VISITS;
            break;
            case 3: this.description=TypeEvent.IMPROVEMENT_ACTIVITIES;
            break;
            case 4:this.description=TypeEvent.CELEBRATIONS;
            break;
        }
    }
    public String getDescriptionEvent() {
        return descriptionEvent;
    }
    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }
    public TypeEvent getDescription() {
        return description;
    }
    public void setDescription(TypeEvent description) {
        this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setName(String name) {
        this.name = name;
    }
}
