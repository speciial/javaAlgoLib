# javaAlgoLib
This library of CLRS algorithms is a work in progress. Over time more algorithms will be added to it. 

## Sorting

Students tend to utilize the data structures provided by the language (such as ArrayList or Queue) but disregard the 
performance drop that comes with them when compared to simple arrays. For this reason, the library contains an 
implementation for both variants (simple array and ArrayList) and a performance comparison as option in the CLI. 

CLRS uses arrays starting with the index 1 up to n inclusive, so the implementations have to be adjusted slightly to 
use zero-based arrays. 

- [x]  Insertion Sort (Standard / ArrayList)
- [x]  Selection Sort (Standard / ArrayList)
- [x]  Heap Sort (Standard / ArrayList)
- [x]  Merge Sort (Standard / ArrayList)
- [x]  Quick Sort (Standard / ArrayList)

### Linear Time Sorting

Something that is almost never covered in introductory courses on algorithms and data structures but nonetheless part 
of the material in CLRS.  

- [ ] Counting Sort
- [ ] Radix Sort
- [ ] Bucket Sort

## Data Structures

### Elementary Data Structures

Stack and Queue use arrays internally to store the elements, meaning we have to adjust the indices such that they apply 
for zero-based arrays.  

- [x] Stack
- [x] Queue
- [x] Linked List
- [ ] Pointers and Objects (?)
- [ ] Rooted Trees (?)

### Hash Tables

### Binary Search Tree

- [x] insert
- [x] search 
- [x] delete
- [x] minimum
- [x] maximum
- [x] successor
- [x] predecessor
- [ ] TESTS

### Red-Black Trees

- [x] insert
- [x] search
- [ ] delete
- [x] minimum
- [x] maximum
- [x] successor
- [x] predecessor
- [ ] TESTS