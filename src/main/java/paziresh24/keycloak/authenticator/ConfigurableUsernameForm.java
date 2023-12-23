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
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import org.keycloak.authentication.AuthenticationFlowError;

public class ConfigurableUsernameForm implements Authenticator {

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
    
        // Check if the username is provided
        if (formData.containsKey("username")) {
            String username = formData.getFirst("username");
            KeycloakSession session = context.getSession();
            RealmModel realm = context.getRealm();
    
            // Check if user already exists
            UserModel existingUser = session.users().getUserByUsername(realm, username);
            if (existingUser != null) {
                // User already exists, proceed to next step
                context.setUser(existingUser);
                context.success();
            } else {
                // User doesn't exist, create a new one
                UserModel newUser = session.users().addUser(realm, username);
                newUser.setEnabled(true);
                // You can set additional attributes here if needed
    
                // Display a message to the user
                Response challengeResponse = context.form()
                        .setInfo("User registered successfully with username: " + username)
                        .createForm("info-page.ftl");
                context.challenge(challengeResponse);

                context.setUser(newUser);
                context.success();
            }
        } else {
            // Username not provided in the request, handle this case
            Response challengeResponse = context.form()
                    .setError("Username is required")
                    .createForm("error-page.ftl");
            context.failureChallenge(AuthenticationFlowError.INVALID_USER, challengeResponse);
        }
    }    

    @Override
    public void action(AuthenticationFlowContext context) {
        // Your implementation here.
        // If you have no specific action to perform, you can leave it empty.
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
