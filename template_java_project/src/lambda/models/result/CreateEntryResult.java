package lambda.models.result;

import lambda.models.JournalEntryModel;

public class CreateEntryResult {
    private JournalEntryModel journalEntry;

    private CreateEntryResult(Builder builder) {
        setJournalEntry(builder.journalEntry);
    }

    public JournalEntryModel getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntryModel journalEntry) {
        this.journalEntry = journalEntry;
    }


    public static final class Builder {
        private JournalEntryModel journalEntry;

        public Builder() {
        }

        public Builder journalEntry(JournalEntryModel val) {
            journalEntry = val;
            return this;
        }

        public CreateEntryResult build() {
            return new CreateEntryResult(this);
        }
    }
}
