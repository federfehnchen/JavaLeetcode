import java.util.*;

public class main {

    public static void main(String[] args) {

        System.out.println(hammingWeight(3));

    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedList = new int[arr1.length + arr2.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < mergedList.length; i++) {
            if (a < arr1.length && b < arr2.length) {
                if (arr1[a] > arr2[b]) {
                    mergedList[i] = arr2[b];
                    b++;
                } else {
                    mergedList[i] = arr1[a];
                    a++;
                }
            } else {
                if (a >= arr1.length) {
                    mergedList[i] = arr2[b];
                    b++;
                } else {
                    mergedList[i] = arr1[a];
                    a++;
                }

            }

        }
        if (mergedList.length % 2 == 0)
            return ((double) (mergedList[mergedList.length / 2] + mergedList[(mergedList.length - 1) / 2])) / 2;
        else return mergedList[mergedList.length / 2];
    }

    List<Integer> a = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {

        traversal(root);

        return a;
    }

    public void traversal(TreeNode rootNode)
    {
        if(rootNode!=null){
        traversal(rootNode.left);
        a.add(rootNode.val);
        traversal(rootNode.right);
    }

    }

    public static boolean isSameTree(TreeNode eins, TreeNode zwei)
    {
        if(eins == null && zwei == null)return true;
        if(eins == null || zwei == null)return false;
        if(eins.val == zwei.val)
        {
        if(isSameTree(eins.left,zwei.left)&&isSameTree(eins.right,zwei.right)) return true;
        else return false;

        }
        else{return false;}



    }

    public static int numOfSubarrays(int[] arr, int k, int threshold)
    {
    int average = 0; int thresholdnum = 0;
    for(int i=0;i<k;i++){average+=arr[i];} if(average/k>=threshold) thresholdnum++;
    for(int i=k;i<arr.length;i++){average+=arr[i]-arr[i-k]; if(average/k>=threshold)thresholdnum++;}

        return thresholdnum;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode head;
        if(list1==null&&list2==null)return null;
        else{
            if(list1==null) return list2;
            if(list2==null) return list1;
            if(list1.val>= list2.val) {head = list2; list2=list2.next;}
        else {head = list1; list1=list1.next;}

        }
        ListNode curr = head;
        int zaehler = 0;

        while(list1 !=null || list2 != null)
        {
         if(list1!=null && list2!=null){
             if(list1.val>=list2.val){curr.next=list2;list2=list2.next;
             }
                else
                {
                curr.next=list1;list1=list1.next;
                }

         }
         else
         {
             if(list1==null){curr.next=list2;list2=list2.next;}
             else{curr.next=list1;list1=list1.next;}
         }
        if(zaehler==0) head.next = curr.next;
        curr=curr.next;
        zaehler++;
        }

        return head;
    }

