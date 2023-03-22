package Generator.aaa.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 盐芝
 * @since 2023-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private String password;

    private Integer age;

    private String tel;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

    @Version
    private Integer version;

}
