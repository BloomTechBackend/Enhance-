package lambda.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.UserDao;
import dynamoDB.models.User;
import exceptions.DuplicateUserException;
import lambda.models.request.CreateUserRequest;
import lambda.models.result.CreateUserResult;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;

public class CreateUser implements RequestHandler<CreateUserRequest, CreateUserResult> {
    private UserDao userDao;

    @Inject
    public CreateUser(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input  The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return The Lambda Function output
     */
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {
        String userId = RandomStringUtils.randomAlphanumeric(5);
        User user = new User();
        user.setUserId(userId);

        try {
            userDao.saveUser(user);
        } catch (DuplicateUserException e) {
            handleRequest(input, context);
        }

        return new CreateUserResult.Builder()
                .userId(userId)
                .build();
    }
}
