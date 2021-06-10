package com.bjsxt;

import com.bjsxt.pojo.TbItemCat;
import com.bjsxt.pojo.TbItemParam;

import java.util.List;

/**
 * 外后台管理物品,规格参数查询对外接口
 */
public interface TbItemParamAPI {
    TbItemParam getItemParam(Long itemCatId);
    List<TbItemParam> selTbItemParamAll();
    int insertItemParamByCatId(Long itemCatId,String paramData);
    int deleteItemParamById(Long id);

}
