package com.osetrova.app.randomtify.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientCredentialsReactiveOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.InMemoryReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class SpotifyWebClientConfiguration {

    @Bean
    public ReactiveClientRegistrationRepository clientRegistration(
            @Value("${spotify.security.token-uri}") String token_uri,
            @Value("${spotify.security.client-id}") String client_id,
            @Value("${spotify.security.client-secret}") String client_secret,
            @Value("${spotify.security.authorization-grant-type}") String authorizationGrantType
    ) {
        ClientRegistration registration = ClientRegistration
                .withRegistrationId("spotify")
                .tokenUri(token_uri)
                .clientId(client_id)
                .clientSecret(client_secret)
                .authorizationGrantType(new AuthorizationGrantType(authorizationGrantType))
                .build();
        return new InMemoryReactiveClientRegistrationRepository(registration);
    }

    @Bean
    public ReactiveOAuth2AuthorizedClientService spotifyAuthorizedClientService(ReactiveClientRegistrationRepository clientRegistration) {
        return new InMemoryReactiveOAuth2AuthorizedClientService(clientRegistration);
    }

    @Bean
    public WebClientCustomizer oauth2WebClientCustomizer(ReactiveOAuth2AuthorizedClientManager reactiveOAuth2AuthorizedClientManager) {
        ServerOAuth2AuthorizedClientExchangeFilterFunction oAuth2AuthorizedClientExchangeFilterFunction =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(reactiveOAuth2AuthorizedClientManager);
        oAuth2AuthorizedClientExchangeFilterFunction.setDefaultClientRegistrationId("spotify");

        return webClientBuilder -> webClientBuilder.filter(oAuth2AuthorizedClientExchangeFilterFunction);
    }

    @Bean
    public ReactiveOAuth2AuthorizedClientManager reactiveOAuth2AuthorizedClientManager(
            ReactiveClientRegistrationRepository clientRegistration, ReactiveOAuth2AuthorizedClientService spotifyAuthorizedClientService) {
        AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(clientRegistration, spotifyAuthorizedClientService);

        authorizedClientManager.setAuthorizedClientProvider(new ClientCredentialsReactiveOAuth2AuthorizedClientProvider());
        return authorizedClientManager;
    }
}
