# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stk = []
        self.pushAll(root)

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stk) > 0

    def next(self):
        """
        :rtype: int
        """
        node = self.stk.pop()
        self.pushAll(node.right)
        return node.val

    def pushAll(self, node):
        while node is not None:
            self.stk.append(node)
            node = node.left

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
