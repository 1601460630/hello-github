package cn.itcast.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;


@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {

	private UserDao ud;
	@Override
	public User getUserByCodePassword(User u) {
		//1.���ݵ�¼���Ʋ�ѯ��¼�û�
		User existU = ud.getByUserCode(u.getUser_code());
		//2.�жϵ�¼�û��Ƿ����,������=>�׳��쳣,��ʾ�û���������
		if(existU == null) {
			throw new RuntimeException("�û��������ڣ�");
		}
		//3.�ж��û��������Ƿ���ȷ,����ȷ=>�׳��쳣,��ʾ�������
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("�������");
		}
		//4.���ز�ѯ�����û�����
		
		return null;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	
}
