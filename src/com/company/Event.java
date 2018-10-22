package com.company;

import java.time.LocalTime;

public abstract class Event  {
    protected LocalTime startTime,endTime;
    protected String addnotation;

    public String getAddnotation() {
        return addnotation;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setAddnotation(String addnotation) {
        this.addnotation = addnotation;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public abstract String showEvent();
   }

