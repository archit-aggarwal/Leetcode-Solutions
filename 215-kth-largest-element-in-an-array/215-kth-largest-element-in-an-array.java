class Solution {
    public int findKthLargest(int[] arr, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int val: arr) temp.add(val);
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.addAll(temp);
        
        int kthLargest = q.peek();
        while(k-- > 0){
            kthLargest = q.remove();
        }
        return kthLargest;
    }
}