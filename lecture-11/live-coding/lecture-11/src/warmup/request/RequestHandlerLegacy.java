package warmup.request;

public class RequestHandlerLegacy {
    public void handleRequest(Object requestBody) {
        // Must guess and cast manually
        UserLegacy user = (UserLegacy) requestBody;  // Dangerous cast
        System.out.println("Handling user: " + user.getEmail());
    }

    public static void main(String[] args) {
        RequestHandlerLegacy handler = new RequestHandlerLegacy();

        // Works fine
        handler.handleRequest(new UserLegacy("me@example.com"));

        // Runtime explosion – ClassCastException
        handler.handleRequest("This is not a User");
    }
}

class UserLegacy {
    private String email;

    public UserLegacy(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
