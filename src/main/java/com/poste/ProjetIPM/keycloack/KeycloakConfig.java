package com.poste.ProjetIPM.keycloack;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {
    static Keycloak keycloak = null;
    final static String serverUrl = "http://localhost:8180/auth";
    //final static String serverUrl = "http://localhost:9191/auth";
    public final static String realm= "IPM-Front";
    final static String clientId = "Backend-ipm";
    //final static String clientId = "BackEnd_ModulePrincipal_local";
    //final static String clientSecret = "fcf71237-2d9a-484f-9206-8aa939e1941d";
    final static String clientSecret = "5f108389-4316-4415-b658-e1b218f6d1c4";
    final static String userName = "charles";
    final static String password = "Charles14";

    public KeycloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                    )
                    .build();
        }
        return keycloak;
    }
}
