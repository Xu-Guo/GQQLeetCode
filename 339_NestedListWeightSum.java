/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return getSum(1, nestedList);
    }

    public int getSum(int deep, List<NestedInteger> nestedList) {
        int total = 0;
        for (NestedInteger ni : nestedList) {
            total += ni.isInteger ? deep * ni.getInteger() : getSum(deep + 1, ni.getList());
        }
        return total;
    }
}