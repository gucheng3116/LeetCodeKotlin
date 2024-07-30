class ValidBST98 {
    fun isValidBST(root: TreeNode?): Boolean {
        val arrayList = ArrayList<Int>()
        return midOrderVisit(root, arrayList)
    }

    private fun midOrderVisit(root: TreeNode?, arrayList: ArrayList<Int>): Boolean {
        var result = true
        if (root?.left != null) {
            result = result && midOrderVisit(root.left, arrayList)
        }
        if (!result) {
            return false
        }
        if (root != null) {
            arrayList.add(root.`val`)
            if (arrayList.size > 1 && arrayList[arrayList.size - 2] >= arrayList[arrayList.size - 1]) {
                return false
            }
        }
        if (root?.right != null) {
            result = result && midOrderVisit(root.right, arrayList)
        }
        return result
    }
}



