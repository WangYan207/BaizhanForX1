package com.bjsxt.service.impl;

import com.bjsxt.TbItemParamAPI;
import com.bjsxt.commons.exception.DaoException;
import com.bjsxt.commons.pojo.BaizhanResult;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.service.TbItemParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class TbItemParamServiceImpl implements TbItemParamService {
    @Autowired
    private TbItemParamAPI tbItemParamAPI;

    @Override
    public BaizhanResult deleteItemParamById(Long id) {
        try {
            int i = tbItemParamAPI.deleteItemParamById(id);
            if(i!=1){
                throw new DaoException("删除失败");
            }
            return BaizhanResult.ok();
        }catch (DaoException e){
            throw new DaoException("插入失败");
        }
    }

    @Override
    public BaizhanResult insertItemParamByCatId(Long itemCatId, String paramData) {
        try {
            int i = tbItemParamAPI.insertItemParamByCatId(itemCatId, paramData);
            if (i == 1) {
                return BaizhanResult.ok();
            }else{
                throw new DaoException("出错了，快解决一下");
            }
        }catch (DaoException e){
            return BaizhanResult.error("不知道除了啥问题，再查一次吧");
        }
    }

    @Override
    public BaizhanResult getTbitemParam(Long itemCatId) throws Exception {
        try {
            TbItemParam itemParam = tbItemParamAPI.getItemParam(itemCatId);
            if(itemParam == null){
                return BaizhanResult.ok();
            }
            return BaizhanResult.error("查询有问题,重来！");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public BaizhanResult selTbItemParamAll() {
        try {
            List<TbItemParam> result = tbItemParamAPI.selTbItemParamAll();

            return BaizhanResult.ok(result);
        }catch (DaoException e){
            log.error("com.bjsxt.service.TbItemParamService#selTbItemParamAll"+e.getMessage());
            return BaizhanResult.error(e.getMessage());
        }
    }
}
