/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dtest.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dtest.entity.MyTestData;

/**
 * 策划死DAO接口
 * @author Kevin
 * @version 2018-04-12
 */
@MyBatisDao("ktestDataDao")
public interface TestDataDao extends CrudDao<MyTestData> {
	
}