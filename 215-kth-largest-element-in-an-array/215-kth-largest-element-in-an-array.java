class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            if(i < k){
                q.add(arr[i]);
            } else if(q.peek() < arr[i]) {
                q.remove();
                q.add(arr[i]);
            }
        }
        
        return q.peek();
    }
}