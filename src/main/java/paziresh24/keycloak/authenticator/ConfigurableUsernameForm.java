package paziresh24.keycloak.autheticator;

import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.Collections;
import java.util.List;

public class ConfigurableUsernameForm implements Authenticator {

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        // Your authentication logic
    }

    @Override
    public void close() {
        // Cleanup, if needed
    }

    // Implement other methods from Authenticator interface
}
