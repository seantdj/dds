package com.sean.dds.demo.service.impl;

import com.sean.dds.demo.entity.ArticleInfo;
import com.sean.dds.demo.mapper.ArticleInfoMapper;
import com.sean.dds.demo.service.IArticleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物品表 服务实现类
 * </p>
 *
 * @author tengdongjie(sean)
 * @since 2020-02-28
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

}
