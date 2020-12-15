package com.mall.ums.application.service.impl;

import com.mall.lib.constant.AuthConstant;
import com.mall.ums.application.dto.MemberRegisterDTO;
import com.mall.ums.application.service.AuthClient;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.domain.member.IMemberDomainService;
import com.mall.ums.domain.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wcy
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IMemberDomainService memberDomainService;

    @Autowired
    private AuthClient authClient;

    @Override
    public void registerMember(MemberRegisterDTO memberRegister) {
        Member registerMember = new Member();
        registerMember.setRegisterInfo(memberRegister.getRegisterInfo());
        memberDomainService.register(registerMember);
    }

    @Override
    public Member memberLogin(String username) {
        return memberDomainService.login(username);
    }

    @Override
    public Member detailForUid(String uid) {
        return memberDomainService.detail(uid);
    }

    @Override
    public ResponseEntity<?> login(String username, String password) {
        Map<String, String> params = new HashMap<>(16);
        params.put("client_id", AuthConstant.CLIENT_ID_PORTAL);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        return authClient.oauthToken(params);
    }
}
