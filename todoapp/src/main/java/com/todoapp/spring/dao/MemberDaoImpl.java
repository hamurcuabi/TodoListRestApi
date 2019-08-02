package com.todoapp.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.todoapp.spring.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Member member) {
		
		sessionFactory.getCurrentSession().save(member);
		return member.getId();
		
	}

	@Override
	public Member get(long id) {
		Member member = sessionFactory.getCurrentSession().get(Member.class, id);
		return member;
	}

	@Override
	public List<Member> list() {
		List<Member> list = sessionFactory.getCurrentSession().createQuery("from Member").list();
		return list;
	}

	@Override
	public void update(long id, Member member) {

		// "session.ById(Class).load(o)" and "session.find(Class,o)" do same thing.

		Session session = sessionFactory.getCurrentSession();
		Member oldMember = session.byId(Member.class).load(id);
		oldMember.setName(member.getName());
		oldMember.setEmail(member.getEmail());
		oldMember.setPassword(member.getPassword());
		session.flush();

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.byId(Member.class).load(id);
		session.delete(member);
	}

	@Override
	public Member register(Member member) {
		Member isNew = login(member);
		if (isNew == null) {
			sessionFactory.getCurrentSession().save(member);
			return member;
		}
		else return isNew;
	}

	@Override
	public Member login(Member member) {
		

		Session session = sessionFactory.getCurrentSession();
		String selectQuery = "FROM Member as m WHERE m.email = :email and m.password=:password";
		Query query =  session.createQuery(selectQuery);
		query.setParameter("email", member.getEmail());
		query.setParameter("password", member.getPassword());
		
		List<Member> results = query.list();

		if(results.isEmpty() || results.size()==0){
		    return member;
		} else {
		    return results.get(0);
		}
		
		
		
	}

}
