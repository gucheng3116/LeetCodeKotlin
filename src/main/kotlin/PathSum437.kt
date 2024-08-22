import apple.laf.JRSUIUtils.Tree

class PathSum437 {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }
        val list = arrayListOf<TreeNode>()
        preOrderVisitList(root, list)
        var count = 0
        list.forEach {
            count += countOneNodePath(it, targetSum, 0, 0)
        }
        return count
    }

    fun preOrderVisitList(root:TreeNode?, list:ArrayList<TreeNode>) {
        if (root == null) {
            return
        }
        list.add(root)
        preOrderVisitList(root.left, list)
        preOrderVisitList(root.right, list)
    }

    private fun countOneNodePath(root:TreeNode?, targetSum: Int, sum:Long, count:Int) : Int {
        if (root == null) {
            return count
        }
        var result = count
        if (root.`val` + sum == targetSum.toLong()) {
            println("root.val is ${root.`val`}, sum is $sum")
            result++
        }
        result = countOneNodePath(root.left, targetSum, root.`val` + sum, result)
        result = countOneNodePath(root.right, targetSum, root.`val` + sum, result)
        return result
    }
}

fun main() {
    val root = TreeNode(1000000000)
    val node2 = TreeNode(1000000000)
    root.left = node2
    val node3 = TreeNode(294967296)
    node2.left = node3
    val node4 = TreeNode(1000000000)
    node3.left = node4
    val node5 = TreeNode(1000000000)
    node4.left = node5
    val node6 = TreeNode(1000000000)
    node5.left = node6
    val solution = PathSum437()
    val result = solution.pathSum(root, 0)
    println("result is $result")
//    println("root val is ${root.`val`}")
//        println("root val + root val is ${root.`val` + root.`val` + + root.`val`}")
//    println("Int max is ${Int.MAX_VALUE} ")

}