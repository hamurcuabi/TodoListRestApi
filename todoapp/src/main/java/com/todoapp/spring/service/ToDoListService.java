package com.todoapp.spring.service;


import java.util.List;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoList;

public interface ToDoListService {
    
     
    //Save the item
    long save(ToDoList item);
    
    //Get a single item
    ToDoList get(long id);
    
    //Get all the item
    List<ToDoList> list();
    
    List<ToDoList> listByMemberId(long id);
    
    //Update the item
    void update(long id, ToDoList item);
    
    //Delete a member
    void delete(long id);
    
}
