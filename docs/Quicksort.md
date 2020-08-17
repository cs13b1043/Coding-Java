# Quick Sort

Today, I'm trying to solve a problem in leetcode [Wiggle Sort II](https://leetcode.com/explore/interview/card/top-interview-questions-hard/120/sorting-and-searching/857/).
I couldn't come up with any algorithm which works especially when there are duplicates in the array. Then I looked into the solution.

It uses **Partition Algorithm of Quick Sort** to find the Median of the array in **O(n)** time without sorting the array.

Though the concept of quicksort is clear to me, I never used it often as it's worse case time is O(n<sup>2</sup>). I used to prefer Merge sort and got pretty comfortable with Merge sort.
But today when I tried to program quick sort in Java, I faced a challenge while coding partition algorithm.
So I decided to work on quicksort and algorithms related to it.

1. Quicksort program in Java
2. Finding kth largest element in an array (can be used to find median)
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

