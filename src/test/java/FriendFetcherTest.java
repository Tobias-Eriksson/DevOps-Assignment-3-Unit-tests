import org.example.FriendFetcher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FriendFetcherTest {
    @Test
    //Correct link returns the friends
    public void testGetFriendNames() {
        FriendFetcher friendFetcher = new FriendFetcher();
        String[] expectedFriends = {"Friend1", "Friend2", "Friend3"};
        String[] actualFriends = friendFetcher.getFriendNames("https://www.facebook.com/examplePage");
        assertArrayEquals(expectedFriends, actualFriends);
    }

    @Test
    //Incorrect link returns null
    public void testGetFriendNamesInvalidLink() {
        FriendFetcher friendFetcher = new FriendFetcher();
        String[] actualFriends = friendFetcher.getFriendNames("invalidLink");
        assertNull(actualFriends);
    }

    @Test
    //Correct link but expecting wrong friends
    public void testGetIncorrectFriendNames() {
        FriendFetcher friendFetcher = new FriendFetcher();
        String[] expectedFriends = {"Friend5", "Friend6", "Friend7"};
        String[] actualFriends = friendFetcher.getFriendNames("https://www.facebook.com/examplePage");
        assertNotEquals(expectedFriends, actualFriends);
    }

    //Performance test (Should be near 0 as nothing is actually fetched)
    @Test
    public void testPerformance() {
        FriendFetcher friendFetcher = new FriendFetcher();
        long startTime = System.currentTimeMillis();
        friendFetcher.getFriendNames("https://www.facebook.com/examplePage");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration < 100);  // Assuming fetching should take less than 100 milliseconds
    }
}
