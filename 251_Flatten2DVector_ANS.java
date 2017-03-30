public class Vector2D implements Iterator<Integer> {
    int lineIdx;
    int eleIdx;
    List<List<Integer>> vec;
    public Vector2D(List<List<Integer>> vec2d) {
        lineIdx = 0;
        eleIdx = 0;
        vec = vec2d;
    }

    @Override
    public Integer next() {
        return vec.get(lineIdx).get(eleIdx++);
    }

    @Override
    public boolean hasNext() {
        while (lineIdx < vec.size()) {
            if (eleIdx < vec.get(lineIdx).size()) {
                return true;
            }
            lineIdx++;
            eleIdx = 0;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */