package com.demo.fe.config;

import com.demo.fe.exception.ThrowingConsumer;
import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.LoggingCodecSupport;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

/**
 *
 * Stream 코드에서 Exception 처리를 위한 Util
 *
 * ref
 * https://github.com/Odysseymoon/spring-webflux-template/blob/master/src/main/java/moon/odyssey/webflux/utils/lambda/ThrowingConsumer.java
 */

@Configuration
@Slf4j
public class WebClientConfig {

    @Value("${custom.api.url.demo-api}")
    String demoApiUrl;


    @Bean
    public WebClient getWebClient() {

       HttpClient httpClient = HttpClient.create()
               .tcpConfiguration(client ->
                       client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,10000)
                               .doOnConnected(conn -> conn
                                       .addHandlerLast(new ReadTimeoutHandler(10))
                                       .addHandlerLast(new WriteTimeoutHandler(10))));
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        return WebClient.builder()
                .baseUrl(demoApiUrl)
                .clientConnector(connector)
                .build();
    }
}
