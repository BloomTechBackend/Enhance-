package dynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.models.JournalEntry;
import exceptions.EntryNotFoundException;

import javax.inject.Inject;

public class JournalEntryDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public JournalEntryDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public JournalEntry getJournalEntry(String userId, String date) {
        JournalEntry journalEntry = dynamoDBMapper.load(JournalEntry.class, userId, date);

        if (journalEntry == null)
            throw new EntryNotFoundException("Could not find journal entry with date " + date);

        return journalEntry;
    }

    public JournalEntry saveJournalEntry(JournalEntry journalEntry) {
        dynamoDBMapper.save(journalEntry);
        return journalEntry;
    }
}
