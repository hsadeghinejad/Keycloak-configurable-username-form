package paziresh24.keycloak.authenticator;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.authentication.AuthenticatorSpi;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.authentication.AuthenticatorFactory.Requirement;

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

    @Override
    public boolean isUserSetupAllowed() {
        return true; // or false, based on your logic
    }

    @Override
    public Requirement[] getRequirementChoices() {
        return new Requirement[] {
            Requirement.REQUIRED,
            Requirement.OPTIONAL,
            Requirement.CONDITIONAL,
            // Include other applicable requirements
        };
    }

    @Override
    public boolean isConfigurable() {
        return true; // Return true if it is configurable, false otherwise
    }    
}
