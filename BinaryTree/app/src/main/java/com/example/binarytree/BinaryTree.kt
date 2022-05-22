package com.example.binarytree

import java.util.*

data class TreeNode<T>(
    var data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

class BinaryTree {
    var root: TreeNode<String>? = null

    fun add(data: String, left: String, right: String) {
        if (root == null) {
            if (data != ".") root = TreeNode(data)
            if (left != ".") root!!.left = TreeNode(left)
            if (right != ".") root!!.right = TreeNode(right)
        }
        else search(root!!, data, left, right)
    }

    private fun search(root: TreeNode<String>, data: String, left: String, right: String) {
        if (root.data == data) {
            if (left != ".") root.left = TreeNode(left)
            if (right != ".") root.right = TreeNode(right)
        }
        else {
            if (root.left != null) search(root.left!!, data, left, right)
            if (root.right != null) search(root.right!!, data, left, right)
        }
    }

    fun preOrder(root: TreeNode<String>) {
        print(root.data)
        if (root.left != null) preOrder(root.left!!)
        if (root.right != null) preOrder(root.right!!)
    }

    fun inOrder(root: TreeNode<String>) {
        if (root.left != null) inOrder(root.left!!)
        print(root.data)
        if (root.right != null) inOrder(root.right!!)
    }

    fun postOrder(root: TreeNode<String>) {
        if (root.left != null) postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        print(root.data)
    }
}

fun main() = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val binaryTree = BinaryTree()

    for (i in 0 until n) {
        val (a, b, c) = nextLine().split(" ")
        binaryTree.add(a, b, c)
    }

    binaryTree.preOrder(binaryTree.root!!)
    println()
    binaryTree.inOrder(binaryTree.root!!)
    println()
    binaryTree.postOrder(binaryTree.root!!)
}

