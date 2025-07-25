package ru.netology.data

import ru.netology.exceptions.PostNotFoundException

object WallService {
    private var comments = emptyArray<Comment>()
    private var posts = emptyArray<Post>()
    private var id = 0
    private var postId = 0
    private var commentId = 0

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment.copy(id = ++commentId, comToPost = postId)
                return comments.last()
            }
        }
        throw PostNotFoundException()
    }

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

    fun printPosts() {
        for (post in posts) {
            print(post)
            println()
        }
    }

    fun printComment() {
        for (comment in comments) {
            print(comment)
            println()
        }
    }

    fun clear() {
        posts = emptyArray()
        postId = 0
        commentId = 0
        comments = emptyArray()
    }
}