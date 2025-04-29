package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter

public class PostsPage {
    public List<Post> posts;
    private int currentPage;
    private int totalPages;
}
// END


