package lambda.injectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependencies.AppComponent;
import dependencies.DaggerAppComponent;
import lambda.functions.CreateEntry;
import lambda.models.request.CreateEntryRequest;
import lambda.models.result.CreateEntryResult;

public class CreateEntryInjector implements RequestHandler<CreateEntryRequest, CreateEntryResult> {

    public CreateEntryInjector() {
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateEntryResult handleRequest(CreateEntryRequest input, Context context) {
        AppComponent dagger = DaggerAppComponent.create();
        CreateEntry createEntry = dagger.provideCreateEntry();
        return createEntry.handleRequest(input, context);
    }
}
