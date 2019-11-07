package tech.mhuang.interchan.logger.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import tech.mhuang.core.util.ObjectUtil;
import tech.mhuang.ext.elasticsearch.admin.ESFramework;
import tech.mhuang.ext.elasticsearch.admin.factory.IESFactory;
import tech.mhuang.interchan.logger.entity.ESAsyncLogger;
import tech.mhuang.interchan.logger.entity.ESAsyncLoggerOpType;

import java.io.IOException;

/**
 * 日志监听操作
 *
 * @author mhuang
 * @since 1.0.0
 */
@Slf4j
@Component
public class ApiLoggerListener {

    @Autowired
    private ESFramework esFramework;

    @Async
    @Order
    @EventListener(ApiLoggerEvent.class)
    public void proccess(ApiLoggerEvent event) throws IOException {
        Object source = event.getSource();
        if (source instanceof ESAsyncLogger) {
            ESAsyncLogger logger = (ESAsyncLogger) source;
            if (ObjectUtil.isNotEmpty(logger)) {
                IESFactory esFactory = esFramework.getFactory(logger.getName());
                if (logger.getOpType().equals(ESAsyncLoggerOpType.INSERT)) {
                    esFactory.insert(logger.getEsOperatorLogger(), logger.getIndex(), logger.getType());
                } else {
                    esFactory.update(logger.getEsOperatorLogger(), logger.getIndex(), logger.getType(),
                            logger.getEsOperatorLogger().getId());
                }
            }
        }
    }
}
