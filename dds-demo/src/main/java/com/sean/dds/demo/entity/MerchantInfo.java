package com.sean.dds.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 运营商表
 * </p>
 *
 * @author tengdongjie(sean)
 * @since 2020-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("merchant_info")
public class MerchantInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司编号
     */
    @TableId("merchant_id")
    private Long merchantId;

    /**
     * 父级ID
     */
    @TableField("pid")
    private Long pid;

    /**
     * 祖先ID
     */
    @TableField("ancestor_id")
    private Long ancestorId;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 地址省

     */
    @TableField("province")
    private String province;

    /**
     * 地址市
     */
    @TableField("city")
    private String city;

    /**
     * 地址区
     */
    @TableField("district")
    private String district;

    /**
     * 街道
     */
    @TableField("street")
    private String street;

    /**
     * 地址详细
     */
    @TableField("address")
    private String address;

    /**
     * 联系人
     */
    @TableField("concat_person")
    private String concatPerson;

    /**
     * 联系人手机号
     */
    @TableField("concat_phone")
    private String concatPhone;

    /**
     * 删除flag Y:删除
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
