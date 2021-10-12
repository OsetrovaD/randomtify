package com.osetrova.app.randomtify.configuration;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientCredentialsReactiveOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;

@Configuration
public class SpotifyWebClientConfiguration {

    @Bean
    public WebClientCustomizer oauth2WebClientCustomizer(ReactiveOAuth2AuthorizedClientManager reactiveOAuth2AuthorizedClientManager) {
        ServerOAuth2AuthorizedClientExchangeFilterFunction oAuth2AuthorizedClientExchangeFilterFunction =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(reactiveOAuth2AuthorizedClientManager);
        oAuth2AuthorizedClientExchangeFilterFunction.setDefaultClientRegistrationId("spotify");

        return webClientBuilder -> webClientBuilder.filter(oAuth2AuthorizedClientExchangeFilterFunction);
    }

    @Bean
    public ReactiveOAuth2AuthorizedClientManager reactiveOAuth2AuthorizedClientManager(
            ReactiveClientRegistrationRepository registrationRepository, ReactiveOAuth2AuthorizedClientService authorizedClientService) {
        AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(registrationRepository, authorizedClientService);

        authorizedClientManager.setAuthorizedClientProvider(new ClientCredentialsReactiveOAuth2AuthorizedClientProvider());
        return authorizedClientManager;
    }
}
