package com.bjsxt.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjsxt.TbItemParamCatServiceAPI;
import com.bjsxt.mapper.TbItemCatMapper;
import com.bjsxt.ov.TbItemCatOv;
import com.bjsxt.pojo.TbItemCat;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DubboService
public class TbItemParamCatAPIImpl implements TbItemParamCatServiceAPI {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TbItemCat> getTbItemParamCatByParentId(Long parentId) {


        QueryWrapper<TbItemCat> qw = new QueryWrapper<>();
        qw.eq("parent_id", parentId);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectList(qw);



        return tbItemCats;
    }
}
