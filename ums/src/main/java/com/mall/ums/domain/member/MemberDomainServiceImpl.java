package com.mall.ums.domain.member;

import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.domain.member.entity.RegisterInfo;
import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.enums.AccountTypeEnum;
import com.mall.ums.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wcy
 */
@Service
public class MemberDomainServiceImpl implements IMemberDomainService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(Member registerMember) {
        RegisterInfo registerInfo = registerMember.getRegisterInfo();
        if (registerInfo == null) {
            throw new BizException(ResultCodeEnum.USER_REGISTER_ERROR);
        }
        checkUsernameNotExisted(registerInfo.getUsername());
        UserDO userDO = registerInfo.convert2Do();
        userDO.setAccountType(AccountTypeEnum.MEMBER);
        userMapper.insert(userDO);
    }

    private void checkUsernameNotExisted(String username) {
        Optional<UserDO> optionalUserDO = userMapper.selectByUsername(username);
        if (optionalUserDO.isPresent()) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
    }
}
