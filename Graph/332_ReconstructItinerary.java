public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, ArrayList<String>> itigraph = new HashMap<>();
        int number = tickets.length;
        List<String> itineraries = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];
            if (!itigraph.containsKey(from)) {
                ArrayList<String> queue = new ArrayList<>();
                queue.add(to);
                itigraph.put(from, queue);
            } else {
                itigraph.get(from).add(to);
            }
        }

        for (String from : itigraph.keySet()) {
            Collections.sort(itigraph.get(from));
        }
        itineraries.add("JFK");
        doDfs(itineraries, number, itigraph, "JFK");
        return itineraries;
    }

    private boolean doDfs(List<String> itineraries, int number, Map<String, ArrayList<String>> itigraph, String from) {
        if(number == 0) return true;
        ArrayList<String> lstToPlaces = itigraph.get(from);
        // System.out.println(lstToPlaces.size());
        if (null == lstToPlaces) return false;
        ArrayList<String> toPlaces = new ArrayList(lstToPlaces);
        for (int i = 0; i < toPlaces.size(); i++) {
            String to = toPlaces.get(i);
            // System.out.println(to);
            itineraries.add(to);
            lstToPlaces.remove(i);
            boolean t = doDfs(itineraries, number - 1, itigraph, to);
            if(t) return true;
            itineraries.remove(itineraries.size() - 1);
            lstToPlaces.add(i, to);
        }
        return false;
    }
}