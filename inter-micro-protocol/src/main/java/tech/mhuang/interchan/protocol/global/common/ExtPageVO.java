
package tech.mhuang.interchan.protocol.global.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import tech.mhuang.ext.interchan.protocol.data.PageVO;

/**
 * @ClassName: PageQVO
 * @author: admin
 * @date: 2018年3月27日 上午11:18:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ExtPageVO<T> extends PageVO<T> {
    @Getter(onMethod_ = {@ApiModelProperty(value = "总页数")})
    private int total;

    @Getter(onMethod_ = {@ApiModelProperty(value = "当前页码")})
    private int page;


}
