package com.todoapp.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.Statu;
import com.todoapp.spring.model.ToDoList;

@Repository
public class StatuDaoImpl implements StatuDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Statu item) {
		sessionFactory.getCurrentSession().save(item);
		return item.getId();
	}

	@Override
	public Statu get(long id) {
		Statu item = sessionFactory.getCurrentSession().get(Statu.class, id);
		return item;
	}

	@Override
	public List<Statu> list() {
		List<Statu> list = sessionFactory.getCurrentSession().createQuery("from Statu").list();
		return list;
	}

	@Override
	public void update(long id, Statu item) {

		Session session = sessionFactory.getCurrentSession();
		Statu olditem = session.byId(Statu.class).load(id);
		olditem.setName(item.getName());
		session.flush();

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Statu item = session.byId(Statu.class).load(id);
		session.delete(item);
	}


}
