package edu.xidian.dao.impl;

import edu.xidian.dao.ItemsDao;
import edu.xidian.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao{

    public List<Items> findAll() throws Exception {
        List<Items> list=new ArrayList<Items>();
        //先获取connection对象
        Connection connection=null;
        //获取正整操作数据的对象
        PreparedStatement pst=null;
        //执行数据库查询操作
        ResultSet resultSet=null;
        try{
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven","root","root");
            //获取正整操作数据的对象
            pst= connection.prepareCall("select * from items");
            //执行数据库查询操作
            resultSet = pst.executeQuery();
            //把数据库结果集转成java的List集合

            while (resultSet.next()){
                Items items=new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            resultSet.close();
        }

        return list;
    }
}