    public static int maxArea(int[] height)
    {
        int i=0; int j= height.length-1;
        int curr = 0;
        while(i<j)
        {
            curr = Math.max(curr, (j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return curr;
    }

    public static boolean isMatch(String s, String p)
    {
        p=p.replace("*","(.*)");
        p=p.replace("?","(.)");
        return s.matches(p);
    }

    public static int trap(int[] height)
    {
        int len = height.length;
        int r=len-2;
        int l=1;
        int r_max=height[len-1];
        int l_max=height[0];
        int count = 0;
        if(len<3) return 0;
        while(l<=r)
        {
            if(l_max>=r_max)
            {
                if(height[r]>r_max) r_max=height[r];
                else count+=r_max-height[r];
                r--;

            }
            else
            {
                if(height[l]>l_max) l_max=height[l];
                else count += l_max-height[l];
                l++;

            }
        }

        return count;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int[] arr = new int[m];
        for(int i=0;i<m;i++)
        {
            arr[i]=nums1[i];
        }
        int eins=0;
        int zwei=0;
        int zaehler=0;

        while(eins<m && zwei<n)
        {
            if(arr[eins]>nums2[zwei])
            {
                nums1[zaehler]=nums2[zwei]; zwei++;
            }
            else
            {
                nums1[zaehler]=arr[eins]; eins++;
            }
            zaehler++;
        }
        while(eins<m)
        {
            nums1[zaehler]=arr[eins]; eins++; zaehler++;
        }
        while(zwei<n)
        {
            nums1[zaehler]=nums2[zwei]; zwei++; zaehler++;
        }

    }

    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int row = BinaryRowSearch(matrix,target,0, matrix.length-1);
        if(row!=-1)
        {
            return BinarySearch(matrix,target,row,0,matrix[0].length-1);
        }
        else return false;


    }

    public static boolean BinarySearch(int[][] matrix,int target, int row, int l, int r)
    {
        if(r>=l)
        {
          int m=l+(r-l)/2;
          if(matrix[row][m]==target) return true;
          if(matrix[row][m]>target) return BinarySearch(matrix,target,row,l,m-1);
          if(matrix[row][m]<target) return BinarySearch(matrix,target,row,m+1,r);
        }
        return false;
        }

    public static int BinaryRowSearch(int[][] matrix, int target, int l, int r)
    {
        if(r>=l)
        {
            int m=l+(r-l)/2;
            if(matrix[m][0]<=target && matrix[m][matrix[0].length-1]>=target) return m;
            if(matrix[m][0]>target) return BinaryRowSearch(matrix,target,l,m-1);
            if(matrix[m][matrix[0].length-1]<target) return BinaryRowSearch(matrix,target,m+1,r);
        }
        return -1;
    }
    static List<Integer> ha = new LinkedList<>();
    public static List<Integer> preorderTraversal(TreeNode root)
    {
        ha.clear();
        helperPreorderTraversal(root);
        return ha;
    }

    public static void helperPreorderTraversal(TreeNode root)
    {
        if(root==null) return;
        else {ha.add(root.val); helperPreorderTraversal(root.left); helperPreorderTraversal(root.right);}
    }

    static List<Integer> Posto = new ArrayList<>();
    public static List<Integer> postorderTraversal(TreeNode root)
    {
        Posto.clear();
        postorderTraversalHelper(root);
        return Posto;
    }

    public static void postorderTraversalHelper(TreeNode root)
    {
        if(root==null) return;
        postorderTraversalHelper(root.left);
        postorderTraversalHelper(root.right);
        Posto.add(root.val);

    }

    public static boolean isValid(String str)
    {
        Stack<Character> chars1 = new Stack<>();
        char[] chars = str.toCharArray();
        for(int i=0;i< chars.length;i++)
        {
            if(chars[i]=='(' || chars[i] == '[' || chars[i] == '{')
            {
                chars1.push(chars[i]);
            }
            else
            {
                if(chars1.isEmpty()) return false;
             char op1 = chars1.pop();
             switch (op1)
             {
                 case '(': if(chars[i]==')') break;
                            else return false;
                 case '[': if(chars[i]==']') break;
                            else return false;
                 case '{': if(chars[i]=='}') break;
                            else return false;
                 default: return false;

             }

            }

        }
        if(chars1.isEmpty()) return true;
        return false;
    }

    public static int strStr(String haystack, String needle)
    {

        return haystack.indexOf(needle);
    }

    public static int[] twoSums(int[] nums, int target)
    {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        int[] ret = new int[2];

        for(int i=0;i<nums.length;i++)
        {
            if(mapping.containsKey(target-nums[i]))
            {
                ret[0]=i; ret[1]=mapping.get(target-nums[i]); return ret;
            }
            mapping.put(nums[i],i);
        }


    return null;
    }

    public static int divide(int dividend, int divisor)
    {
        int count = 0;


        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) {
            if (dividend < 0) dividend *= -1;
            if (divisor < 0) divisor *= -1;

            while (divisor <= dividend) {
                dividend -= divisor;
                count++;
            }

            return -1 * count;
            }

        else {
            if (divisor > 0) {
                dividend *= -1;
                divisor *= -1;
            }
            while (divisor >= dividend) {
                dividend -= divisor;
                count++;
            }
            return count;
            }
    }

    static List<List<Integer>> zwspermute = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums)
    {
        zwspermute.clear();
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> a = new ArrayList<>();
            a.add(nums[i]);
            permuteHelper(nums, a);
        }

