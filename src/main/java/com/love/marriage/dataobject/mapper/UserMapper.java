package com.love.marriage.dataobject.mapper;

import com.love.marriage.dataobject.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Crete by Marlon
 * Create Date: 1/10/2018
 * Class Describe
 * user 表使用 mybatis 来学习
 * 通过sql语句进行灵活的配置书写
 * <p>
 * <p>
 * 还缺一个分页查询用户
 * 统计数量的这个地方还有问题
 **/
public interface UserMapper {

    //插入通过字段的方式
    @Insert({"insert into user ( user_phone,user_password) values (#{user_phone,jdbcType=VARCHAR},#{ user_password,jdbcType=VARCHAR})"})
    int insertByMap(Map<String, Object> map);


    //插入通过对象的方式
    @Insert({"insert into user (user_phone,user_password) values (#{userPhone,jdbcType=VARCHAR},#{userPassword,jdbcType=VARCHAR})"})
    int insertByObject(User user);


    @Select("select * from  user where user_phone = #{userPhone}")
    @Results({
                     @Result(column = "user_id", property = "userId"),
                     @Result(column = "user_phone", property = "userPhone"),
                     @Result(column = "user_password", property = "userPassword")
    })
    User findUserByPhone(String phone);


    //判断该用户是否存在
    @Select("select count(*) as  num from  user where user_phone = #{userPhone}")
    @Results({
                     @Result(column = "num"),
    })
    int findUserExist(String phone);


    @Select("select * from  user where user_id = #{userId}")
    @Results({
                     @Result(column = "user_id", property = "userId"),
                     @Result(column = "user_phone", property = "userPhone"),
                     @Result(column = "user_password", property = "userPassword")
    })
    User findUserByUserId(String userId);


    //根据参数修改对象
    @Update("update user set user_password = #{userPassword}  where user_id = #{userId}")
    int updatePasswordByUserId(@Param("userId") String userId, @Param("userPassword") String userPassword);


    //根据对象修改参数
    @Update("update user set user_password = #{userPassword}  where user_phone = #{userPhone}")
    int updatePasswordByPhone(User ser);


    @Select("select * from user ")
    @Results({
                     @Result(column = "user_id", property = "userId"),
                     @Result(column = "user_phone", property = "userPhone"),
                     @Result(column = "user_password", property = "userPassword")
    })
    List<User> findUsers();

    //根据xml配置文件来进行访问数据
    //方法名要和XML文件中的一致  这一种也更加直观
    User selectUserById(String userId);

}
