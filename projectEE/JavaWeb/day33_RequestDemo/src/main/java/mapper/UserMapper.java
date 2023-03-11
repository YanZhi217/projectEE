package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {

    //根据用户名和用户密码查询用户对象
    @Select("SELECT * FROM db1.tb_user WHERE username = #{username} AND password = #{password}")
    User select(@Param("username") String username,@Param("password") String password);

    //根据用户名查询用户对象
    @Select("SELECT * FROM db1.tb_user WHERE username = #{username}")
    User selectByUsername(String username);

    //添加用户
    @Insert("INSERT INTO db1.tb_user VALUES(null,#{username},#{password})")
    void add(User user);
}