    return zwspermute;
    }

    public static void permuteHelper(int[] nums, List<Integer> a)
    {
        if(a.size()==nums.length) zwspermute.add(a);
        else
        {
            for(int i=0;i<nums.length;i++)
            {
                if(!a.contains(nums[i]))
                {
                    List<Integer> b = new ArrayList<>();
                    for(int c=0;c<a.size();c++)
                    {
                        b.add(a.get(c));
                    }
                    b.add(nums[i]);
                    permuteHelper(nums,b);
                }

            }
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {

        if(strs.length==0) return new ArrayList<>();
        HashMap<String,List<String>> mapping = new HashMap<>();
        for(String s: strs)
        {
        char[] o = s.toCharArray();
        Arrays.sort(o);
        String sortedS = String.copyValueOf(o);
        if(mapping.containsKey(sortedS)) mapping.get(sortedS).add(s);
        else {
            List<String> neu1 = new ArrayList<>();
            neu1.add(s);
            mapping.put(sortedS,neu1);
        }
        }

        return new ArrayList<>(mapping.values());
    }

    public static int removeDuplicates(int[] nums)
    {
        int len = nums.length;
        int k = len;
        if(len==1) return 1;
        for(int i=1;i<len;i++)
        {
            if(nums[i]==nums[i-1]) {nums[i-1]=101; k--;}
        }
        Arrays.sort(nums);
        return k;
    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsertHelper(nums,target,0,nums.length-1);
    }

    public static int searchInsertHelper(int[] nums, int target, int l, int r)
    {
        if(r>=l){
        int mid = l+((r-l)/2);
        if(nums[mid]==target) return mid;
        if(nums[mid]<target) return searchInsertHelper(nums,target,mid+1,r);
        if(nums[mid]>target) return searchInsertHelper(nums,target,l,mid-1);}
        else
        {
            if(l>r) return l;
            else return r;
        }
        return 0;
    }

    public static int maxConsecutive(int[] nums)
    {
        int curr = 0;
        int max = 0;
        int zeropointer = -1;
        int len = nums.length;

        for(int i=0;i<len;i++)
        {
         if(nums[i]==1) curr++;
         else
         {
             curr=i-zeropointer;
             zeropointer=i;
         }
         max = Math.max(curr, max);
        }
        return max;
    }


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> retList = new ArrayList<>();
        pathSumHelper(root,targetSum,0,new ArrayList<>(), retList);
        return retList;
    }

    public static void pathSumHelper(TreeNode root, int targetSum, int curr, List<Integer> currPathSumList, List<List<Integer>> retList)
    {
        if(root==null) return;
        curr+=root.val;
        currPathSumList.add(root.val);
        if(root.left==null && root.right==null){if(curr==targetSum)retList.add(currPathSumList);else return;}
        pathSumHelper(root.left,targetSum,curr,new ArrayList<>(currPathSumList), retList);
        pathSumHelper(root.right,targetSum,curr,new ArrayList<>(currPathSumList), retList);
    }

    public static ListNode sortList(ListNode head)
    {
    if(head==null) return null;
    if(head.next==null) return head;
    ListNode curr = head;
    ListNode currn = head.next;
    int change = 1;
    int valuezws = 0;

    while(change!=0){
        change = 0;
    while(currn!=null)
    {
        if(curr.val>currn.val)
        {
            valuezws = curr.val;
            curr.val=currn.val;
            currn.val = valuezws;
            change++;
        }
        curr=currn;
        currn=currn.next;
    }
    curr=head;
    currn=head.next;
    }
    return head;
    }

    public static int hammingWeight(int n)
    {
        char[] zws = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for(char i:zws)
        {
            if(i == '1') count++;
        }

        return count;
    }

    public static int longestConsecutive(int[] nums)
    {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int count =0, maxCount=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]==nums[i]+1){
                count++;
                maxCount=Math.max(count, maxCount);
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                count=0;
            }
        }
        return maxCount+1;
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target)
    {
        List<List<Integer>> retList = new ArrayList<>();
        combinationSumHelper(nums, target, new ArrayList<>(), retList, 0);
        return retList;
    }

    public static void combinationSumHelper(int[] nums, int target, List<Integer> curr, List<List<Integer>> retList, int currPos)
    {
        if(target<0) return;
        if(target==0) {retList.add(new ArrayList<>(curr)); return;}
        else
        {
            for(;currPos<nums.length;currPos++)
                {
                    curr.add(nums[currPos]);
                    combinationSumHelper(nums,target-nums[currPos],curr,retList, currPos);
                    curr.remove(curr.size()-1);

                }
        }
        return;
    }
}
