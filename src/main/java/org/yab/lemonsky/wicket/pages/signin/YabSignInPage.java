package org.yab.lemonsky.wicket.pages.signin;

import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * User: Danila Vereshchakov
 * Date: 15.11.2016
 */
@MountPath(value = "login")
public class YabSignInPage extends SignInPage {

    public YabSignInPage() {
    }

    public YabSignInPage(PageParameters parameters) {
        super(parameters);
    }
}
