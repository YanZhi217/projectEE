package service;

import org.apache.ibatis.annotations.Param;
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

    /**
     * 删除单个
     */
    void delete(int id);

    /**
     * 修改
     */
    void updateById(Brand brand);

    /**
     * 批量删除
     */
    void deleteByIds(int[] ids);
}
