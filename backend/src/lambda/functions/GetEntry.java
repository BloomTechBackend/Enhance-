package lambda.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.JournalEntryDao;
import dynamoDB.models.JournalEntry;
import exceptions.EntryNotFoundException;
import lambda.models.request.GetEntryRequest;
import lambda.models.result.GetEntryResult;

import javax.inject.Inject;

public class GetEntry implements RequestHandler<GetEntryRequest, GetEntryResult> {
    private JournalEntryDao journalEntryDao;

    @Inject
    public GetEntry(JournalEntryDao journalEntryDao) {
        this.journalEntryDao = journalEntryDao;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public GetEntryResult handleRequest(GetEntryRequest input, Context context) {

        String userId = input.getUserId();
        String date = input.getDate();

        JournalEntry journalEntry = journalEntryDao.getJournalEntry(userId, date);

        if (journalEntry == null) {
            throw new EntryNotFoundException("entry not found with provided userId/date combination");
        }

        return new GetEntryResult.Builder()
                .entry(journalEntry.getEntry())
                .build();
    }
}
