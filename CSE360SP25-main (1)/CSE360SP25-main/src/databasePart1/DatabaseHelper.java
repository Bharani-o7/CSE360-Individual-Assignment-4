// DatabaseHelper.java (Add these methods to your class)

public List<Review> getAllReviews() {
    List<Review> reviews = new ArrayList<>();
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reviews")) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            reviews.add(new Review(rs.getInt("id"), rs.getString("content"), rs.getString("author")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reviews;
}

public void approveReview(int reviewId) {
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement("UPDATE reviews SET approved = 1 WHERE id = ?")) {
        stmt.setInt(1, reviewId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void deleteReview(int reviewId) {
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM reviews WHERE id = ?")) {
        stmt.setInt(1, reviewId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public List<Message> getAllMessages() {
    List<Message> messages = new ArrayList<>();
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM messages")) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            messages.add(new Message(rs.getString("sender"), rs.getString("receiver"), rs.getString("content")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return messages;
}

public List<Request> getAllReviewerRequests() {
    List<Request> requests = new ArrayList<>();
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM role_requests WHERE role='reviewer' AND status='pending'")) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            requests.add(new Request(rs.getString("username"), rs.getString("role")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return requests;
}
