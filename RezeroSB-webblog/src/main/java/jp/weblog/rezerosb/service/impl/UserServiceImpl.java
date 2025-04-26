package jp.weblog.rezerosb.service.impl;

import jp.weblog.rezerosb.model.User;
import jp.weblog.rezerosb.repository.UserMapper;
import jp.weblog.rezerosb.service.UserService;
import jp.weblog.rezerosb.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username){
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password){
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(username,md5String);
    }
}
