package lambda.models.request;

import java.io.File;
import java.util.Objects;

public class CreateEntryRequest {
    private String userId;
    private String date;
    private File entry;

    public CreateEntryRequest() {

    }

    private CreateEntryRequest(Builder builder) {
        setUserId(builder.userId);
        setDate(builder.date);
        setEntry(builder.entry);
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

    public File getEntry() {
        return entry;
    }

    public void setEntry(File entry) {
        this.entry = entry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateEntryRequest that = (CreateEntryRequest) o;
        return  Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getEntry(), that.getEntry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getDate(), getEntry());
    }

    @Override
    public String toString() {
        return "CreateEntryRequest{" +
                "userId='" + userId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public static final class Builder {
        private String userId;
        private String date;
        private File entry;

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

        public Builder entry(File val) {
            entry = val;
            return this;
        }

        public CreateEntryRequest build() {
            return new CreateEntryRequest(this);
        }
    }
}
