package org.yab.lemonsky.ui.security;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;

/**
 * User: Danila Vereshchakov
 * Date: 10.12.2016
 */
public class RoleChecker {
    public static <T extends Roles> boolean isAdmin(T roles) {
        return roles.hasRole(T.ADMIN);
    }

    public static <T extends Roles> boolean isUser(T roles) {
        return roles.hasRole(T.USER);
    }
}
