package com.sean.dds.demo.controller;


import com.sean.dds.annotation.DS;
import com.sean.dds.demo.entity.MerchantInfo;
import com.sean.dds.demo.service.IMerchantInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 运营商表 前端控制器
 * </p>
 *
 * @author tengdongjie(sean)
 * @since 2020-02-28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/merchantInfo")
public class MerchantInfoController {

    final private IMerchantInfoService merchantInfoService;

    @DS("db0")
    @RequestMapping("/{id}")
    public MerchantInfo merchantInfo(@PathVariable("id") Long id){
        return merchantInfoService.getById(id);
    }

}
