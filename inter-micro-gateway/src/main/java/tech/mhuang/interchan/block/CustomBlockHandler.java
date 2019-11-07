package tech.mhuang.interchan.block;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import tech.mhuang.ext.interchan.protocol.Result;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @package: tech.mhuang.interchan.block
 * @author: mhuang
 * @Date: 2019/10/29 15:56
 * @Description:
 */
public class CustomBlockHandler implements BlockRequestHandler {

    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {

        Result result = new Result();
        result.setExceptionMsg(t);
        result.setCode(600);
        result.setMessage("服务暂不可用..请稍后再试！！");

        // JSON result by default.
        return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(fromObject(result));
    }
}