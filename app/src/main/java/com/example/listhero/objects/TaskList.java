package com.example.listhero.objects;

import java.util.ArrayList;

public class TaskList extends List{

    private ArrayList<Task> lists;

    public TaskList() {  super();  }

    public TaskList(ArrayList lists) {  this.lists = lists;  }

    public TaskList(TaskList taskList) {

        this.setIdList(taskList.getIdList());
        this.setOrderList(taskList.getOrderList());
        this.setNameList(taskList.getNameList());
        this.setDescriptionList(taskList.getDescriptionList());
        this.lists = taskList.getLists();
    }

    public ArrayList<Task> getLists() {  return lists;  }

    public void setLists(ArrayList<Task> lists) {  this.lists = lists;  }

    public void addTask(Task task) {  lists.add(task);  }

}