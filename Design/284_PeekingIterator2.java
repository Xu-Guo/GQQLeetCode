// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer num = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            num = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return num;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = num;
        if (iter.hasNext()) {
            num = iter.next();
        } else {
            num = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return num != null;
    }
}