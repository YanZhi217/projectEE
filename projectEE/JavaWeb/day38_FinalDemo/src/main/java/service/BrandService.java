package service;

import pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     */
    void add(Brand brand);
}
