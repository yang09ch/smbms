package com.yang.service.impl;

import com.yang.mapper.SmbmsProviderMapper;
import com.yang.pojo.SmbmsProvider;
import com.yang.service.SmbmsProviderService;
import com.yang.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("provider")
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
    @Resource(name = "providerMapper")
    SmbmsProviderMapper providerMapper;
    @Override
    public int delete(Integer id) {
        return providerMapper.delete(id);
    }

    @Override
    public int insert(SmbmsProvider provider) {
        return providerMapper.insert(provider);
    }

    @Override
    public SmbmsProvider getByid(Integer id) {
        return providerMapper.getByid(id);
    }

    @Override
    public List<SmbmsProvider> getAll() {
        return providerMapper.getAll();
    }

    @Override
    public int update(SmbmsProvider smbmsProvider) {
        return providerMapper.update(smbmsProvider);
    }

    @Override
    public PageUtil<SmbmsProvider> getLimit(String colde, String name, Integer pageIndex, Integer pageSize) {
        PageUtil<SmbmsProvider> pageUtil=new PageUtil<>();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalCount(providerMapper.getCount(colde,name));
        pageUtil.setList(providerMapper.getLimit(colde,name,(pageIndex-1)*pageSize,pageSize));
        return pageUtil;
    }
}
