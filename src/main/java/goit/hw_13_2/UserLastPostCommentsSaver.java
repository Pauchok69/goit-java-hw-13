package goit.hw_13_2;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class UserLastPostCommentsSaver {
    public static final String COMMENTS_FILE_PATH_PATTERN
            = "src/main/java/goit/hw_13_2/files/user-%s-post-%s-comments.json";
    private final int currentUserId;
    private final UserAPIProvider userAPIProvider = new UserAPIProvider();
    private final PostAPIProvider postAPIProvider = new PostAPIProvider();

    public UserLastPostCommentsSaver(int userId) {
        this.currentUserId = userId;
    }

    /**
     * @throws java.util.NoSuchElementException if there are no users with such id
     *
     */
    public void findAndSave() {
        Post lastPost = findCurrentUserLastPost();

        if (lastPost != null) {
            String comments = findAllCommentsBy(lastPost);
            saveCommentsToFile(comments, new File(createFileName(currentUserId, lastPost.getId())));
        }
    }

    private Post findCurrentUserLastPost() {
        return findAllPostsOfCurrentUser()
                .stream()
                .max(Comparator.comparing(Post::getId))
                .orElseThrow();
    }

    private List<Post> findAllPostsOfCurrentUser() {
        return userAPIProvider.getAllPostsByUser(currentUserId);
    }

    private String findAllCommentsBy(@NotNull Post lastPost) {
        return postAPIProvider.getAllCommentsByPostRaw(lastPost.getId());
    }

    private String createFileName(int userId, int postId) {
        return String.format(COMMENTS_FILE_PATH_PATTERN, userId, postId);
    }

    private void saveCommentsToFile(String comments, File commentsFile) {
        try (FileWriter fileWriter = new FileWriter(commentsFile)) {
            fileWriter.write(comments);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
