package com.todoapp.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todoapp.spring.dao.MemberDao;
import com.todoapp.spring.dao.ToDoItemDao;
import com.todoapp.spring.dao.ToDoListDao;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoItem;
import com.todoapp.spring.model.ToDoList;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

	@Autowired
	private ToDoItemDao itemDao;

	@Override
	@Transactional
	public long save(ToDoItem item) {

		return itemDao.save(item);
	}

	@Override
	@Transactional
	public ToDoItem get(long id) {

		return itemDao.get(id);
	}

	@Override
	@Transactional
	public void update(long id, ToDoItem item) {
		itemDao.update(id, item);

	}

	@Override
	@Transactional
	public List<ToDoItem> list() {

		return itemDao.list();
	}

	@Override
	@Transactional
	public void delete(long id) {
		itemDao.delete(id);

	}

	@Override
	@Transactional
	public List<ToDoItem> listByToDoListId(long id) {

		return itemDao.listByToDoListId(id);
	}

	@Override
	@Transactional
	public List<ToDoItem> listByStatuId(long id) {
		return itemDao.listByStatutId(id);
	}

}
