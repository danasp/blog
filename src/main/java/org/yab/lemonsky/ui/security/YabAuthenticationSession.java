package org.yab.lemonsky.ui.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.yab.lemonsky.models.entities.Account;
import org.yab.lemonsky.repository.AuthRepository;

import java.util.Optional;
import java.util.Set;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */

public class YabAuthenticationSession extends AuthenticatedWebSession {

    @SpringBean(name = "authRepository")
    AuthRepository authRepository;

    private String username;
    private Account account;
    private Roles roles;

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
        Roles roles = new Roles();
        if (username != null) {
            Optional<Account> accountOpt = authRepository.getByUserName(username);
            if (accountOpt.isPresent()) {
                Set<String> accountRoles = accountOpt.get().getRoles();
                accountRoles.forEach(roles::add);
            }
        }

        this.roles = roles;
        return roles;
    }

    @Override
    public void signOut() {
        super.signOut();
        this.username = null;
        this.roles = null;
    }

    public Account getAccount() {
        Optional<Account> accountOpt;
        if (account == null) {
            accountOpt = authRepository.getByUserName(username);
            if (accountOpt.isPresent()) {
                this.account = accountOpt.get();
            }
        }
        return this.account;
    }
}
