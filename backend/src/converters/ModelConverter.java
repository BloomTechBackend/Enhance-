package converters;

import dynamoDB.models.JournalEntry;
import dynamoDB.models.User;
import lambda.models.JournalEntryModel;
import lambda.models.UserModel;

public class ModelConverter {
    /**
     * Converts a provided {@link JournalEntry} into a {@link JournalEntryModel} representation.
     *
     * @param journalEntry the JournalEntry to convert
     * @return the converted journalEntry
     */
    public JournalEntryModel toJournalEntryModel(JournalEntry journalEntry) {
        return new JournalEntryModel.Builder()
                .userId(journalEntry.getUserId())
                .date(journalEntry.getDate())
                .build();
    }

    public UserModel toUserModel(User user) {
        return new UserModel.Builder()
                .userId(user.getUserId())
                .build();
    }
}
