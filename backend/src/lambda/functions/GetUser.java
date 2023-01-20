package lambda.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.UserDao;
import dynamoDB.models.User;
import lambda.models.request.GetUserRequest;
import lambda.models.result.GetUserResult;

import javax.inject.Inject;

public class GetUser implements RequestHandler<GetUserRequest, GetUserResult> {
    private UserDao userDao;

    @Inject
    public GetUser(UserDao userDao) {
        this.userDao = userDao;
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

        String userId = input.getUserId();

        userDao.getUser(userId);

        return new GetUserResult.Builder()
                .userId(userId)
                .build();
    }
}
