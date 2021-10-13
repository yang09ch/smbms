package com.yang.mapper;

import com.yang.pojo.SmbmsProvider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供应商
 */
@Repository("providerMapper")
public interface SmbmsProviderMapper {
    //分页  两条件  查询
    int getCount(@Param("procode") String procode,@Param("proname") String proname);
    List<SmbmsProvider> getLimit(@Param("procode") String procode,@Param("proname") String proname
            ,@Param("from") Integer from,@Param("pageSize") Integer pageSize);
    //删
    int delete(Integer id);
    //曾
    int insert(SmbmsProvider provider);
    //去改
    SmbmsProvider getByid(Integer id);
    //改
    int update(SmbmsProvider smbmsProvider);
    List<SmbmsProvider> getAll();
}
