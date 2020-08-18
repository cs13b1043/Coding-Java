# Linked List - Cycle Detection Algorithm
We will see why Floyd's algorithm works and solve one problem based on this algorithm.

## Floyd's algorithm
**Steps:**

To detect a cycle in a Linked List and to find the starting point,
1. Take two pointers, `tortoise` which goes at speed 1 and `hare` which goes at speed 2.
2. Since these two pointers go at different speed, if there is a cycle these two pointers meet after sometime.
3. Leave `tortoise` at the same position and move `hare` back to start of the list.
4. Now make these two go at speed 1 and find where they meet again. This is the start of the cycle.
> Here speed 1 means, in each iteration go to the next element. `tortoise = tortoise.next`.  
> Speed 2 means, in each iteration go to 2nd next element. `hare = hare.next.next`.

**Why it works?**

If there is a cycle, the two pointers will meet after sometime since they are going at different speed.
Now to find the start of the cycle, let's assume the following:
- `i`: nodes before start of the cycle
- `len`: cycle length
- `x`: index from start of LinkedList where the two pointers meet

<img src="https://render.githubusercontent.com/render/math?math=(x-i)%20\mod%20len=(2x-i)%20\mod%20len" />

`hare` completes one rotation of cycle by the time `hare` and `tortoise` meet.
- Distance travelled by `tortoise` = <img src="https://render.githubusercontent.com/render/math?math=x" />
- Distance travelled by `hare` = <img src="https://render.githubusercontent.com/render/math?math=x%2Blen*1" />

Since `hare` is moving at double speed, 
- Distance travelled by `hare` = 2 * Distance travelled by `tortoise`
- <img src="https://render.githubusercontent.com/render/math?math=x%2Blen*1%20=%20x" />
- <img src="https://render.githubusercontent.com/render/math?math=x%20=%20len" />

To find start of the cycle, we have to traverse <img src="https://render.githubusercontent.com/render/math?math=len-(x-i)%2B1 = i%2B1" /> from where they met.

![Example](/assets/images/Floyd-cycle.png)

So, the pointer from the meeting point and the pointer from start of LinkedList meets at start of cycle when they go at speed 1.
