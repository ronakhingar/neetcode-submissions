class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int n= numCourses;
       List<Integer> list[] = new List[numCourses];

       for(int i=0;i<n;i++){
        
            list[i]= new ArrayList<>();
        
       }

       int[] inorder= new int[n];

       for(int[] prereq:prerequisites){


        list[prereq[1]].add(prereq[0]);
        inorder[prereq[0]]++;

       }

        Queue<Integer> queue = new ArrayDeque();
       for(int i=0;i<n;i++){
            if(inorder[i]==0){
                queue.add(i);
            }
       }

    int[] output = new int[n];
    int count=0;
    while(!queue.isEmpty()){

        int polledPreReq = queue.poll();
        output[count++]=polledPreReq;
        for(int course:list[polledPreReq]){
            inorder[course]--;
            if(inorder[course]==0){
                queue.add(course);
            }
        }


    }

    return count==n?output:new int[0];

    }
}
