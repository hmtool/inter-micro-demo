package tech.mhuang.interchan.protocol.sso;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @ClassName: UserHead
 * @Description:用户头像
 * @author: mhuang
 * @date: 2017年7月27日 下午4:50:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserHead {

    @Getter(onMethod_ = {@ApiModelProperty(hidden = true)})
    private String userId;

    @Getter(onMethod_ = {@ApiModelProperty(value = "用户头像Id", required = true)})
    private String attachId;
}
