package lambda.models.request;

import java.util.Objects;

public class GetUserRequest {
    private String userId;

    public GetUserRequest() {

    }

    private GetUserRequest(Builder builder) {
        setUserId(builder.userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserRequest that = (GetUserRequest) o;
        return Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }

    public static final class Builder {
        private String userId;

        public Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public GetUserRequest build() {
            return new GetUserRequest(this);
        }
    }
}
