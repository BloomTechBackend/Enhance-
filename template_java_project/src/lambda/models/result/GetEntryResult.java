package lambda.models.result;

import java.net.URL;

public class GetEntryResult {
    private URL entryUrl;

    private GetEntryResult(Builder builder) {
        setEntryUrl(builder.entryUrl);
    }

    public URL getEntryUrl() {
        return entryUrl;
    }

    public void setEntryUrl(URL entryUrl) {
        this.entryUrl = entryUrl;
    }


    public static final class Builder {
        private URL entryUrl;

        public Builder() {
        }

        public Builder entryUrl(URL val) {
            entryUrl = val;
            return this;
        }

        public GetEntryResult build() {
            return new GetEntryResult(this);
        }
    }
}
