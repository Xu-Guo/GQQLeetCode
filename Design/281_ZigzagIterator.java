public class ZigzagIterator {
    int idx1, idx2;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        idx1 = v1.size() == 0 ? -1 : 0;
        idx2 = v2.size() == 0 ? -1 : 0;
    }

    public int next() {
        int res = 0;
        if (idx1 != -1 && idx2 != -1) {
            res = idx1 > idx2 ? v2.get(idx2++) : v1.get(idx1++);
        } else if (idx1 != -1) {
            res = v1.get(idx1++);
        } else {
            res = v2.get(idx2++);
        }
        if (idx1 == v1.size()) idx1 = -1;
        if (idx2 == v2.size()) idx2 = -1;
        return res;
    }

    public boolean hasNext() {
        return !(idx1 == -1 && idx2 == -1);
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */