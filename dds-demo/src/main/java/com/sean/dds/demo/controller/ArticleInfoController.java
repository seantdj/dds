package com.sean.dds.demo.controller;


import com.sean.dds.annotation.DS;
import com.sean.dds.demo.entity.ArticleInfo;
import com.sean.dds.demo.service.IArticleInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物品表 前端控制器
 * </p>
 *
 * @author tengdongjie(sean)
 * @since 2020-02-28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/articleInfo")
public class ArticleInfoController {

    final private IArticleInfoService articleInfoService;

    @DS("db1")
    @RequestMapping("/{id}")
    public ArticleInfo articleInfo(@PathVariable("id") Long id){
        return articleInfoService.getById(id);
    }

}
