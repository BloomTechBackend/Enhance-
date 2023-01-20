package lambda.models;

public class JournalEntryModel {
    private String userId;
    private String date;

    public JournalEntryModel() {

    }

    private JournalEntryModel(Builder builder) {
        userId = builder.userId;
        date = builder.date;
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

        public JournalEntryModel build() {
            return new JournalEntryModel(this);
        }
    }
}
