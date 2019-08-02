package com.todoapp.spring.service;


import java.util.List;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoItem;
import com.todoapp.spring.model.ToDoList;

public interface ToDoItemService {
    
     
    //Save the item
    long save(ToDoItem item);
    
    //Get a single item
    ToDoItem get(long id);
    
    //Get all the item
    List<ToDoItem> list();
    
    List<ToDoItem> listByToDoListId(long id);
    
    List<ToDoItem> listByStatuId(long id);
    
    
    //Update the item
    void update(long id, ToDoItem item);
    
    //Delete a member
    void delete(long id);
    
}
