package com.springboot.enumdemo.service.serviceimpl;

import com.springboot.enumdemo.dto.UserResult;
import com.springboot.enumdemo.dto.UserVo;
import com.springboot.enumdemo.mapper.UserMapper;
import com.springboot.enumdemo.pojo.User;
import com.springboot.enumdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: UserService的实现类
 * @Author 傅琦
 * @Date 2019/4/23 20:31
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    /**
     *@Description: 根据姓名查找用户
     *@parameters: [userName]
     *@return: com.springboot.enumdemo.dto.UserResult<com.springboot.enumdemo.pojo.User>
     *@Author: 傅琦
     *@Date: 2019/4/23 20:48
     */
    public UserResult<Object> findUserByName(String userName) {
        User user = userMapper.findUserByName(userName);
        if (user == null){
            return new UserResult<>("fail", "该用户不存在");
        }else {
            UserVo userVo = new UserVo(user);
            return new UserResult<>("success", userVo);
        }
    }

    @Override
    public UserResult<String> addUser(User user) {
        int resultCode = userMapper.addUser(user);
        if (resultCode == 1){
            return new UserResult<>("success", "添加用户成功");
        }else {
            return new UserResult<>("fail", "添加用户失败，请稍后重试");
        }
    }

    @Override
    public UserResult<String> modifyUser(User user) {
        int resultCode = userMapper.modifyUser(user);
        if (resultCode == 1){
            return new UserResult<>("success", "修改信息成功");
        }else {
            return new UserResult<>("fail", "修改信息失败，请稍后重试");
        }
    }
}
