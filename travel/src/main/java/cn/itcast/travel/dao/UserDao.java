package cn.itcast.travel.dao;
import cn.itcast.travel.domain.User;
public interface UserDao {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public User findByUsername(String username);

    public void save(User user);
}
