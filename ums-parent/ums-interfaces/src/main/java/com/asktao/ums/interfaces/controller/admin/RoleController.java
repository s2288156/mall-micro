package com.asktao.ums.interfaces.controller.admin;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.application.cmd.role.RoleAssignCmd;
import com.asktao.ums.application.service.IRoleService;
import com.asktao.ums.application.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author wcy
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/list/{uid}")
    public RestResponse<Set<RoleVo>> listForUid(@PathVariable String uid) {
        return RestResponse.success(roleService.allForUid(uid));
    }

    @GetMapping("/list_all")
    public RestResponse<Set<RoleVo>> all() {
        return RestResponse.success(roleService.all());
    }

    @PostMapping("/assign")
    public RestResponse<?> assign(@RequestBody RoleAssignCmd roleAssignCmd) {
        roleService.assignRole(roleAssignCmd);
        return RestResponse.success();
    }
}
