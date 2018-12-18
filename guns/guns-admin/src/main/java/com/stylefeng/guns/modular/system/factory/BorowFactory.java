package com.stylefeng.guns.modular.system.factory;

import com.stylefeng.guns.modular.system.model.Borow;
import com.stylefeng.guns.modular.system.transfer.BorowDto;
import org.springframework.beans.BeanUtils;

public class BorowFactory {
    public static Borow createUser(BorowDto borowDto) {
        if (borowDto == null) {
            return null;
        } else {
            Borow borow = new Borow();
            BeanUtils.copyProperties(borowDto, borow);
            return borow;
        }
    }
}

