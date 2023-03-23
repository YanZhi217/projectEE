package com.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.common.R;
import com.reggie.dto.DishDTO;
import com.reggie.entity.Category;
import com.reggie.entity.Dish;
import com.reggie.service.CategoryService;
import com.reggie.service.DishFlavorService;
import com.reggie.service.DishService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜品管理
 */
@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增菜品
     * @param dto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody DishDTO dto){
        log.info(dto.toString());
        dishService.saveWithFlavor(dto);
        return R.success("新增菜品成功");
    }

    /**
     * 菜品信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        //构造分页构造器
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDTO> dishDTOPage = new Page<>();

        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, Dish::getName, name);
        //添加排序条件
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        //执行分页查询
        dishService.page(pageInfo, queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo, dishDTOPage, "records");
        List<Dish> records = pageInfo.getRecords();

        List<DishDTO> list = records.stream().map((item) -> {
            DishDTO DishDTO = new DishDTO();
            BeanUtils.copyProperties(item, DishDTO);
            Long categoryId = item.getCategoryId();//菜品分类id
            Category category = categoryService.getById(categoryId);//根据id查询分类id对象
            if(category != null){
                String categoryName = category.getName();
                DishDTO.setCategoryName(categoryName);
            }
            return DishDTO;
        }).collect(Collectors.toList());
        dishDTOPage.setRecords(list);

        return R.success(dishDTOPage);
    }

    /**
     * 根据id查询对应的菜品信息和菜品口味信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<DishDTO> get(@PathVariable Long id){
        DishDTO dishDTO = dishService.getByIdWithFlavor(id);
        return R.success(dishDTO);
    }

    /**
     * 修改菜品
     * @param dto
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody DishDTO dto){
        log.info(dto.toString());
        dishService.updateWithFlavor(dto);
        return R.success("修改菜品成功");
    }

    /**
     * 删除 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(String ids){
        //如果单纯的用Long来接，ids会报错，批量删除肯定接不到，所以这里选用String
        //log打印看看能否接收单个和批量
        log.info("删除的ids: {}",ids);
        String[] split = ids.split(","); //将每个id分开
        //每个id还是字符串，转成Long, trim用于删除字符串头尾的空白字符
        List<Long> idList = Arrays.stream(split).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        dishService.removeByIds(idList);//执行批量删除
        log.info("删除的ids: {}",ids);
        return R.success("删除成功"); //返回成功
    }

    /**
     * 停售 起售 批量
     * @param st
     * @param ids
     * @return
     */
    @PostMapping("/status/{st}")
    public R<String> setStatus(@PathVariable int st, String ids){
        //处理string 转成Long
        String[] split = ids.split(",");
        List<Long> idList = Arrays.stream(split).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());

        //将每个id new出来一个Dish对象，并设置状态
        List<Dish> dishes = idList.stream().map((item) -> {
            Dish dish = new Dish();
            dish.setId(item);
            dish.setStatus(st);
            return dish;
        }).collect(Collectors.toList()); //Dish集合

        log.info("status ids : {}",ids);
        dishService.updateBatchById(dishes);//批量操作
        return R.success("操作成功");
    }

    /**
     * 根据条件查询对应的菜品
     * @param dish
     * @return
     */
    @GetMapping("/list")
    public R<List<Dish>> list(Dish dish){
        //构造查询条件
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus, 1);
        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(queryWrapper);
        return R.success(list);
    }
    //http://localhost:8080/backend/page/login/login.html
}
