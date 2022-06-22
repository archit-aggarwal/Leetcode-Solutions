class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            q.add(arr[i]);
        }
        
        int kthLargest = q.peek();
        while(k-- > 0){
            kthLargest = q.remove();
        }
        return kthLargest;
    }
}