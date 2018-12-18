package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Borow;
import com.stylefeng.guns.modular.system.dao.BorowMapper;
import com.stylefeng.guns.modular.system.service.IBorowService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备借用表 服务实现类
 * </p>
 *
 * @author jeanrry
 * @since 2018-09-08
 */
@Service
public class BorowServiceImpl extends ServiceImpl<BorowMapper, Borow> implements IBorowService {
    @Override
    public void insertBorow(Borow borow) {
        this.baseMapper.insertBorow(borow.getId(), borow.getDeviceid(),borow.getUserid(), borow.getBorrowtime(), borow.getReturntime(), borow.getSort(), borow.getNextuser(), borow.getPersonnuminline());
    }

    @Override
    public List<Map<String, Object>> selectBorows() {
        return this.baseMapper.selectBorows();
    }

    @Override
    public List<Map<String, Object>> selectBorowsByBorow(String id, String deviceid, Integer userid, Date borrowtime, Date returntime, Integer sort, Integer nextuser) {
        return this.baseMapper.selectBorowsByBorow(id, deviceid, userid, borrowtime, returntime, sort, nextuser);
    }

    @Override
    public Borow getByBorowId(String id) {
        Map b = this.baseMapper.getByBorowId(id).get(0);
        Borow borow = new Borow();

        borow.setId((String) b.get("id"));
        borow.setBorrowtime((Date) b.get("borrowtime"));
        borow.setDeviceid((String) b.get("deviceid"));
        borow.setNextuser((Integer) b.get("nextuser"));
        borow.setPersonnuminline((Integer) b.get("persomnuminline"));
        borow.setReturntime((Date) b.get("returntime"));
        borow.setSort((Integer) b.get("sort"));
        borow.setUserid((Integer) b.get("userid"));
        return borow;
    }

    @Override
    public List<Map<String, Object>> selectBorowsByUserid(Integer userid) {
        return this.baseMapper.selectBorowsByUserid(userid);
    }

    @Override
    public Borow getByNextUserId(Integer nextuser) {

        Map b = this.baseMapper.getByNextUserId(nextuser).get(0);
        Borow borow = new Borow();

        borow.setId((String) b.get("id"));
        borow.setBorrowtime((Date) b.get("borrowtime"));
        borow.setDeviceid((String) b.get("deviceid"));
        borow.setNextuser((Integer) b.get("nextuser"));
        borow.setPersonnuminline((Integer) b.get("persomnuminline"));
        borow.setReturntime((Date) b.get("returntime"));
        borow.setSort((Integer) b.get("sort"));
        borow.setUserid((Integer) b.get("userid"));
        return borow;
    }


}
