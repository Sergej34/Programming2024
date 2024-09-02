package homework_32.forum.test;

import homework_32.forum.dao.Forum;
import homework_32.forum.dao.ForumImpl;
import homework_32.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ForumImplTest {

    Forum forum; //Forum forum : экземпляр класса Album, который тестируется.
    Post[] posts;
    int size;

    LocalDateTime now = LocalDateTime.now();

    Comparator<Post> comparator = (p1, p2) -> {
        return Integer.compare(p1.getPostId(), p2.getPostId());
    };


    @BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[5];
        posts[0] = new Post(1, "title1", "author1", "news1");
        posts[0].setDate(now.minusDays(7));
        posts[1] = new Post(2, "title2", "author2", "news2");
        posts[1].setDate(now.minusDays(3));
        posts[2] = new Post(3, "title3", "author4", "news3");
        posts[2].setDate(now.minusDays(6));
        posts[3] = new Post(4, "title4", "author4", "news4");
        posts[3].setDate(now.minusDays(4));
        posts[4] = new Post(5, "title5", "author4", "news5");
        posts[4].setDate(now.minusDays(5));

        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void testSortByAuthor(){
        printArray(posts);
        Arrays.sort(posts);
        printArray(posts);
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertFalse(forum.addPost(posts[2]));
        Post post = new Post(6, "title6", "author6", "news6");
        assertTrue(forum.addPost(post));
        assertEquals(6, forum.size());
        post = new Post(7, "title7", "author7", "news7");
        assertFalse(forum.addPost(post));

    }

    @Test
    void removePost() {
        // remove existed post
        assertTrue(forum.removePost(4));
        // remove absent post
        assertFalse(forum.removePost(6));
        // expectation of quantity
        assertEquals(4, forum.size());
    }

    @Test
    void updatePost() {
        // content update
        assertTrue(forum.updatePost(3, "news8"));
        assertEquals("news8", forum.getPostById(3).getContent());
    }

    @Test
    void getPostById() {
        // get exist post
        assertEquals(posts[0], forum.getPostById(1));
        // get absent post
        assertNull(forum.getPostById(6));


    }

    @Test
    void getPostByAuthor() {
        Post[] expected = {posts[4], posts[2], posts[3]};
        Arrays.sort(expected, comparator);
        Post[] actual = forum.getPostByAuthor("author4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void getPostsByAuthor() {
        // get existing author's post
        LocalDate localDate = LocalDate.now();
        Post[] expected = {posts[4], posts[3], posts[2]};
        Arrays.sort(expected, comparator);
        Post[] actual = forum.getPostByAuthor("author4", localDate.minusDays(6), localDate.minusDays(4));
        Arrays.sort(actual, comparator);
        assertArrayEquals(expected, actual);

    }

    @Test
    void size() {
        assertEquals(5, forum.size());

    }
    public void printArray(Post[] posts){
        for (int i = 0; i < posts.length; i++) {
            System.out.println(posts[i]);

        }

        System.out.println("-------------------------------------------------");


    }


}