class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0;
        int right=rows*cols-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int currentRow = mid/cols;
            int currentCol = mid%cols;
            int currentElem = matrix[currentRow][currentCol];
            if(currentElem==target){
                return true;
            }else if(currentElem<target) {
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
        
    }
}