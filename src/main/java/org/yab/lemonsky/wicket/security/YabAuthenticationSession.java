package org.yab.lemonsky.wicket.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yab.lemonsky.repository.AuthRepository;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */

public class YabAuthenticationSession extends AuthenticatedWebSession {

    @SpringBean(name = "authRepository")
    AuthRepository authRepository;

    String username;

    public YabAuthenticationSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    @Override
    protected boolean authenticate(String username, String password) {
        boolean isAuthenticated = authRepository.yabSignIn(username, password);
        if (isAuthenticated) {
            this.username = username;
        }
        return isAuthenticated;
    }

    @Override
    public Roles getRoles() {
        return null;
    }
}
