package com.bjsxt.controller;

import com.bjsxt.TbItemParamAPI;
import com.bjsxt.commons.pojo.BaizhanResult;
import com.bjsxt.pojo.TbItemParam;
import com.bjsxt.service.TbItemParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TbItemController {
    /**
     * 查询所有商品参数
     * 访问的数据库表格：
     * @return "status": 200,
     * 	"msg": "OK",
     * 	"data": [{
     * 		"id": 1,
     * 		"itemCatId": 3,
     * 		"paramData": "[{\"group\":\"组名1\",\"params\":[\"组员1\",\"组员2\"]}]",
     * 		"created": "2015-04-03 02:21:22",
     * 		"updated": "2015-04-03 02:21:22"
     *        }]
     *   失败
     *         status 400
     */
    @Autowired
    private TbItemParamService tbItemParamService;

    @RequestMapping("/backend/itemParam/deleteItemParamById")
    public BaizhanResult deleteItemParamById(Long id){
        log.info("后台商品子系统，删除规格参数");
        BaizhanResult baizhanResult = tbItemParamService.deleteItemParamById(id);
        return baizhanResult;
    }

    @RequestMapping("/backend/itemParam/insertItemParam")
    public BaizhanResult insertItemParamByCatId(Long itemCatId,String paramData){
        log.info("后台商品子系统，添加规格参数");
        BaizhanResult baizhanResult = tbItemParamService.insertItemParamByCatId(itemCatId, paramData);
        return baizhanResult;
    }
    @RequestMapping("/backend/itemParam/selectHaveParam")
    public BaizhanResult selectHaveParam(Long itemCatId) throws Exception {
        return tbItemParamService.getTbitemParam(itemCatId);
    }

    @RequestMapping("/backend/itemParam/selectItemParamAll")
    public BaizhanResult selTbitemParamAll(){
        log.info("后台商品子系统,规格参数查询");
        BaizhanResult baizhanResult = tbItemParamService.selTbItemParamAll();


        return baizhanResult;
    }
}
