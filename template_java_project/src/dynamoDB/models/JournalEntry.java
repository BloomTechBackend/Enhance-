package dynamoDB.models;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "journalEntries")
public class JournalEntry {
    private String userId;
    private String date;
    private S3Link entry;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBRangeKey(attributeName = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDBAttribute(attributeName = "entry")
    public S3Link getEntry() {
        return entry;
    }

    public void setEntry(S3Link entry) {
        this.entry = entry;
    }
}
