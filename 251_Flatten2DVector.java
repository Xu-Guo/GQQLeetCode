public class Vector2D implements Iterator<Integer> {

    List<List<Integer>> vec2d = new ArrayList<>();
    public Vector2D(List<List<Integer>> vec2d) {
        for (List<Integer> list : vec2d) {
            if (list.size() > 0)
                this.vec2d.add(new ArrayList<Integer>(list));
        }
    }

    @Override
    public Integer next() {
        List<Integer> vals = vec2d.get(0);
        int val = vals.get(0);
        vals.remove(0);
        if (vals.size() == 0) {
            vec2d.remove(0);
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return vec2d.size() > 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */