package tech.mhuang.interchan.sso.sysuser.service;

import java.util.List;

import tech.mhuang.ext.interchan.core.service.BaseService;
import tech.mhuang.ext.interchan.protocol.data.PageVO;
import tech.mhuang.interchan.protocol.sso.UserDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.LoginSysUserDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.SysUserAddDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.SysUserDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.SysUserUpdateDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.SysUserVO;
import tech.mhuang.interchan.protocol.sso.sysuser.dto.SysUserPageDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.dto.SysUserPageQryDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.pwd.ResetPwdDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.pwd.UpdateCenterPwdDTO;
import tech.mhuang.interchan.protocol.sso.sysuser.pwd.UpdatePwdDTO;
import tech.mhuang.interchan.sso.sysuser.entity.SysUser;

/**
 * 
 * @ClassName:  ISysUserService   
 * @Description:系统用户接口   
 * @author: mhuang
 * @date:   2017年7月18日 下午7:13:17
 */
public interface ISysUserService extends BaseService<SysUser, String>{

	/**
	 * 
	 * @Title: queryUserByPage   
	 * @Description: 分页查询用户  
	 * @param sysUserDTO
	 * 			分页条件DTO
	 * @return
	 * @return PageVO<SysUserVO>
	 */
	public PageVO<SysUserVO> queryUserByPage(SysUserDTO sysUserDTO);

	/**
	 * 
	 * @Title: saveUser   
	 * @Description: 新增系统用户   
	 * @param sysUserDTO
	 * @return
	 * @return int
	 * @throws Exception 
	 */
	public void saveUser(SysUserAddDTO sysUserAddDTO);
	
	/**
	 * 
	 * @Title: updatePwd   
	 * @Description:修改系统用户 密码 
	 * @param updatePwdDTO
	 * @return void
	 */
	public void updatePwd(UpdatePwdDTO updatePwdDTO);
	
	/**
	 * 
	 * @Title: updatePwd   
	 * @Description:修改系统用户 密码 
	 * @param updatePwdDTO
	 * @return void
	 */
	public void updateLoginPwd(UpdateCenterPwdDTO updatePwdDTO);
	
	/**
	 * 
	 * @Title: resetPwd   
	 * @Description:重置系统用户 密码 
	 * @param updatePwdDTO
	 * @return void
	 */
	public void resetPwd(ResetPwdDTO resetPwd);
	/**
	 * 
	 * @Title: lockUser   
	 * @Description: 锁定用户
	 * @param lockUserDTO
	 * @return void
	 */
	public void lockUser(UserDTO lockUserDTO);
	/**
	 * 
	 * @Title: updateUser   
	 * @Description:修改系统用户 
	 * @param sysUserUpdateDTO
	 * @return void
	 */
	public void updateUser(SysUserUpdateDTO sysUserUpdateDTO);

	/**   
	 * @Title: loginUsePwd   
	 * @Description:使用密码登录
	 * @param mobilephone 手机号
	 * @param password 密码
	 * @return LoginSysUserDTO	     
	 */
	public LoginSysUserDTO loginUsePwd(String mobilephone, String password);

	/** 
	 * 排序分页查询    
	 * @Title: pageForOrder
	 * @param sysUserDTO
	 * @return List<SysUserPageDTO>     
	 */
	public List<SysUserPageDTO> pageForOrder(SysUserPageQryDTO sysUserDTO);

	/** 
	 * 通过用户ID查询用户    
	 * @Title: findByUserIds
	 * @param userIds
	 * @return List<SysUser>     
	 */
	public List<SysUser> findByUserIds(List<String> userIds);
}
