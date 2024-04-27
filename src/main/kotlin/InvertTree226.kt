
class InvertTree226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        rotate(root)
        if (root?.left != null) {
            invertTree(root.left)
        }
        if (root?.right != null) {
            invertTree(root.right)
        }
        return root
    }

    fun rotate(root:TreeNode?) {
        if (root == null ){
            return
        }
        if (root.left == null && root.right == null) {
            return
        }
        if (root.left != null || root.right != null) {
            var temp = root.left
            root.left = root.right
            root.right = temp
        }
    }
}

fun main() {

}