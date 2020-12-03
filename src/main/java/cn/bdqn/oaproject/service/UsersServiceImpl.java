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
    public Object[] findCByName(String uName,String password) {
        Object[] obj = new Object[2];
        int rel = -1;
        Users user = userdao.findCByName(uName);
        if(user!=null){
            if(password.equals(user.getUPassWord())){
                rel=1;
            }else{
                rel=0;
            }
        }
        obj[0]=rel;
        obj[1]=user;
        return obj;
    }

    @Override
    public int findByrealName(String name) {
        return userdao.findByrealName(name);
    }

    @Override
    public int findIdByName(String name) {
        int rel=userdao.findIdByName(name);
        return rel;
    }
}
