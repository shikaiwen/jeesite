/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dtest.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dtest.dao.TestDataDao;
import com.thinkgem.jeesite.modules.dtest.entity.MyTestData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 策划死Service
 * @author Kevin
 * @version 2018-04-12
 */
@Service(value = "ktestDataService")
@Transactional(readOnly = true)
public class TestDataService extends CrudService<TestDataDao, MyTestData> {

	public MyTestData get(String id) {
		return super.get(id);
	}
	
	public List<MyTestData> findList(MyTestData myTestData) {
		return super.findList(myTestData);
	}
	
	public Page<MyTestData> findPage(Page<MyTestData> page, MyTestData myTestData) {
		return super.findPage(page, myTestData);
	}
	
	@Transactional(readOnly = false)
	public void save(MyTestData myTestData) {
		super.save(myTestData);
	}
	
	@Transactional(readOnly = false)
	public void delete(MyTestData myTestData) {
		super.delete(myTestData);
	}
	
}