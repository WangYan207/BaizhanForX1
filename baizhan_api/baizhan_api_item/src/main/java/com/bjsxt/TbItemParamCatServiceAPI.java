package com.bjsxt;

import com.bjsxt.pojo.TbItemCat;

import java.util.List;

public interface TbItemParamCatServiceAPI {
    List<TbItemCat> getTbItemParamCatByParentId(Long parentId);
}
