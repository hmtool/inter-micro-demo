package tech.mhuang.interchan.logger.event;

import org.springframework.context.ApplicationEvent;
import tech.mhuang.interchan.logger.entity.ESAsyncLogger;

/**
 * 日志事件..
 *
 * @author mhuang
 * @since 1.0.0
 */
public class ApiLoggerEvent extends ApplicationEvent {

    /**
     * 重构日志事件、必须为map
     *
     * @param source 传递的日志值
     */
    public ApiLoggerEvent(ESAsyncLogger source) {
        super(source);
    }
}
