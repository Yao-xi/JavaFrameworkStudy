package com.yx.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    @Update("UPDATE account SET money=money+#{money} WHERE `name`=#{name}")
    void inMoney(@Param("name") String name, @Param("money") int money);
    
    @Update("UPDATE account SET money=money-#{money} WHERE `name`=#{name}")
    void outMoney(@Param("name") String name, @Param("money") int money);
}
