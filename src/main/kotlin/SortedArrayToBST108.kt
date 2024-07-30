class SortedArrayToBST108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        val mid = nums.size / 2
        val root = TreeNode(nums[mid])
        insertNode(root, nums, 0, mid - 1)
        insertNode(root, nums, mid + 1, nums.size - 1)
        return root
    }

    private fun insertNode(parent: TreeNode, nums: IntArray, left: Int, right: Int) {
        if (left > right) {
            return
        }
        val mid = (left + right) / 2
        val node = TreeNode(nums[mid])
        if (node.`val` < parent.`val`) {
            parent.left = node
        } else {
            parent.right = node
        }
        insertNode(node, nums, left, mid - 1)
        insertNode(node, nums, mid + 1, right)
    }

    fun midOrderAccess(root: TreeNode?) {
        if (root?.left != null) {
            midOrderAccess(root.left)
        }
        if (root != null) {
           print("${root.`val`},")
        }
        if (root?.right != null) {
            midOrderAccess(root.right)
        }
    }
}

fun main() {
    val nums = intArrayOf(-10, -3, 0, 5, 9)
    val solution = SortedArrayToBST108()
    val root = solution.sortedArrayToBST(nums)
//    val root = TreeNode(1)
//    root.left = TreeNode(2)
//    root.right = TreeNode(3)
//    root.left!!.left = TreeNode(4)
//    root.left!!.right = TreeNode(5)
    solution.midOrderAccess(root)
}