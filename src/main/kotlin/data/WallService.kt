package ru.netology.data

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++id, likes = post.likes?.copy() ?: Likes(0),
            comments = post.comments?.copy() ?: Comments(0))
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, actualPost) in posts.withIndex()) {
            if (actualPost.id == post.id) {
                posts[index] = post.copy(likes = post.likes?.copy() ?: Likes(0),
                    comments = post.comments?.copy() ?: Comments(0))
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }
}