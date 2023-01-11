package lambda.models.request;

import java.util.Objects;

public class GetEntryRequest {
    private String userId;
    private String date;


    public GetEntryRequest() {

    }

    private GetEntryRequest(Builder builder) {
        setUserId(builder.userId);
        setDate(builder.date);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetEntryRequest that = (GetEntryRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getDate());
    }

    @Override
    public String toString() {
        return "GetEntryRequest{" +
                "userId='" + userId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public static final class Builder {
        private String userId;
        private String date;

        public Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public GetEntryRequest build() {
            return new GetEntryRequest(this);
        }
    }
}
