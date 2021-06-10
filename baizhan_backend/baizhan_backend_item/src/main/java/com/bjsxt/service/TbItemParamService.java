package com.bjsxt.service;

import com.bjsxt.commons.pojo.BaizhanResult;

public interface TbItemParamService {
    /**
     * 查询所有规格参数
     * @return
     */
    BaizhanResult getTbitemParam(Long itemCatId) throws Exception;
    BaizhanResult selTbItemParamAll();
    BaizhanResult insertItemParamByCatId(Long itemCatId,String paramData);
    BaizhanResult deleteItemParamById(Long id);
}
