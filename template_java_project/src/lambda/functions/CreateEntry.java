package lambda.functions;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import converters.ModelConverter;
import dynamoDB.JournalEntryDao;
import dynamoDB.models.JournalEntry;
import lambda.models.request.CreateEntryRequest;
import lambda.models.result.CreateEntryResult;

import javax.inject.Inject;
import java.io.File;

public class CreateEntry implements RequestHandler<CreateEntryRequest, CreateEntryResult> {
    private JournalEntryDao journalEntryDao;

    @Inject
    public CreateEntry(JournalEntryDao journalEntryDao, DynamoDBMapper dynamoDBMapper) {
        this.journalEntryDao = journalEntryDao;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input  The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateEntryResult handleRequest(CreateEntryRequest input, Context context) {

        String userId = input.getUserId();
        String date = input.getDate();
        File entry = input.getEntry();

        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setUserId(userId);
        journalEntry.setDate(date);
        journalEntry.setEntry(journalEntryDao.createLink(journalEntry));
        journalEntry.getEntry().uploadFrom(entry);

        journalEntryDao.saveJournalEntry(journalEntry);

        return new CreateEntryResult.Builder()
                .journalEntry(new ModelConverter().toJournalEntryModel(journalEntry))
                .build();
    }
}
