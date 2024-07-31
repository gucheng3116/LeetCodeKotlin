class KthSmallest230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (k == 0) {
            return 0
        }
        return visitMidOrder(root, k)
    }
    private var count = 0
    fun visitMidOrder(root: TreeNode?, k: Int): Int {
        var result = 0
        if (root?.left != null) {
            result = visitMidOrder(root.left, k)
        }
        if (count == k) {
            return result
        }
        if (root == null) {
            return 0
        }
        count++
        if (count == k) {
            return root.`val`
        }
        if (root.right != null) {
            result = visitMidOrder(root.right, k)
        }
        return result
    }
}