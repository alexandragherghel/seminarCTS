package ro.ase.cts.after;

import ro.ase.cts.after.contracts.RestApi;

public class RestApiDevelopment implements RestApi {
    public RestApiDevelopment() {
        System.out.println("ApiDevelopment");
    }
    @Override
    public void connect() {
        System.out.println("Connected successfully");
    }
}
