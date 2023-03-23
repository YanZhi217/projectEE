package com.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggie.dto.DishDTO;
import com.reggie.entity.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品,同时插入菜品对应的口味数据,需要操作两张表:dish、dish_flavor
    public void saveWithFlavor(DishDTO dto);

    //根据id查询对应的菜品信息和菜品口味信息
    public DishDTO getByIdWithFlavor(Long id);

    //修改菜品信息及口味信息
    public void updateWithFlavor(DishDTO dto);
}
