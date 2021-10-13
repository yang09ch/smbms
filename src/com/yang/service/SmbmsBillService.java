package com.yang.service;

import com.yang.pojo.SmbmsBill;
import com.yang.util.PageUtil;

public interface SmbmsBillService {
    int insert(SmbmsBill bill);
    int delete(Integer id);
    SmbmsBill getByid(Integer id);
    int getUpdate(SmbmsBill bill);
    PageUtil<SmbmsBill> getBillLimit(Integer isPayment,String productName,Integer providerId,Integer pageIndex,Integer pageSize);
}
