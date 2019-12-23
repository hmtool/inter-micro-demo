
package tech.mhuang.interchan.protocol.global.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.mhuang.ext.interchan.protocol.InsertInto;

/**
 * @ClassName: InsertIntoExt
 * @author: admin
 * @date: 2018年3月27日 上午11:18:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InsertIntoExt<ID> extends InsertInto<ID> {
    private static final long serialVersionUID = 1L;
    private String source;
}
