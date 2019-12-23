
package tech.mhuang.interchan.protocol.sso.sysuser.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.mhuang.ext.interchan.protocol.data.PageDTO;

/**
 * 用户分页查询DTO
 *
 * @ClassName: SysUserPageQryDTO
 * @author: admin
 * @date: 2018年3月23日 上午9:59:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserPageQryDTO extends PageDTO {

    private String username;

    private String mobilephone;

    private String orderUserIds;

    private String available;
}
