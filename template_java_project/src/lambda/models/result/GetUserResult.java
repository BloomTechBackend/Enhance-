package lambda.models.result;

import lambda.models.UserModel;

public class GetUserResult {
    private UserModel user;

    private GetUserResult(Builder builder) {
        setUser(builder.user);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public static final class Builder {
        private UserModel user;

        public Builder() {
        }

        public Builder user(UserModel val) {
            user = val;
            return this;
        }

        public GetUserResult build() {
            return new GetUserResult(this);
        }
    }
}
