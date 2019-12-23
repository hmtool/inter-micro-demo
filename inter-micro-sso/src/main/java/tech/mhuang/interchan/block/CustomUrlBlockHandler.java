package tech.mhuang.interchan.block;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import tech.mhuang.ext.interchan.protocol.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义限流异常处理
 *
 * @author mhuang
 * @since 1.0.0
 */
@Slf4j
public class CustomUrlBlockHandler implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
        Result result = new Result();
        result.setExceptionMsg(ex);
        result.setCode(600);
        result.setMessage("服务暂不可用..请稍后再试！！");
        response.setContentType("text/json; charset=utf-8");
        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        response.getWriter().write(JSON.toJSONString(result));
    }
}
