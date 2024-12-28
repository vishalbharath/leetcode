/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* numbers, int numbersSize, int target, int* returnSize){
    int *result =(int*)malloc(2*sizeof(int));
    *returnSize=2;
    int start=0;
    int end=numbersSize-1;
    while(start<end)
    {
        int sum=numbers[start]+numbers[end];
        if(sum<target)
        {
            start++;
        }
        else if(sum>target)
        {
            end--;
        }
        else
        {
            result[0]=start+1;
            result[1]=end+1;
            return result;
        }

    }
    return result;

}
