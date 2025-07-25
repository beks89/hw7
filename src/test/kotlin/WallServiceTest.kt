import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test
import ru.netology.data.*
import ru.netology.exceptions.PostNotFoundException


class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun  createCommentPostIdTest() {
        val wall = WallService
        val post = Post(
            7, 15, 11, 18, "Check",
            comments = Comments(7),
            likes = Likes(50)
        )
        wall.add(post)
        val comment = Comment(5, 5, 14578, "You're right")
        wall.createComment(1, comment)
        assertEquals(1, wall.createComment(1, comment).comToPost)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val wall = WallService
        val comment = Comment(1, 5, 14578, "Check exception", comToPost = 0)
        wall.createComment(1, comment)
    }

    @Test
    fun addTest() {
        val wall = WallService
        val post = Post(
            7, 15, 11, 18, "Check",
            comments = Comments(7),
            likes = Likes(50)
        )
        val firstId = wall.add(post).id
        assertEquals(1, firstId)
    }

    @Test
    fun  updateTest() {
        val wall = WallService
        val post1 = Post(
            7, 15, 11, 18, "Check",
            comments = Comments(7),
            likes = Likes(50)
        )
        val post2 = Post(
            7, 15, 11, 18, "CHECK",
            comments = Comments(7),
            likes = Likes(50)
        )
        wall.add(post1)
        assertTrue(wall.update(post2.copy(1)))
    }

    @Test
    fun updateTestFalse() {
        val wall = WallService
        val post1 = Post(
            7, 15, 11, 18, "Check",
            comments = Comments(7),
            likes = Likes(50)
        )
        val post2 = Post(
            7, 15, 11, 18, "CHECK",
            comments = Comments(7),
            likes = Likes(50)
        )
        wall.add(post1)
        assertFalse(wall.update(post2.copy(5)))
    }

    @Test
    fun nullCommentsTest () {
        val wall = WallService
        val post = Post(
            7, 15, 11, 18, "Check null comments",
            comments = null,
            likes = Likes(50)
        )
        wall.add(post)
        assertEquals(Comments(0), wall.add(post).comments)
    }

    @Test
    fun nullLikesTest () {
        val wall = WallService
        val post = Post(
            7, 15, 11, 18, "Check null comments",
            comments = Comments(15),
            likes = null
        )
        wall.add(post)
        assertEquals(Likes(0), wall.add(post).likes)
    }
}