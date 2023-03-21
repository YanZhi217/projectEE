package Generator.aaa.service.impl;

import Generator.aaa.domain.User;
import Generator.aaa.dao.UserDao;
import Generator.aaa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 盐芝
 * @since 2023-03-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
