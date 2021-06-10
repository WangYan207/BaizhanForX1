package com.bjsxt.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjsxt.TbItemParamAPI;
import com.bjsxt.commons.exception.DaoException;
import com.bjsxt.mapper.TbItemParamMapper;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.utils.IDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@DubboService
@Slf4j
public class TbItemParamAPIImpl implements TbItemParamAPI {
    /**
     * 后台查询查询外部查询接口实现,查询所有商品种类
     * @return
     */
    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public int deleteItemParamById(Long id) {
        try {
            int deleteResult = tbItemParamMapper.deleteById(id);
            if(deleteResult != 1){
                throw new DaoException("插入失败。事务回滚");
            }
            return deleteResult;
        }catch (DaoException e){
            throw new DaoException("删除失败");
        }
    }

    @Override
    public int insertItemParamByCatId(Long itemCatId, String paramData) {
        try{
            TbItemParam tbItemParam = new TbItemParam();

            tbItemParam.setId(IDUtils.genItemId());
            tbItemParam.setUpdated(new Date());
            tbItemParam.setCreated(new Date());
            tbItemParam.setItemCatId(itemCatId);
            tbItemParam.setParamData(paramData);

            int insertResult = tbItemParamMapper.insert(tbItemParam);

            if(insertResult != 1){
                throw new DaoException("插入失败");
            }
            return 1;

        }catch (DaoException e){
            log.info(e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public TbItemParam getItemParam(Long itemCatId) {
        try {
            QueryWrapper<TbItemParam> qw = new QueryWrapper();
            qw.eq("item_cat_id", itemCatId);
            TbItemParam tbItemParam = tbItemParamMapper.selectOne(qw);
            return tbItemParam;
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List<TbItemParam> selTbItemParamAll() {
        try{
            QueryWrapper<TbItemParam> qw = new QueryWrapper();
            List<TbItemParam> resultList = tbItemParamMapper.selectList(qw);
            return resultList;


        }catch (Exception e){
            log.info("查询所有规格参数-数据库连接异常");
            throw new DaoException("查询所有规格参数-数据库连接异常");
        }

    }
}
