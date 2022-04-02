package goit.hw_13_2;

public interface PostAPIProviderInterface {
    /**
     * @return data in JSON format
     */
    String getAllCommentsByPostRaw(int postId);
}
