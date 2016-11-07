package com.sso.sys.service.impl;

import org.springframework.stereotype.Service;

import com.sso.sys.entity.User;
import com.sso.sys.mapper.UserMapper;
import com.sso.sys.service.IUserService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service(value="userService")
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {


}