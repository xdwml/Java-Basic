package edu.xidian.dao;

import edu.xidian.domain.Items;
import java.util.List;

public interface ItemsDao {
    public List<Items> findAll() throws  Exception;
}
