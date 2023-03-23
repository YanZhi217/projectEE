package com.reggie.dto;

import com.reggie.entity.Dish;
import com.reggie.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object 数据传输对象, 一般用于展示层与服务层之间的数据传输
 * 整合Dish与DishFlavor数据
 */
@Data
public class DishDTO extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
