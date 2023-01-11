package lambda.models.result;

import lambda.models.UserModel;

public class CreateUserResult {
    private UserModel user;

    private CreateUserResult(Builder builder) {
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

        public CreateUserResult build() {
            return new CreateUserResult(this);
        }
    }
}
