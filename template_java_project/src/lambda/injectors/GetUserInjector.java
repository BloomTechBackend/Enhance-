package lambda.injectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependencies.AppComponent;
import dependencies.DaggerAppComponent;
import lambda.functions.GetUser;
import lambda.models.request.GetUserRequest;
import lambda.models.result.GetUserResult;

public class GetUserInjector implements RequestHandler<GetUserRequest, GetUserResult> {

    public GetUserInjector() {
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public GetUserResult handleRequest(GetUserRequest input, Context context) {
        AppComponent dagger = DaggerAppComponent.create();
        GetUser getUser = dagger.provideGetUser();
        return getUser.handleRequest(input, context);
    }
}
