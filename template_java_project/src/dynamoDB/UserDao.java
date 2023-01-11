package dynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTableMapper;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import dynamoDB.models.User;
import exceptions.DuplicateUserException;
import exceptions.UserNotFoundException;

import javax.inject.Inject;

public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public User getUser(String userId) {
        User user = dynamoDBMapper.load(User.class, userId);

        if (user == null)
            throw new UserNotFoundException("Could not find User with provided userId");

        return user;
    }

    public User saveUser(User user) {
        DynamoDBTableMapper<User,String,?> table = dynamoDBMapper.newTableMapper(User.class);
        try {
            table.saveIfNotExists(user);
        } catch (ConditionalCheckFailedException e) {
            throw (new DuplicateUserException("userId is not unique", e));
        }
        return user;
    }
}
