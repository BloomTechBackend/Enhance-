package lambda.injectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependencies.AppComponent;
import dependencies.DaggerAppComponent;
import lambda.functions.GetEntry;
import lambda.models.request.GetEntryRequest;
import lambda.models.result.GetEntryResult;

public class GetEntryInjector implements RequestHandler<GetEntryRequest, GetEntryResult> {

    public GetEntryInjector() {
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
        AppComponent dagger = DaggerAppComponent.create();
        GetEntry getEntry = dagger.provideGetEntry();
        return getEntry.handleRequest(input, context);
    }
}
