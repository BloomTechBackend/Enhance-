package lambda.models;

public class UserModel {
    private String userId;

    public UserModel() {

    }

    private UserModel(Builder builder) {
        userId = builder.userId;
    }

    public static final class Builder {
        private String userId;

        public Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}
