package lambda.models.result;

public class CreateUserResult {
    private String userId;

    private CreateUserResult(Builder builder) {
        setUserId(builder.userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static final class Builder {
        private String userId;

        public Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public CreateUserResult build() {
            return new CreateUserResult(this);
        }
    }
}
