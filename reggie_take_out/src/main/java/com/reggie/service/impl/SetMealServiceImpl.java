package com.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.common.CustomException;
import com.reggie.dto.SetmealDto;
import com.reggie.entity.Setmeal;
import com.reggie.entity.SetmealDish;
import com.reggie.mapper.SetMealMapper;
import com.reggie.service.SetMealDishService;
import com.reggie.service.SetMealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SetMealServiceImpl extends ServiceImpl<SetMealMapper, Setmeal> implements SetMealService {

    @Autowired
    private SetMealDishService setMealDishService;

    /**
     * 新增套餐, 同时保存套餐和菜品的关联关系
     * @param setmealDto
     */
    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息, 操作setmeal, 执行insert
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes = setmealDishes.stream().peek((item) -> item.setSetmealId(setmealDto.getId())).collect(Collectors.toList());
        //保存套餐和菜品的关联信息,操作setmeal_dish, 执行insert操作
        setMealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐, 同时删除套餐与菜品的关联数据
     * @param ids
     */
    @Override
    public void removeWithDish(List<Long> ids) {
        //查询套餐状态, 确定是否可以删除, 停售才可以删除
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
            //SELECT COUNT(*) FROM SETMEAL WHERE ID IN (1,2,3...) AND STATUS =1
        queryWrapper.in(Setmeal::getId, ids);
        queryWrapper.eq(Setmeal::getStatus, 1);
        int count = this.count(queryWrapper);
        if(count > 0){
            //如果不能删除, 抛出一个业务异常
            throw new CustomException("套餐正在售卖中, 不能删除");
        }

        //如果可以删除, 先删除套餐表中的数据, setmeal
        this.removeByIds(ids);

        //删除关系表中的数据, setmeal_dish
            //DELETE FROM setmeal_dish WHERE setmeal_id in (1,2,3...)
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId, ids);
        setMealDishService.remove(lambdaQueryWrapper);
    }
}
