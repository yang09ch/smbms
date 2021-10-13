package com.yang.mapper;

import com.yang.pojo.SmbmsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *订单表
 */
public interface SmbmsBillMapper {
    int insert(SmbmsBill bill);
    int delete(Integer id);
    SmbmsBill getByid(Integer id);
    int getUpdate(SmbmsBill bill);
//查询
    int getCount(@Param("isPayment") Integer isPayment,@Param("productName") String productName,@Param("providerId") Integer providerId);
    List<SmbmsBill> getBillLimit(@Param("isPayment") Integer isPayment,@Param("productName") String productName
            ,@Param("providerId") Integer providerId,
                             @Param("form") Integer form,@Param("pageSize") Integer pageSize);
}
