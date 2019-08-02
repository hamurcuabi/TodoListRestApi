package com.todoapp.spring.service;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todoapp.spring.dao.MemberDao;
import com.todoapp.spring.model.Member;

@Service
public class MemberServiceImpl implements MemberService{

	 @Autowired
	    private MemberDao memberDao;
	
	
	 @Override
	    @Transactional
	public long save(Member member) {
		 
		return memberDao.save(member);
	}

	 @Override
	    @Transactional
	public Member get(long id) {
		
		return memberDao.get(id);
	}

	 @Override
	    @Transactional
	public List<Member> list() {
		
		return memberDao.list();
	}

	 @Override
	    @Transactional
	public void update(long id, Member member) {
		memberDao.update(id, member);
		
	}

	 @Override
	    @Transactional
	public void delete(long id) {
		memberDao.delete(id);
		
	}

	@Override
	@Transactional
	public Member register(Member member) {
		// TODO Auto-generated method stub
		return memberDao.register(member);
	}

	@Override
	@Transactional
	public Member login(Member member) {
		Member newMember = memberDao.login(member);
		if(newMember!=null)
		return newMember;
		else return null;
	}

}
