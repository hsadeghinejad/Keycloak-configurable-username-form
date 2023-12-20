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

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        // Implementation here. If you don't need to set any required actions, you can leave this empty.
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        // Example implementation. Adjust according to your needs.
        // Return true if the user is configured for this authenticator, otherwise return false.
        return true; // or false, depending on your logic
    }
    
    @Override
	public boolean requiresUser() {
		return true;
	}
}
