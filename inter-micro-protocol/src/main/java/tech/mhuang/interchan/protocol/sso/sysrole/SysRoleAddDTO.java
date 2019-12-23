package tech.mhuang.interchan.protocol.sso.sysrole;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleAddDTO implements Serializable {
    /**
     * 角色代号
     */
    private String roleid;

    /**
     * 角色名称
     */
    private String roledesc;

    /**
     * sy_chanmgrolem
     */
    private static final long serialVersionUID = 1L;
}