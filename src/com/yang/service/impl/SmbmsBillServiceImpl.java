package com.yang.service.impl;

import com.yang.mapper.SmbmsBillMapper;
import com.yang.pojo.SmbmsBill;
import com.yang.service.SmbmsBillService;
import com.yang.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
    @Resource
    SmbmsBillMapper billMapper;
    @Override
    public int insert(SmbmsBill bill) {
        return billMapper.insert(bill);
    }

    @Override
    public int delete(Integer id) {
        return billMapper.delete(id);
    }

    @Override
    public SmbmsBill getByid(Integer id) {
        return billMapper.getByid(id);
    }

    @Override
    public int getUpdate(SmbmsBill bill) {
        return billMapper.getUpdate(bill);
    }

    @Override
    public PageUtil<SmbmsBill> getBillLimit(Integer isPayment,String productName, Integer providerId, Integer pageIndex, Integer pageSize) {
        PageUtil<SmbmsBill> pageUtil=new PageUtil<>();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setTotalCount(billMapper.getCount(isPayment,productName,providerId));
        pageUtil.setList(billMapper.getBillLimit(isPayment,productName,providerId,(pageIndex-1)*pageSize,pageSize));
        return pageUtil;
    }
}
