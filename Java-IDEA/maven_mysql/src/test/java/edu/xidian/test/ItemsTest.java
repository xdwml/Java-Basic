package edu.xidian.test;

import edu.xidian.dao.impl.ItemsDaoImpl;
import edu.xidian.dao.ItemsDao;
import edu.xidian.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsdao=new ItemsDaoImpl();
        List<Items> list=itemsdao.findAll();
        for (Items items:list) {
            System.out.println(items.getName());
        }
    }
}
