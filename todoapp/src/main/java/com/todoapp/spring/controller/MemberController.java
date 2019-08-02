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
import com.todoapp.spring.service.MemberService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;

	/*---Add new member---*/
	@PostMapping("/member")
	public ResponseEntity<?> save(@RequestBody Member member) {
		long id = memberService.save(member);
		return ResponseEntity.ok().body("New Member has been saved with ID:" + id);
	}

	/*---Add new member---*/
	@PostMapping("/member/register")
	public ResponseEntity<Member> register(@RequestBody Member member) {
		Member newMember = memberService.register(member);
		return ResponseEntity.ok().body(newMember);
	}

	@PostMapping("/member/login")
	public ResponseEntity<Member> login(@RequestBody Member member) {
		Member newMember = memberService.login(member);
		return ResponseEntity.ok().body(newMember);
	}

	/*---Get a member by id---*/
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> get(@PathVariable("id") long id) {
		Member member = memberService.get(id);
		return ResponseEntity.ok().body(member);
	}

	/*---get all books---*/
	@GetMapping("/member")
	public ResponseEntity<List<Member>> list() {
		List<Member> members = memberService.list();
		return ResponseEntity.ok().body(members);
	}

	/*---Update a member by id---*/
	@PutMapping("/member/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Member member) {
		memberService.update(id, member);
		return ResponseEntity.ok().body("Member has been updated successfully.");
	}

	/*---Delete a member by id---*/
	@DeleteMapping("/member/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		memberService.delete(id);
		return ResponseEntity.ok().body("Member has been deleted successfully.");
	}
	//selem selo
}