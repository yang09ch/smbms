package com.yang.mapper;

import com.yang.pojo.SmbmsRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表
 */
@Repository("roleMapper")
public interface SmbmsRoleMapper {
    List<SmbmsRole> getAll();
}
