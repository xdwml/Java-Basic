package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl implements UserService{
    private UserDao userDao= new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if(u!=null){
            //用户名存在，注册失败
            System.out.println("用户名存在，注册失败");
            return false;

        }
        //2.保存用户信息
        userDao.save(user);
        System.out.println("用户名不存在，注册成功");
        return true;
    }
}
