package com.bjsxt.ov;

import com.bjsxt.commons.pojo.BaizhanResult;
import com.bjsxt.pojo.TbItemCat;

public class TbItemCatOv extends TbItemCat {
    private boolean leaf;
    public boolean getLeaf(){
        return !getIsParent();
    }

    public void setLeaf(boolean leaf){
        this.leaf = !getIsParent();
    }
}
