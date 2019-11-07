package tech.mhuang.interchan;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tech.mhuang.interchan.block.CustomUrlBlockHandler;

/**
 * @ClassName: SSOApplication
 * @Description:sso启动程序
 * @author: mhuang
 * @date: 2017年10月27日 下午5:08:08
 */
@EnableDiscoveryClient
@RefreshScope
@SpringBootApplication
public class MicroSSOApplication {

    public static void main(String[] args) {
        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
        SpringApplication.run(MicroSSOApplication.class, args);
    }
}