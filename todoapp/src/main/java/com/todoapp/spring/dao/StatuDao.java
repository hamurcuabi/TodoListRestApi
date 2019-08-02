package com.todoapp.spring.dao;

import java.util.List;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.Statu;
import com.todoapp.spring.model.ToDoList;

public interface StatuDao {

	// Save the item
	long save(Statu item);

	// Get a single item
	Statu get(long id);

	// Get all the item
	List<Statu> list();

	// Update the item
	void update(long id, Statu item);

	// Delete a item
	void delete(long id);
	
	

}
