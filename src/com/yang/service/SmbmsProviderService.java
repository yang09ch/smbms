package com.yang.service;

import com.yang.pojo.SmbmsProvider;
import com.yang.util.PageUtil;

import java.util.List;

public interface SmbmsProviderService {
    //删
    int delete(Integer id);
    //曾
    int insert(SmbmsProvider provider);
    //去改
    SmbmsProvider getByid(Integer id);
    List<SmbmsProvider> getAll();
    //改
    int update(SmbmsProvider smbmsProvider);
    PageUtil<SmbmsProvider> getLimit(String colde,String name,Integer pageIndex,Integer pageSize);
}
