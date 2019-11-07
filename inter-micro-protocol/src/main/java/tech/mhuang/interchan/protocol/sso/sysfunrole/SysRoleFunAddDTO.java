package tech.mhuang.interchan.protocol.sso.sysfunrole;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleFunAddDTO  implements Serializable {
    /**
     * 功能代号
     */
    private String funid;

    /**
     *  角色代码
     */
    private String roleid;

    
    private static final long serialVersionUID = 1L;
}