package com.todoapp.spring.dao;

import java.util.List;
import com.todoapp.spring.model.Member;

public interface MemberDao {

	// Save the book
	long save(Member member);

	// Get a single member
	Member get(long id);

	// Get all the member
	List<Member> list();

	// Update the member
	void update(long id, Member member);

	// Delete a member
	void delete(long id);
	
	//Register
	Member register(Member member);
	
	//Login
	
	Member login(Member member);

}
