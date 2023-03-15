package mapper;

import org.apache.ibatis.annotations.*;
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

    /**
     * 删除单个
     */
    @Delete("DELETE FROM tb_brand WHERE id = #{id}")
    void delete(int id);

    /**
     * 修改brand
     */
    @Update("UPDATE tb_brand SET brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered}," +
            "description=#{description},status=#{status} where id=#{id}")
    void updateById(Brand brand);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     */
    @Select("SELECT * FROM tb_brand LIMIT #{begin} , #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);
    /**
     * 查询总记录数
     */
    @Select("SELECT COUNT(*) FROM tb_brand")
    //@ResultMap("brandResultMap")
    int selectTotalCount();

    /**
     * 分页条件查询
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);
    /**
     * 条件查询总记录数
     */
    int selectTotalCountByCondition(Brand brand);
}
