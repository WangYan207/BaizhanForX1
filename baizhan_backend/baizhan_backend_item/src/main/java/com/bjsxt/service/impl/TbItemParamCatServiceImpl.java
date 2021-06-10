package com.bjsxt.service.impl;

import com.bjsxt.TbItemParamCatServiceAPI;
import com.bjsxt.commons.pojo.BaizhanResult;
import com.bjsxt.ov.TbItemCatOv;
import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.service.TbItemParamCatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbItemParamCatServiceImpl implements TbItemParamCatService {
    @Autowired
    private TbItemParamCatServiceAPI tbItemParamCatServiceAPI;
    @Override
    public BaizhanResult selTbItemParamCatByParentId(Long parentId) {
        List<TbItemCat> tbItemParamCatByParentIdResult =
                tbItemParamCatServiceAPI.getTbItemParamCatByParentId(parentId);
        List<TbItemCatOv> ovLists = new ArrayList<>();
        for (TbItemCat tbItemCat : tbItemParamCatByParentIdResult) {
            TbItemCatOv ov = new TbItemCatOv();
            BeanUtils.copyProperties(tbItemCat, ov);
            ovLists.add(ov);
        }

        return BaizhanResult.ok(ovLists);
    }
}
