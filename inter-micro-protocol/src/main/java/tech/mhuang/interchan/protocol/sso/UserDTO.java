package tech.mhuang.interchan.protocol.sso;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @ClassName: LockUserDTO
 * @Description:多顶/解锁用户
 * @author: mhuang
 * @date: 2017年7月23日 上午11:24:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO {

    /**
     * 用户id
     */
    @Getter(onMethod_ = {@ApiModelProperty(value = "用户id", required = true)})
    private String userid;

    /**
     * 操作的用户id
     */
    @Getter(onMethod_ = {@ApiModelProperty(value = "操作用户id", hidden = true)})
    private String operateUser;

}
