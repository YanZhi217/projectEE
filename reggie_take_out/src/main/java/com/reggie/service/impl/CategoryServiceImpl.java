package com.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.common.CustomException;
import com.reggie.entity.Category;
import com.reggie.entity.Dish;
import com.reggie.entity.Setmeal;
import com.reggie.mapper.CategoryMapper;
import com.reggie.service.CategoryService;
import com.reggie.service.DishService;
import com.reggie.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private DishService dishService;
    @Autowired
    private SetMealService setMealService;

    /**
     * 根据id删除分类, 删除之前进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        //判断当前分类是否关联了菜品
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
            //添加查询条件,根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishLambdaQueryWrapper);
        if(count > 0){
            //如果已经关联了，则抛出业务异常
            throw new CustomException("当前分类下关联了菜品,不能删除");
        }

        //判断当前分类是否关联了套餐
        LambdaQueryWrapper<Setmeal> setMealLambdaQueryWrapper = new LambdaQueryWrapper<Setmeal>();
        setMealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        count = setMealService.count(setMealLambdaQueryWrapper);
        if(count >0){
            //如果已经关联了，则抛出业务异常
            throw new CustomException("当前分类下关联了套餐,不能删除");
        }
        //正常删除分类
        super.removeById(id);
    }
}
