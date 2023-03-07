package test;

import Mapper.BrandMapper;
import Pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    //查询所有
    @Test
    public void testSelectAll() throws IOException {
        //1.获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行SQL
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    //根据id查看详情
    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;

        //1.获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行SQL
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    //条件查询
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        /*//封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        //封装集合
        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1.获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //5.执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    //单条件动态条件查询
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //1.获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //5.执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    //添加
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //开启自动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //5.执行方法
        brandMapper.add(brand);
        //获取主键，需要配合BrandMapper.xml设置，否则无法获取主键
        //Integer id = brand.getId();

        //6.提交事务
        sqlSession.commit();

        //7.释放资源
        sqlSession.close();
    }

    //修改全部字段
    @Test
    //添加
    public void testUpdate() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 5;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1.获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //开启自动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //5.执行方法
        brandMapper.update(brand);
        //获取主键，需要配合BrandMapper.xml设置，否则无法获取主键
        //Integer id = brand.getId();

        //6.提交事务
        sqlSession.commit();

        //7.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id = 5;

        //1. 获取SqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法

        brandMapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }
}
