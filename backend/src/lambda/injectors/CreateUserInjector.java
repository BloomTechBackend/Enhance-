package lambda.injectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dependencies.AppComponent;
import dependencies.DaggerAppComponent;
import lambda.functions.CreateUser;
import lambda.models.request.CreateUserRequest;
import lambda.models.result.CreateUserResult;

public class CreateUserInjector implements RequestHandler<CreateUserRequest, CreateUserResult> {

    public CreateUserInjector() {
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {
        AppComponent dagger = DaggerAppComponent.create();
        CreateUser createUser = dagger.provideCreateUser();
        return createUser.handleRequest(input, context);
    }
}
