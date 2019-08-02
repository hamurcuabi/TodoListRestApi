package com.todoapp.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoList;

@Repository
public class ToDoListDaoImpl implements ToDoListDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(ToDoList item) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.byId(Member.class).load(item.getMember().getId());
		item.setMember(member);
		session.save(item);
		return item.getId();
	}
	

	@Override
	public ToDoList get(long id) {
		ToDoList item = sessionFactory.getCurrentSession().get(ToDoList.class, id);
		return item;
	}

	@Override
	public List<ToDoList> list() {
		List<ToDoList> list = sessionFactory.getCurrentSession().createQuery("from ToDoList").list();
		return list;
	}

	@Override
	public void update(long id, ToDoList item) {

		Session session = sessionFactory.getCurrentSession();
		ToDoList olditem = session.byId(ToDoList.class).load(id);
		olditem.setName(item.getName());
		session.flush();

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		ToDoList item = session.byId(ToDoList.class).load(id);
		session.delete(item);
	}

	@Override
	public List<ToDoList> listByMemberId(long id) {
		List<ToDoList> list = sessionFactory.getCurrentSession().
				createQuery("from ToDoList where memberId="+id)
				.list();
		return list;
	}

}
