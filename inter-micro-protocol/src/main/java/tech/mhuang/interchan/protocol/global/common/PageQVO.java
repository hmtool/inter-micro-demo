
package tech.mhuang.interchan.protocol.global.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @ClassName: PageQVO
 * @author: admin
 * @date: 2018年3月27日 上午11:18:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageQVO {

    @Getter(onMethod_ = {@ApiModelProperty("开始位置")})
    private int start;

    @Getter(onMethod_ = {@ApiModelProperty("每页显示条数")})
    private int rows;
}
