package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Apply;
import com.stylefeng.guns.modular.system.dao.ApplyMapper;
import com.stylefeng.guns.modular.system.service.IApplyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 申请表 服务实现类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements IApplyService {

    @Override
    public void insertApply(Apply apply) {
        this.baseMapper.insertApply(apply.getId(), apply.getApplyerid(), apply.getTitle(), apply.getBody(), apply.getApplytime(), apply.getReaded(), apply.getHandled(), apply.getAgreed());
    }

    @Override
    public List<Map<String, Object>> list(String condition) {
        return this.baseMapper.list(condition);
    }

    @Override
    public List<Map<String, Object>> listHandledApply(String condition) {
        return this.baseMapper.listHandledApply(condition);
    }

}
