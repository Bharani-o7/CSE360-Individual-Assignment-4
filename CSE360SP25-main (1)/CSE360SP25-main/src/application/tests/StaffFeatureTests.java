// StaffFeatureTests.java
package application;

import databasePart1.DatabaseHelper;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StaffFeatureTests {

    private static DatabaseHelper dbHelper;

    @BeforeAll
    public static void setup() {
        dbHelper = new DatabaseHelper();
    }

    @Test
    public void testGetAllReviews() {
        List<Review> reviews = dbHelper.getAllReviews();
        assertNotNull(reviews);
    }

    @Test
    public void testApproveReview() {
        int testReviewId = 1; // Use an existing review ID in your test DB
        dbHelper.approveReview(testReviewId);
        List<Review> reviews = dbHelper.getAllReviews();
        boolean found = reviews.stream().anyMatch(r -> r.getId() == testReviewId);
        assertTrue(found);
    }

    @Test
    public void testDeleteReview() {
        int testReviewId = 2; // Use another known ID
        dbHelper.deleteReview(testReviewId);
        List<Review> reviews = dbHelper.getAllReviews();
        boolean exists = reviews.stream().anyMatch(r -> r.getId() == testReviewId);
        assertFalse(exists);
    }

    @Test
    public void testGetAllMessages() {
        List<Message> messages = dbHelper.getAllMessages();
        assertNotNull(messages);
    }

    @Test
    public void testGetAllReviewerRequests() {
        List<Request> requests = dbHelper.getAllReviewerRequests();
        assertNotNull(requests);
    }
}
