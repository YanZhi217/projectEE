package service.impl;

import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import pojo.PageBean;
import service.BrandService;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //创建SqlSessionFactory工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有
     */
    @Override
    public List<Brand> selectAll() {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        List<Brand> brands = mapper.selectAll();
        //释放资源
        sqlSession.close();
        return brands;
    }

    /**
     * 添加数据
     */
    @Override
    public void add(Brand brand) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //调用方法
        mapper.add(brand);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 删除单个
     */
    @Override
    public void delete(int id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.delete(id);
        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    /**
     * 修改单个
     */
    @Override
    public void updateById(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.updateById(brand);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 调用方法
        mapper.deleteByIds(ids);
        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    /**
     * 分页查询
     */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //查询条数
        int size = pageSize;
        //查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, size);
        //查询总记录数
        int totalCount = mapper.selectTotalCount();
        //封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    /**
     * 分页条件查询
     */
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //计算开始索引
        int begin = (currentPage - 1) * pageSize;

        //查询条数
        int size = pageSize;

        //处理brand条件,模糊模糊表达式
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0){
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getBrandName();
        if(companyName != null && companyName.length() > 0){
            brand.setCompanyName("%" + companyName + "%");
        }

        //查询当前页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);
        //查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);
        //封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //释放资源
        sqlSession.close();

        return pageBean;
    }


}
