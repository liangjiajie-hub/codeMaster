package com.jiejieren.back_tracking;

import java.util.*;

public class Algorithm332_reconstruct_itinerary {

    private Map<String, List<String>> map = new HashMap<>();

    private List<String> list = new ArrayList<>();

    private Map<String, Integer> used = new HashMap<>();

    private List<String> result;

    private boolean flag = false;

    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            List<String> ele = map.getOrDefault(tickets.get(i).get(0), new ArrayList<>());
            ele.add(tickets.get(i).get(1));
            map.put(tickets.get(i).get(0), ele);
            used.put(tickets.get(i).get(0) + tickets.get(i).get(1), used.getOrDefault(tickets.get(i).get(0) + tickets.get(i).get(1), 0) + 1);
        }
        Set<Map.Entry<String, List<String>>> set = map.entrySet();
        for (Map.Entry<String, List<String>> entry : set) {
            entry.getValue().sort(Comparator.naturalOrder());
        }

        list.add("JFK");
        backtracking(tickets, tickets.size(), 0, "JFK");
        return result;
    }

    private void backtracking(List<List<String>> tickets, int maxdepth, int depth, String start) {
        if (depth == maxdepth) {
            flag = true;
            result = new ArrayList<>(list);
            return;
        }
        if (!flag) {
            List<String> endList = map.get(start);
            if (endList == null) return;
            for (int i = 0; i < endList.size(); i++) {
                if (used.get(start + endList.get(i)) == 0) continue;
                else {
                    if (i > 0 && endList.get(i).equals(endList.get(i - 1))) continue;
                }
                list.add(endList.get(i));
                used.put(start + endList.get(i), used.get(start + endList.get(i)) - 1);
                backtracking(tickets, maxdepth, depth + 1, endList.get(i));
                list.remove(list.size() - 1);
                used.put(start + endList.get(i), used.get(start + endList.get(i)) + 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
