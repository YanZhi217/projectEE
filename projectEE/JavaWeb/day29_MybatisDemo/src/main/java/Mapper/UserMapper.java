package Mapper;

import Pojo.User;

import java.util.List;

public interface UserMapper {
    public abstract List<User> selectAll();

    public abstract User selectById(int id);
}
