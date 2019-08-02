package com.todoapp.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todoapp.spring.dao.MemberDao;
import com.todoapp.spring.dao.ToDoListDao;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.ToDoList;

@Service
public class ToDoListServiceImpl implements ToDoListService {

	@Autowired
	private ToDoListDao itemDao;

	@Override
	@Transactional
	public long save(ToDoList item) {
		return itemDao.save(item);
	}

	@Override
	@Transactional
	public ToDoList get(long id) {

		return itemDao.get(id);
	}

	@Override
	@Transactional
	public void update(long id, ToDoList item) {
		itemDao.update(id, item);

	}

	@Override
	@Transactional
	public List<ToDoList> list() {

		return itemDao.list();
	}

	@Override
	@Transactional
	public void delete(long id) {
		itemDao.delete(id);

	}

	@Override
	@Transactional
	public List<ToDoList> listByMemberId(long id) {

		return itemDao.listByMemberId(id);
	}

}
