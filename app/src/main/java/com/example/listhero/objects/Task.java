package com.example.listhero.objects;

import java.sql.Timestamp;

public class Task {

    private int idTask, orderTask;
    private String nameTask, descriptionTask;
    private Timestamp dateTask;
    private boolean donneTask;

    public Task() {  }

    public Task(int idTask, int orderTask, String nameTask, String descriptionTask, Timestamp dateTask,
        boolean donneTask) {

        this.idTask = idTask;
        this.orderTask = orderTask;
        this.nameTask = nameTask;
        this.descriptionTask = descriptionTask;
        this.dateTask = dateTask;
        this.donneTask = donneTask;
    }

    public Task(Task task) {

        this.idTask = task.getIdTask();
        this.orderTask = task.getOrderTask();
        this.nameTask = task.getNameTask();
        this.descriptionTask = task.getDescriptionTask();
        this.dateTask = task.getDateTask();
        this.donneTask = task.isDonneTask();
    }

    public int getIdTask() {  return idTask;  }

    public void setIdTask(int idTask) {  this.idTask = idTask;  }

    public int getOrderTask() {  return orderTask;  }

    public void setOrderTask(int orderTask) {  this.orderTask = orderTask;  }

    public String getNameTask() {  return nameTask;  }

    public void setNameTask(String nameTask) {  this.nameTask = nameTask;  }

    public String getDescriptionTask() {  return descriptionTask;  }

    public void setDescriptionTask(String descriptionTask) {  this.descriptionTask = descriptionTask;  }

    public Timestamp getDateTask() {  return dateTask;  }

    public void setDateTask(Timestamp dateTask) {  this.dateTask = dateTask;  }

    public boolean isDonneTask() {  return donneTask;  }

    public void setDonneTask(boolean donneTask) {  this.donneTask = donneTask;  }

}