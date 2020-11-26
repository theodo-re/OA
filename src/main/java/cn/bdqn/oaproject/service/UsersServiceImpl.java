package cn.bdqn.oaproject.service;

import cn.bdqn.oaproject.dao.UsersDao;
import cn.bdqn.oaproject.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService{
    @Resource
    private UsersDao userdao;

    @Override
    public int findCByName(String uName,String password) {
        int rel = -1;
        Users user = userdao.findCByName(uName);
        if(user!=null){
            if(password.equals(user.getUPassWord())){
                rel=1;
            }else{
                rel=0;
            }
        }
        return rel;
    }
}
