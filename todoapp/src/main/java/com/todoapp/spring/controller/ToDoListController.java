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
import com.todoapp.spring.model.ToDoList;
import com.todoapp.spring.service.MemberService;
import com.todoapp.spring.service.ToDoListService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ToDoListController {

   @Autowired
   private ToDoListService itemService;

   /*---Add new item---*/
   @PostMapping("/todolist")
   public ResponseEntity<?> save(@RequestBody ToDoList item) {
      long id = itemService.save(item);
      return ResponseEntity.ok().body("New ToDoList has been saved with ID:" + id);
   }

   /*---Get a item by id---*/
   @GetMapping("/todolist/{id}")
   public ResponseEntity<ToDoList> get(@PathVariable("id") long id) {
	   ToDoList item = itemService.get(id);
      return ResponseEntity.ok().body(item);
   }
   
   /*---Get a item by id---*/
   @GetMapping("/todolist/getByMember/{memberId}")
   public ResponseEntity<List<ToDoList>> getByMemberId(@PathVariable("memberId") long memberId) {
	   List<ToDoList> items = itemService.listByMemberId(memberId);
	      return ResponseEntity.ok().body(items);
   }

   /*---get all items---*/
   @GetMapping("/todolist")
   public ResponseEntity<List<ToDoList>> list() {
      List<ToDoList> items = itemService.list();
      return ResponseEntity.ok().body(items);
   }

   /*---Update a item by id---*/
   @PutMapping("/todolist/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ToDoList item) {
	   itemService.update(id, item);
      return ResponseEntity.ok().body("ToDoList has been updated successfully.");
   }

   /*---Delete a item by id---*/
   @DeleteMapping("/todolist/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   itemService.delete(id);
      return ResponseEntity.ok().body("ToDoList has been deleted successfully.");
   }
}