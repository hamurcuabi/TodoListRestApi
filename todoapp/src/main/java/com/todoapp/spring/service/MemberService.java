package com.todoapp.spring.service;


import java.util.List;
import com.todoapp.spring.model.Member;

public interface MemberService {
    
     
    //Save the member
    long save(Member member);
    
    //Get a single member
    Member get(long id);
    
    //Get all the member
    List<Member> list();
    
    //Update the member
    void update(long id, Member member);
    
    //Delete a member
    void delete(long id);
    
    Member register(Member member);
    
    Member login(Member member);
    
    
}
