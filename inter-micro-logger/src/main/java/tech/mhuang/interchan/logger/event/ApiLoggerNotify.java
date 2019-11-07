package tech.mhuang.interchan.logger.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import tech.mhuang.interchan.logger.entity.ESAsyncLogger;

/**
 *
 * 日志通知
 *
 * @author mhuang
 * @since 1.0.0
 */
@Component
public class ApiLoggerNotify {

    @Autowired
    private ApplicationContext applicationContext;

    public void notify(ESAsyncLogger param){
        applicationContext.publishEvent(new ApiLoggerEvent(param));
    }
}
