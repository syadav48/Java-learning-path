    package helloInterview.dsa.queue;

    import java.util.*;

    public class TopKFreqWord {
        public List<String> topKFrequent(String[] words, int k) {
            List<String> res = new ArrayList<>();
            Map<String, Integer> freq = new HashMap<>();
            for(String word: words){
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue() - b.getValue();
            });
            for(Map.Entry<String, Integer> entry: freq.entrySet()){
                pq.offer(entry);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            while (!pq.isEmpty()){
                res.add(pq.poll().getKey());
            }
            System.out.println(freq);
            System.out.println(res);
            Collections.reverse(res);
            return res;
        }
        public static void main(String[] args) {
            TopKFreqWord topKFreqWord = new TopKFreqWord();
            String[] words1 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
            String[] words2 = {"i","love","leetcode","i","love","coding"};

            System.out.println(topKFreqWord.topKFrequent(words1, 4));
            System.out.println(topKFreqWord.topKFrequent(words2, 2));
        }
    }
