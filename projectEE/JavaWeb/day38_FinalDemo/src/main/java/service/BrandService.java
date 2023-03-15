package service;

import org.apache.ibatis.annotations.Param;
import pojo.Brand;
import pojo.PageBean;

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

    /**
     * 分页查询
     * 当前页码
     * 每页展示条数
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 条件分页查询
     * 当前页码
     * 每页展示条数
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
