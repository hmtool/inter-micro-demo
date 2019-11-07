package tech.mhuang.interchan.sso.sysfun.entity;

import java.io.Serializable;
import java.util.Date;

import tech.mhuang.ext.interchan.core.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysFunRecord extends BaseEntity implements Serializable {
    /**
     * 功能代号
     */
    private String funid;

    /**
     * 排序
     */
    private String seqno;

    /**
     * 排序
     */
    private Integer orderval;

    /**
     * 当前层
     */
    private Integer layid;

    /**
     * 功能名称
     */
    private String fundesc;

    /**
     * 对应页面路径
     */
    private String funpath;

    /**
     * 父功能代号
     */
    private String parentid;

    /**
     * 是否是底层权限[0=否/1=是(default)]
     */
    private String botflag;

    /**
     * 是否在使用[0=否/1=是(default)]
     */
    private String useflag;

    /**
     * 是否展示【0：否/1：是】
     */
    private String displayfun;

    /**
     * 操作者
     */
    private String operateUser;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**   
     * 附件id
     */   
    private String attachid;
    /**
     * sy_chanmgfunh
     */
    private static final long serialVersionUID = 1L;
}