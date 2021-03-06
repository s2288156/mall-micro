package com.asktao.ums.application.service;

import com.asktao.lib.domain.PageResult;
import com.asktao.lib.domain.UserDto;
import com.asktao.mybatis.base.PageQuery;
import com.asktao.ums.application.cmd.LoginCmd;
import com.asktao.ums.application.cmd.admin.AdminUpdateCmd;
import com.asktao.ums.application.vo.AdminSim;
import com.asktao.ums.domain.admin.entity.Admin;
import org.springframework.http.ResponseEntity;

/**
 * 账户相关
 *
 * @author wcy
 */
public interface IAccountService {

    /**
     * 门户会员、后台管理员登录
     *
     * @param loginCmd 登录信息
     * @return token信息
     */
    ResponseEntity<?> login(LoginCmd loginCmd);

    /**
     * 后台管理员注册
     *
     * @param admin admin
     */
    AdminSim registerAdmin(Admin admin);

    UserDto loadAdmin(String username);

    PageResult<AdminSim> pageAdmins(PageQuery pageQuery);

    void updateAdmin(AdminUpdateCmd adminUpdateCmd);
}
