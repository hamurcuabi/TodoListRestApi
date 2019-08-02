package com.todoapp.spring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "ToDoItem")
public class ToDoItem {
	
	
	public ToDoList getTodoList() {
		return todoList;
	}

	public void setTodoList(ToDoList todoList) {
		this.todoList = todoList;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Date deadLine;
	
	@OneToOne()
	@JoinColumn(name = "todoItemId")
	private ToDoItem dependedItem; 

	public ToDoItem getDependedItem() {
		return dependedItem;
	}

	public void setDependedItem(ToDoItem dependedItem) {
		this.dependedItem = dependedItem;
	}

	public Statu getStatu() {
		return statu;
	}

	public void setStatu(Statu statu) {
		this.statu = statu;
	}

	@ManyToOne()
	@JoinColumn(name = "todolistId", nullable = false)
	private ToDoList todoList;

	@ManyToOne()
	@JoinColumn(name = "statuId", nullable = false)
	private Statu statu;
	

	public ToDoItem() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
