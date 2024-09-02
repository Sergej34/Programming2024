package homework_32.forum.dao;
//Задача 1
//Создать аппликацию Forum согласно UML.

import homework_32.forum.model.Post;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum {

    private Post[] posts;
    private int size;

    public ForumImpl() {
        this.posts = new Post[6];
    }
    Comparator<Post> comparator = (p1, p2) -> {
        return Integer.compare(p1.getPostId(), p2.getPostId());
    };

    @Override
    public boolean addPost(Post post) {
        if (post == null || posts.length == size || getPostById(post.getPostId()) != null) {
            return false;
        }
        int index = Arrays.binarySearch(posts, 0, size, post, comparator);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(posts, index, posts, +1, size - index);
        posts[index] = post;
        size++;
        return true;
    }
    @Override
    public boolean removePost(int postId) {
        for (int i = 0; i < size; i++) {
            if(posts[i].getPostId() == postId){
                System.arraycopy(posts, i + 1, posts, i, size - i -1);
                posts[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        Post post = getPostById(postId);
        if (post == null) {
            return false;
        }
        post.setContent(content);
        return true;
    }

    @Override
    public Post getPostById(int postId) {
            for (int i = 0; i < size; i++) {
                if(posts[i].getPostId() == postId){
                    return posts[i];
                }
            }
        return null;
    }

    @Override
    public Post[] getPostByAuthor(String author) {
        return findPostByPredicate(post -> author.equals(post.getAuthor()));
    }

    @Override
    public Post[] getPostByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        return findPostByPredicate(post -> post.getDate().toLocalDate().isAfter(dateFrom.minusDays(1))
                && post.getDate().toLocalDate().isBefore(dateTo.plusDays(1)) && author.equals(post.getAuthor()));
    }

    @Override
    public int size() {
        return size;
    }
    private Post[] findPostByPredicate(Predicate<Post> predicate){
        Post[] res = new Post[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(posts[i])){
                res[j++] = posts[i];
            }

        }
        return Arrays.copyOf(res, j);
    }
}
