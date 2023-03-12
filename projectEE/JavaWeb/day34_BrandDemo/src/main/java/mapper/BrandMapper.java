package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {

    //查询所有
    @Select("SELECT * FROM tb_brand")
    @ResultMap("brandResultMapper")
    List<Brand> selectAll();

    //添加
    @Insert("INSERT INTO tb_brand VALUES(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //根据id查询
    @Select("SELECT * FROM tb_brand WHERE id = #{id}")
    @ResultMap("brandResultMapper")
    Brand selectById(int id);

    //修改
    @Update("UPDATE tb_brand SET brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered}," +
            "description = #{description},status = #{status} WHERE id = #{id}")
    @ResultMap("brandResultMapper")
    void update(Brand brand);

    //删除
    @Delete("DELETE FROM tb_brand WHERE id=#{id}")
    void delete(int id);
}
