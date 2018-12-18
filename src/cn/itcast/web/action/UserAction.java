package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	//ע��Service
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		//1.����Serviceִ�е�¼�߼�
		User u = userService.getUserByCodePassword(user);
		//2.�����ص�User�������session��
		ActionContext.getContext().getSession().put("user", u);
		//3.�ض�����Ŀ��ҳ
		
		return "toHome";
	}
	//ģ������ʹ�ö���
	@Override
	public User getModel() {
		return user;
	}

	
}
