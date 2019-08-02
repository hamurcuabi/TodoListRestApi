package com.todoapp.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoItem;
import com.todoapp.spring.model.ToDoList;

@Repository
public class ToDoItemDaoImpl implements ToDoItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(ToDoItem item) {
		sessionFactory.getCurrentSession().save(item);
		return item.getId();
	}

	@Override
	public ToDoItem get(long id) {
		ToDoItem item = sessionFactory.getCurrentSession().get(ToDoItem.class, id);
		return item;
	}

	@Override
	public List<ToDoItem> list() {
		List<ToDoItem> list = sessionFactory.getCurrentSession().createQuery("from ToDoItem").list();
		return list;
	}

	@Override
	public void update(long id, ToDoItem item) {

		Session session = sessionFactory.getCurrentSession();
		ToDoItem olditem = session.byId(ToDoItem.class).load(id);
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
	public List<ToDoItem> listByToDoListId(long id) {
		List<ToDoItem> list = sessionFactory.getCurrentSession().
				createQuery("from ToDoItem where todolistId="+id)
				.list();
		return list;
	}

	@Override
	public List<ToDoItem> listByStatutId(long id) {
		List<ToDoItem> list = sessionFactory.getCurrentSession().
				createQuery("from ToDoItem where statuId="+id)
				.list();
		return list;
	}

}
