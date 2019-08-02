package com.todoapp.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoItem;
import com.todoapp.spring.model.ToDoList;
import com.todoapp.spring.service.MemberService;
import com.todoapp.spring.service.ToDoItemService;
import com.todoapp.spring.service.ToDoListService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ToDoItemController {

	@Autowired
	private ToDoItemService itemService;

	/*---Add new item---*/
	@PostMapping("/todoitem")
	public ResponseEntity<?> save(@RequestBody ToDoItem item) {
		long id = itemService.save(item);
		return ResponseEntity.ok().body("New ToDoItem has been saved with ID:" + id);
	}

	/*---Get a item by id---*/
	@GetMapping("/todoitem/{id}")
	public ResponseEntity<ToDoItem> get(@PathVariable("id") long id) {
		ToDoItem item = itemService.get(id);
		return ResponseEntity.ok().body(item);
	}

	/*---Get a item by id---*/
	@GetMapping("/todoitem/getByToDoList/{todolistId}")
	public ResponseEntity<List<ToDoItem>> getByToListId(@PathVariable("todolistId") long todolistId) {
		List<ToDoItem> items = itemService.listByToDoListId(todolistId);
		return ResponseEntity.ok().body(items);
	}

	/*---Get a item by id---*/
	@GetMapping("/todoitem/getByStatu/{statuId}")
	public ResponseEntity<List<ToDoItem>> getByStatusId(@PathVariable("statuId") long statuId) {
		List<ToDoItem> items = itemService.listByStatuId(statuId);
		return ResponseEntity.ok().body(items);
	}

	/*---get all items---*/
	@GetMapping("/todoitem")
	public ResponseEntity<List<ToDoItem>> list() {
		List<ToDoItem> items = itemService.list();
		return ResponseEntity.ok().body(items);
	}

	/*---Update a item by id---*/
	@PutMapping("/todoitem/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ToDoItem item) {
		itemService.update(id, item);
		return ResponseEntity.ok().body("ToDoItem has been updated successfully.");
	}

	/*---Delete a item by id---*/
	@DeleteMapping("/toditem/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		itemService.delete(id);
		return ResponseEntity.ok().body("ToDoItem has been deleted successfully.");
	}

	/*---Get a item by id---*/
	@GetMapping("/todoitem/canDone/{id}")
	public ResponseEntity<Boolean> getcanDone(@PathVariable("id") long id) {

		ToDoItem item = itemService.get(id);
		return ResponseEntity.ok().body(canDone(item));
	}

	public boolean canDone(ToDoItem item) {

		if (item.getDependedItem() != null) {

			if (item.getDependedItem().getStatu().getId() != 1) {
				return false;
			}

			else {
				return canDone(item.getDependedItem());
			}

		}

		else
			return true;
	}

}