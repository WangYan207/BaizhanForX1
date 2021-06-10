package com.bjsxt.controller;

import com.bjsxt.TbItemParamCatServiceAPI;
import com.bjsxt.commons.pojo.BaizhanResult;
import com.bjsxt.ov.TbItemCatOv;
import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.service.TbItemParamCatService;
import com.bjsxt.service.impl.TbItemParamCatServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j

public class TbItemCatController {
    @Autowired
    private TbItemParamCatService tbItemParamCatService;

    /**
     * 根据父类目查询所有子类目
     */

    @RequestMapping("/backend/itemCategory/selectItemCategoryByParentId")
    public BaizhanResult TbItemCatByParentId(@RequestParam(name = "id",defaultValue = "0") Long id){

        return tbItemParamCatService.selTbItemParamCatByParentId(id);
    }

}
