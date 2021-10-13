package com.yang.service;

import com.yang.pojo.SmbmsUser;
import com.yang.util.PageUtil;

public interface UserService {
    SmbmsUser login(String usercode,String pwd);

    /**
     * 分页
     * @param name
     * @param id
     * @param pageIndex
     * @param pageSize
     * @return PageUtil
     */
    PageUtil<SmbmsUser> getLimit(String name,Integer id,Integer pageIndex,Integer pageSize);
    int delete(Integer id);
    //新增
    int add(SmbmsUser smbmsUser);
    //修改
    SmbmsUser toUpdate(Integer id);
    int update(SmbmsUser smbmsUser);
    boolean checkCode(String code);
}
