package com.yang.service.impl;

import com.yang.mapper.SmbmsRoleMapper;
import com.yang.pojo.SmbmsRole;
import com.yang.service.SmbmsRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("role")
public class SmbmsRoleServiceImpl implements SmbmsRoleService {

    @Resource(name = "roleMapper")
    SmbmsRoleMapper smbmsRoleMapper;
    @Override
    public List<SmbmsRole> getAll() {
        return smbmsRoleMapper.getAll();
    }
}
