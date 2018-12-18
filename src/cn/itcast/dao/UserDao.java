package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	
	//根据用户登录名称查询user对象
	User getByUserCode(String usercode);
	//注册用户
	void save(User u);
}
