package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	
	//�����û���¼���Ʋ�ѯuser����
	User getByUserCode(String usercode);
	//ע���û�
	void save(User u);
}
