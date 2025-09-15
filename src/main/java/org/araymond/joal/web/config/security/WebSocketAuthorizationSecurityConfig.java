package org.araymond.joal.web.config.security;

import org.araymond.joal.web.annotations.ConditionalOnWebUi;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

/**
 * Created by raymo on 22/06/2017.
 */
@ConditionalOnWebUi
@Configuration
public class WebSocketAuthorizationSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(final MessageSecurityMetadataSourceRegistry messages) {
        messages.anyMessage().authenticated();
    }

    // TODO : Add CSRF token support: https://docs.spring.io/spring-security/site/docs/current/reference/html/websocket.html#websocket-sameorigin-csrf
    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }
}
