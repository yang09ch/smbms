package com.yang.service.impl;

import com.yang.mapper.SmbmsUserMapper;
import com.yang.pojo.SmbmsUser;
import com.yang.service.UserService;
import com.yang.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("user")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    SmbmsUserMapper smbmsUserMapper;
    @Override
    public SmbmsUser login(String usercode, String pwd) {
        return smbmsUserMapper.getUser(usercode,pwd);
    }

    @Override
    public PageUtil<SmbmsUser> getLimit(String name, Integer id, Integer pageIndex, Integer pageSize) {
        PageUtil<SmbmsUser> pageUtil=new PageUtil<>();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalCount(smbmsUserMapper.getCount(name,id));
        pageUtil.setList(smbmsUserMapper.getLimit(name,id,(pageIndex-1)*pageSize,pageSize));
        return pageUtil;
    }

    @Override
    public int delete(Integer id) {
        return smbmsUserMapper.delete(id);
    }

    @Override
    public int add(SmbmsUser smbmsUser) {
        return smbmsUserMapper.add(smbmsUser);
    }

    @Override
    public SmbmsUser toUpdate(Integer id) {
        return smbmsUserMapper.toUpdate(id);
    }

    @Override
    public int update(SmbmsUser smbmsUser) {
        return smbmsUserMapper.update(smbmsUser);
    }
    @Override
    public boolean checkCode(String code) {
        int i = smbmsUserMapper.checkCode(code);
        if (i>0){
            return true;
        }
        return false;
    }
}
