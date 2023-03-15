package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /**
     *  查询所有
     */
    @Select("SELECT * FROM tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     *  添加数据
     */
    @Insert("INSERT INTO tb_brand VALUES(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
}
