package service;

import mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Brand;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     */
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()

        //获取SqlSession
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
     * 添加
     */
    public void Add(Brand brand){
        //调用BrandMapper.Add()

        //获取SqlSession
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
     * 根据id查询
     */
    public Brand selectById(int id){
        //调用BrandMapper.selectById()

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        Brand brand = mapper.selectById(id);
        //释放资源
        sqlSession.close();

        return brand;
    }

    /**
     * 修改
     */
    public void update(Brand brand){
        //调用BrandMapper.update()

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 删除
     */
    public void delete(int id){
        //调用BrandMapper.update()

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.delete(id);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
