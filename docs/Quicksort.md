# Quick Sort

Today, I'm trying to solve a problem in leetcode [Wiggle Sort II](https://leetcode.com/explore/interview/card/top-interview-questions-hard/120/sorting-and-searching/857/).
I couldn't come up with any algorithm which works especially when there are duplicates in the array. Then I looked into the solution.

It uses **Partition Algorithm of Quick Sort** to find the Median of the array in **O(n)** time without sorting the array.

Though the concept of quicksort is clear to me, I never used it often as its worse case time is O(n<sup>2</sup>) and we have Merge sort whose time complexity is O(n logn) even in worst case and got pretty comfortable with it. I never imagined that quick sort concepts will be useful in solving other problems.
When I tried to program quick sort in Java, I faced a challenge while coding partition algorithm.
So I decided to work on quicksort and algorithms related to it.

1. [Quicksort program in Java](#1-quicksort-in-java)
2. [Finding kth smallest element in an array (can be used to find median)](#2-finding-kth-smallest-element-in-an-array)
3. Wiggle sort

## 1. QuickSort in Java

### Idea of quicksort
We use a strategy called **Divide and Conquer** to solve this problem to reduce the time complexity.

For each number, what will be its position in the array after sorting?
Let's give a name to that number - **pivot**.

We should write an algorithm such that, after placing the pivot in its correct position,
- All numbers to the *left side* of the pivot should be *less than* pivot.
- All numbers to the *right side* of the pivot should be *greater than* pivot.

This step is called **Partitioning** and is key to the quicksort algorithm.

Then we apply,
- Quicksort on left side of the array
- Quicksort in right side of the array

### Example
> arr = [7,4,6,2,8,1,3,9]

Let's take first element **7** as pivot.
After partitioning,
> arr = [4,6,2,1,3,**7**,8,9]

Next we apply partitioning algorithm on left and right side of the pivot recursively.

> left = [4,6,2,1,3]

> right = [8,9]

After the quicksort is complete, since every element is in its correct position the array is sorted.

### Partitioning
Let's take an array `arr` and we want to partition the values between indices `left` and `right`(inclusive) with pivot as `middle` element.
```java
void int partition(int[] arr, int left, int right) {
    int middle = (left  + right)/2;
    int pivot = arr[middle];
}
```
Our goal is to place all elements less than `arr[middle]` to the left side and all elements greater than `arr[middle]` to the right side in the array.
For this, we take two variables
- `left_pointer` which starts from `left` of `arr`
- `right_pointer` which starts from `right` of `arr`

*left_pointer* &rarr;

0 | 1 | 2 | 3 | 4 | 5 | 6 | 7  

&nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  &nbsp;   &nbsp;   &nbsp;   &nbsp;   &nbsp;  &larr; *right_pointer*  

**Steps:**
1. From left find an element > pivot  
2. From right find an element < pivot  
3. Swap elements in `left_pointer` and `right_pointer`  
4. Do steps 1-3 until `left_pointer` crosses `right_pointer` (i.e., `left_pointer > right_pointer`)
5. Finally we swap middle element with `left_pointer` or `left_pointer-1`

After transforming into code:
```java
int partition(int[] arr, int left, int right) {
    int middle = (left + right) / 2;
    int pivot = arr[middle];

    int left_pointer = left;
    int right_pointer = right;

    while (left_pointer < right_pointer) {
        while (left_pointer <= right && (left_pointer == middle || arr[left_pointer] <= arr[middle])) left_pointer++;
        while (right_pointer >= left && (right_pointer == middle || arr[right_pointer] >= arr[middle])) right_pointer--;

        if (left_pointer < right_pointer) swap(arr, left_pointer, right_pointer);
    }

    int newPivotIndex = (left_pointer <= middle ? left_pointer: left_pointer - 1);
    swap(arr, middle, newPivotIndex);

    return newPivotIndex;
}
```
**Why this condition ?**
```java
int newPivotIndex = (left_pointer <= middle ? left_pointer: left_pointer - 1);
```
We stop the big while loop if `arr[left_pointer] > pivot`

_ | _ | pivot | _ | left_pointer | _ | _ 


In the above case, we have to swap with `arr[left_pointer-1]` which is less than `pivot` so that lesser element will be on left side.  
<br/>

_ | _ | left_pointer | _ | pivot | _ | _  
 

In the above case, we have to swap with `arr[left_pointer]` which is greater than pivot so that lesser element will be on left side.  
<br />
<br />



Taking below 4 examples for testing the code.

**Example 1:**  
Position of pivot element is left side of its position after sorting

2 | 1 | **4** | 3 | 5  

After sorting, 

2 | 1 | 3 | **4** | 5 


**Example 2:**  
Position of pivot element is right side of its position after sorting

1 | 3 | **2** | 4 | 5 

After sorting, 

1 | **2** | 3 | 4 | 5 


**Example 3:**  
Position of pivot element is left-most after sorting (pivot is the least of all elements in the array)

7 | 8 | **1** | 2 | 6 

After sorting, 

**1** | 7 | 8 | 2 | 6 


**Example 4:**  
Position of pivot element is right-most after sorting (pivot is the highest of all elements in the array)

1 | 4 | **9** | 2 | 6 

After sorting, 

1 | 4 | 2 | 6 | **9** 


## 2. Finding Kth smallest element in an array
We can use the partitioning algorithm to find Kth smallest element in an array.
After partition, 
- if pivot index < k, partition right side of the array
- if pivot index > k, partition left side of the array
- if pivot index = k, we found the kth smallest element 

>Note: pivot index indicates that it will be in that position after array is sorted. We are finding the `k`th position in sorted array. 
```java
int findKthSmallest(int[] nums, int k) {
    int l = 0;
    int r = nums.length - 1;
    int curr = -1;

    while (l <= r) {
        curr = partition(nums, l, r);
        
        if (curr < K) l = curr + 1;
        else if (curr > K) r = curr - 1;
        else break;
    }
    return nums[curr];
}
```
