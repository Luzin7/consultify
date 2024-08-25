package com.luanvictor.Consultify.config;

import com.luanvictor.Consultify.providers.decorators.authToken.AuthTokenArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AuthTokenArgumentResolver authTokenArgumentResolver;

    public WebConfig(AuthTokenArgumentResolver authTokenArgumentResolver) {
        this.authTokenArgumentResolver = authTokenArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authTokenArgumentResolver);
    }
}
