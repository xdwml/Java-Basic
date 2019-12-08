package edu.xidian.service;

public class UserServiceImpl implements UserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("创建用户..."+name);
    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl()调用了");
    }
}
