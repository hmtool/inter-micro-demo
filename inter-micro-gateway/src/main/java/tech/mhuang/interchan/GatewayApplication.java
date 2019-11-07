package tech.mhuang.interchan;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tech.mhuang.interchan.block.CustomBlockHandler;

/**
 * @package: tech.mhuang.interchan
 * @author: mhuang
 * @Date: 2018/12/20 14:16
 * @Description:
 */
@EnableDiscoveryClient
@RefreshScope
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        GatewayCallbackManager.setBlockHandler(new CustomBlockHandler());
        SpringApplication.run(GatewayApplication.class, args);
    }
}
