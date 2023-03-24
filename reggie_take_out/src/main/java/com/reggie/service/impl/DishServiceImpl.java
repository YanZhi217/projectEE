package com.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.common.CustomException;
import com.reggie.dto.DishDto;
import com.reggie.entity.Dish;
import com.reggie.entity.DishFlavor;
import com.reggie.entity.Setmeal;
import com.reggie.entity.SetmealDish;
import com.reggie.mapper.DishMapper;
import com.reggie.service.DishFlavorService;
import com.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品,同时保存对应的口味数据
     * @param dto
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDto dto) {
        //保存菜品的基本数据到菜品表dish
        this.save(dto);
        Long dishId = dto.getId();//菜品id
        List<DishFlavor> flavors = dto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());
        //保存菜品口味到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 根据id查询对应的菜品信息和菜品口味信息
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {
        //查询菜品信息, 从dish表
        Dish dish = this.getById(id);
        DishDto dishDTO = new DishDto();
        BeanUtils.copyProperties(dish, dishDTO);
        //查询口味信息, 从dish_flavor表
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDTO.setFlavors(flavors);
        return dishDTO;
    }

    /**
     * 修改菜品信息及菜品口味信息
     * @param dto
     */
    @Override
    @Transactional
    public void updateWithFlavor(DishDto dto) {
        //更新dish表基本信息
        this.updateById(dto);
        //清理当前口味信息 dish_flavor delete
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dto.getId());
        dishFlavorService.remove(queryWrapper);
        //添加当前提交的口味信息 dish_flavor insert
        List<DishFlavor> flavors =  dto.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dto.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);

    }

    /**
     * 删除停售的菜品
     * @param ids
     */
    @Override
    public void deleteWithFlavor(List<Long> ids) {
        //查询套餐状态, 确定是否可以删除, 停售才可以删除
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //SELECT COUNT(*) FROM SETMEAL WHERE ID IN (1,2,3...) AND STATUS =1
        queryWrapper.in(Dish::getId, ids);
        queryWrapper.eq(Dish::getStatus, 1);
        int count = this.count(queryWrapper);
        if(count > 0){
            //如果不能删除, 抛出一个业务异常
            throw new CustomException("套餐正在售卖中, 不能删除");
        }

        //如果可以删除, 先删除套餐表中的数据, setmeal
        this.removeByIds(ids);

        //删除关系表中的数据, setmeal_dish
        //DELETE FROM setmeal_dish WHERE setmeal_id in (1,2,3...)
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(DishFlavor::getDishId, ids);
        dishFlavorService.remove(lambdaQueryWrapper);
    }
}
