package lambda.models.result;

public class GetEntryResult {
    private String entry;

    private GetEntryResult(Builder builder) {
        setEntry(builder.entry);
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }


    public static final class Builder {
        private String entry;

        public Builder() {
        }

        public Builder entry(String val) {
            entry = val;
            return this;
        }

        public GetEntryResult build() {
            return new GetEntryResult(this);
        }
    }
}
