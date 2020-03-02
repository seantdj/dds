package com.sean.dds.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 物品表
 * </p>
 *
 * @author tengdongjie(sean)
 * @since 2020-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("article_info")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品/物料编码
     */
    @TableField("sku_no")
    private String skuNo;

    /**
     * 物品类型 0商品 1物料
     */
    @TableField("article_type")
    private Boolean articleType;

    /**
     * 品牌ID
     */
    @TableField("article_brand")
    private Long articleBrand;

    /**
     * 商品名称
     */
    @TableField("article_name")
    private String articleName;

    /**
     * 图片ID basic 库中document 表ID
     */
    @TableField("article_img_id")
    private Long articleImgId;

    /**
     * 图片URL
     */
    @TableField("article_img_url")
    private String articleImgUrl;

    /**
     * 单位ID
     */
    @TableField("unit_id")
    private Long unitId;

    /**
     * 规格
     */
    @TableField("spec")
    private Integer spec;

    /**
     * 净含量
     */
    @TableField("net_weight")
    private Integer netWeight;

    /**
     * 净含量单位ID（g/kg/ml）
     */
    @TableField("net_weight_unit")
    private Long netWeightUnit;

    /**
     * 长度 单位MM
     */
    @TableField("spec_length")
    private Integer specLength;

    /**
     * 高度 单位MM
     */
    @TableField("spec_height")
    private Integer specHeight;

    /**
     * 宽度 单位MM
     */
    @TableField("spec_width")
    private Integer specWidth;

    /**
     * 商品类目ID
     */
    @TableField("category_id")
    private Long categoryId;

    /**
     * 保质期
     */
    @TableField("safe_date")
    private Integer safeDate;

    /**
     * 1 日 2月 3年
     */
    @TableField("safe_date_unit")
    private Integer safeDateUnit;

    /**
     * 0 待审核 1 审核通过
     */
    @TableField("status")
    private Integer status;

    /**
     * Y 上架 N 下架
     */
    @TableField("on_sale")
    private String onSale;

    /**
     * 删除flag
     */
    @TableField("del_flg")
    private String delFlg;

    /**
     * 创建人
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 更新人
     */
    @TableField("update_by")
    private Long updateBy;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新日期
     */
    @TableField("update_time")
    private Date updateTime;


}
