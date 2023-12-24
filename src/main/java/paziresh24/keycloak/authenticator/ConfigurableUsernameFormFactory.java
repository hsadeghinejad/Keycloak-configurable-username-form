package paziresh24.keycloak.authenticator;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.authentication.AuthenticatorSpi;

// Other necessary imports...

public class ConfigurableUsernameFormFactory implements AuthenticatorFactory {

    @Override
    public String getId() {
        return "configurable-username-form";
    }

    @Override
    public String getDisplayType() {
        return "Configurable Username Form";
    }

    // Implement other methods from AuthenticatorFactory...
    
    @Override
    public Authenticator create(KeycloakSession session) {
        return new ConfigurableUsernameForm();
    }

    @Override
    public void init(org.keycloak.Config.Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    // Implement methods for configuration, if necessary...
}
