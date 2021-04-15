package ro.ase.acs.proxy;

public class AuthenticationProxy implements Authentication {

    private Authentication authentication = null;
    private int failedAuthentication = 0;

    public AuthenticationProxy(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean login(String username, String password) throws SecurityAuthenticationException {
        if(failedAuthentication > 2) {
            throw new SecurityAuthenticationException("Too many bad logins");
        }

        if(authentication.login(username, password)) {
            failedAuthentication = 0;
            return true;
        } else {
            failedAuthentication++;
            return false;
        }
    }
}
