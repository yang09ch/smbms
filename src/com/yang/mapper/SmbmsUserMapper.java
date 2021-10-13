package com.yang.mapper;

import com.yang.pojo.SmbmsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户表
 */
@Repository("userMapper")
public interface SmbmsUserMapper {
    //登录  +   校验
    SmbmsUser getUser(@Param("usercode") String usercode,@Param("pwd") String userpassword);

    /*分页*/
    int getCount(@Param("userName") String userName,@Param("id") Integer id);
    List<SmbmsUser> getLimit(@Param("userName") String userName,@Param("id") Integer id
    ,@Param("from") Integer from,@Param("pageSize") Integer pageSize);
    //删除
    int delete(Integer id);
    //新增
    int add(SmbmsUser smbmsUser);
    //修改
    SmbmsUser toUpdate(Integer id);
    int update(SmbmsUser smbmsUser);

    int checkCode(String code);
}
