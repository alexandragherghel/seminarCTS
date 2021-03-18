package ro.ase.cts.after;

import ro.ase.cts.after.contracts.RestApi;

public class RestApiFactory {

    public static final String DEVELOPMENT="development";
    public static final String RELEASE="release";
    public static RestApi createConnection(String serverType) {
        if(DEVELOPMENT.equals(serverType)) {
            return new RestApiDevelopment();
        } else if(RELEASE.equals(serverType)) {
            return new RestApiRelease();
        } else {
            return null;
        }
    }
}
