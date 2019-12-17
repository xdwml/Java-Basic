package cn.itcast.travel.dao;

import java.util.List;
import cn.itcast.travel.domain.Category;

public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
