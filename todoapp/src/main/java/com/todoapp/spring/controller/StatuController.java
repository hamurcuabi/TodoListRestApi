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
import com.todoapp.spring.model.Statu;
import com.todoapp.spring.model.ToDoList;
import com.todoapp.spring.service.MemberService;
import com.todoapp.spring.service.StatuService;
import com.todoapp.spring.service.ToDoListService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StatuController {

   @Autowired
   private StatuService itemService;

   /*---Add new item---*/
   @PostMapping("/statu")
   public ResponseEntity<?> save(@RequestBody Statu item) {
      long id = itemService.save(item);
      return ResponseEntity.ok().body("New Statu has been saved with ID:" + id);
   }

   /*---Get a item by id---*/
   @GetMapping("/statu/{id}")
   public ResponseEntity<Statu> get(@PathVariable("id") long id) {
	   Statu item = itemService.get(id);
      return ResponseEntity.ok().body(item);
   }
   


   /*---get all items---*/
   @GetMapping("/statu")
   public ResponseEntity<List<Statu>> list() {
      List<Statu> items = itemService.list();
      return ResponseEntity.ok().body(items);
   }

   /*---Update a item by id---*/
   @PutMapping("/statu/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Statu item) {
	   itemService.update(id, item);
      return ResponseEntity.ok().body("Statu has been updated successfully.");
   }

   /*---Delete a item by id---*/
   @DeleteMapping("/statu/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   itemService.delete(id);
      return ResponseEntity.ok().body("Statu has been deleted successfully.");
   }
}