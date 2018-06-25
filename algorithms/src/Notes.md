1. Read the question carefully, identify the keywords (_unique_, _positive_,
 _non-negative_, _unsorted_), datatypes, data structures and the problems'
 constraints.
 2. Ask yourself, what happens when the input is _null_ or _negative_ or 
 _postive_. Typically these form the edge cases.
 3. Figure out a _naive_ solution, at the very least, analyze its complexity
 (O(n)?, O(n^2)?, O(nlog(n))?). Also, analyze the implementation complexity :
 no.of lines of code, ease of writing the code, etc. If you are okay with both,
 it's fairly simple to implement and complexity meets the runtime constraints,
 go ahead and code it away.
 4. If the naive solution looks like not going to work, then keep optimizing
 your soultion both for code and implementation complexity. Note that implemen-
 tation complexity is equally important, never complicate your code. **Always**
 double check it before starting to code (there can be simpler ways!). In most
 cases your code should work without debugging. Practice it!
 5. In coding competitions, no.of problems you solve matters most. So, don't
 over optimize, something that can run just within the time limits is enough.
 However, once you finish, come back and figure out the best possible solution.
 Look at top submissions, learn from them.
 
 #### Debugging
 1. Check if the edge cases, as identified while reading the problem statement
 run correctly.
 2. Implementations introduce new corener cases. This is almost always true for
 _for-loops_.
 <pre>
 // what happened to i == 0? Did you set the initial result and 'b'?
 for (int i = 1; i < list.length() && b > 0; b++) {
    // what is the program state when you enter? 
    // In particular, when you enter for the first time?
    // All the invariants hold in every loop?
    .....
    .....
    .....
    .
    .
    ..
    // All the increments, updates taken care? Invariants restored?
 }
 
 // You reach here in two states, l >= list.length() or when b <= 0.
 // Take care of both cases, and updates are to be made accordingly.
</pre>
3. If your code still doesn't work, and you fell your logic is "_correct_",
start from line #1 and ask **"WHY"** that line of code is correct. Have a 
flxeible mindset, be ready to tear apart your whole logic, accept your mistakes
and correct them. Never panic, spoil your mood. There are other problems to be
solved, just MOVE ON.
4. Improve you debugging skills, pinpoint the error, then identify the root
cause (could be solution or implementation logic), and finally rectify it. Get
better at using your IDE's debugger.
5. Some common mistakes that we make: library calls (wrong arguments or results)
, integer overflow, etc.

#### 100 Easy Problems Revision:
- Linked Lists : Reversing a linked list (prev, curr), fast and slow pointers,
palindrome (fast/slow gives mid, reverse from mid and check if equal), delete
given just that node.
- Trees: symmetric, depth, root-to-leaf paths, etc. all by recursion
- BST: ceiling (whenever you get a greater val, update and go left, else right)
 and floor.
 - Binary search: include the start and end ([start ... end]), mid = start + 
 (end-start)/2. Use binary search whenever you know that your answer is in a
 given range ([1 .. n]), and you don't want to loop the entire range.
 - Beware of redundant counting in permuations, combinations etc.
 - Bits: signed(>>), unsigned shift(>>>). Use unsigned shift, else negative
 numbers never become zero, but look out for big positive values. Numbers are
 represented in their two's complement form. for -12, flip the binary
 representation and add 1, gives you -12. Flipping and adding 1 to
 a number always gives its two's complement. Adding a N-bit number and its two's
 compelement gives you 2^N (1 followed by N zeroes).
 - Maps are quite useful for constant time lookup/insert/delete operations, can
 reduce your runtime by an order.
 - Math problems : follow a pattern (simple formula). or some number theory (
 divisors, prime factors, primes, etc).
 - Two-players: both play optimally, so you will easily get a pattern (N % p),
 try out for the first few cases.
 
 #### 100 Medium Problems Revision:
 - LongestPalindrome Substring: In these cases, convert the sub problem to
 isPlaindrome(i, j) = isPalindrome(i+1, j-1) || isPlaindrome(i+1, j) ||
 isPlaindrome(i, j-1). You need to know the start and end indices of the
 subproblem too.
 - Two pointer approach : Problem #8 -> Start with two pointers, one at each 
 end of the array, and update one of them carefully.
 - TwoSum, 3Sum, 4Sum : use map for 2Sum, gives O(n). 3Sum, 4Sum, 3SumClosest
 all can benefit from sorting since it takes O(n^2) anyway. Sort and then use
 2 pointers approach. To avoid duplicates always consider triples with indices
 i <= j <= k.