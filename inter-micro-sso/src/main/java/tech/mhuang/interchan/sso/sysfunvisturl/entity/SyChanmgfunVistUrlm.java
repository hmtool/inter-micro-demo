package tech.mhuang.interchan.sso.sysfunvisturl.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
@Data
public class SyChanmgfunVistUrlm implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 可访问地址
     */
    private String url;

    /**
     * 功能代码
     */
    private String funid;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 操作者
     */
    private String operateUser;

    private static final long serialVersionUID = 1L;
}