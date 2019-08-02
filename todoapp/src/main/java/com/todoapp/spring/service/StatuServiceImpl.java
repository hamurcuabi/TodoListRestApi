package com.todoapp.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.todoapp.spring.dao.MemberDao;
import com.todoapp.spring.dao.StatuDao;
import com.todoapp.spring.dao.ToDoListDao;
import com.todoapp.spring.model.Member;
import com.todoapp.spring.model.Statu;
import com.todoapp.spring.model.ToDoList;

@Service
public class StatuServiceImpl implements StatuService {

	@Autowired
	private  StatuDao itemDao;

	@Override
	@Transactional
	public long save( Statu item) {

		return itemDao.save(item);
	}

	@Override
	@Transactional
	public  Statu get(long id) {

		return itemDao.get(id);
	}

	@Override
	@Transactional
	public void update(long id,  Statu item) {
		itemDao.update(id, item);

	}

	@Override
	@Transactional
	public List< Statu> list() {

		return itemDao.list();
	}

	@Override
	@Transactional
	public void delete(long id) {
		itemDao.delete(id);

	}



}
