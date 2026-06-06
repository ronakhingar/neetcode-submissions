class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> currentList= new ArrayList<>();
        createSubsets(nums,currentList,list,0);

    return list;
    }

    private void createSubsets(int[] nums,List<Integer> currentList, List<List<Integer>> list, int currentIndex){

        if(currentIndex== nums.length){
            list.add(new ArrayList<>(currentList));
            return;
        }


currentList.add(nums[currentIndex]);
createSubsets(nums,currentList,list,currentIndex+1);

currentList.remove(currentList.size()-1);

createSubsets(nums,currentList,list,currentIndex+1);


        

    }


}
