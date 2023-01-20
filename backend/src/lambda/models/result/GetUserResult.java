package lambda.models.result;

public class GetUserResult {
    private String userId;

    private GetUserResult(GetUserResult.Builder builder) {
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

        public GetUserResult.Builder userId(String val) {
            userId = val;
            return this;
        }

        public GetUserResult build() {
            return new GetUserResult(this);
        }
    }
}
