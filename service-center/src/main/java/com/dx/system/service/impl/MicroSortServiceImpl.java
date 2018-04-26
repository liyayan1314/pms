package com.dx.system.service.impl;

import com.dx.system.domain.MicroSort;
import com.dx.system.mapper.MicroSortMapper;
import com.dx.system.service.MicroSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiewx on 2018/4/19.
 */
@Service
public class MicroSortServiceImpl implements MicroSortService {
    @Autowired
    private MicroSortMapper microSortMapper;
    @Override
    public int save(MicroSort microSort) {
        int result=microSortMapper.insert(microSort.getId(),microSort.getName(),microSort.getEnable(),microSort.getParentId(),microSort.getCreateTime());
        return 0;
    }
}
