package serviceI;

import java.util.List;

import org.springframework.stereotype.Component;

import model.BeanUser;
import util.BaseException;

@Component
public interface IUserService {
	//注册
	public void register(String userId, String password, String userName, String userJob, String userPhone)throws BaseException;
	
	//登陆
	public BeanUser login(String userId, String password)throws BaseException;
	
	//修改密码
	public void changePassword(String userId, String oldPassword, String newPassword)throws BaseException;
	
	//重置密码
	public void resetPassword(String userId)throws BaseException;
	
	//添加用户
	public void addUser(String userId, String password, String userName, String userJob, String userPhone)throws BaseException;
	
	//修改用户信息
	public void updateUser(String userId, String password, String userName, String userJob, String userPhone)throws BaseException;
	
	//删除用户
	public void delUser(String userId)throws BaseException;
	
	//查询用户
	public BeanUser searchUser(String userId)throws BaseException;
	
	//导出所有用户
	public List<BeanUser> loadAllUser()throws BaseException;
	
	//模糊查询用户
	public List<BeanUser> loadUser(String userName)throws BaseException;
	
	public void explore()throws BaseException;
}

