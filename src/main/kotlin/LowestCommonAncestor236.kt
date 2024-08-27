class LowestCommonAncestor236 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null) {
            return null
        }

        val map = HashMap<TreeNode, TreeNode>()
        createParentMap(root, map)
        val pParentSet = HashSet<TreeNode>()
        var temp = p
        while (temp != null) {
            pParentSet.add(temp)
            temp = map[temp]
        }
        var temp2 = q
        while (temp2 != null) {
            if (pParentSet.contains(temp2)) {
                return temp2
            }
            temp2 = map[temp2]
        }
       return null
    }

    private fun createParentMap(root: TreeNode?, parentMap:HashMap<TreeNode, TreeNode>) {
        if (root == null) {
            return
        }
        if (root.left != null) {
            parentMap[root.left!!] = root
            createParentMap(root.left, parentMap)
        }
        root.right?.let {
            parentMap[it] = root
            createParentMap(it, parentMap)
        }
    }

}