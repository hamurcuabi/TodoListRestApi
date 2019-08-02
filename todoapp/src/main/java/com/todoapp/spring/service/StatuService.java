package com.todoapp.spring.service;


import java.util.List;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.Statu;
import com.todoapp.spring.model.ToDoList;

public interface StatuService {
    
     
    //Save the item
    long save(Statu item);
    
    //Get a single item
    Statu get(long id);
    
    //Get all the item
    List<Statu> list();
    
    
    //Update the item
    void update(long id, Statu item);
    
    //Delete a member
    void delete(long id);
    
}
