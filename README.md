# RangeMap
**RangeMap** is an extension of Java’s **Linked HashMap** that takes a range of numeric values as a key and a singular Object as a value. **RangeMap.get()** is written to allow any key/value pair within a range to be searched by reference without iterating through the collection, even if they haven't been explicitly created or stored in memory.

The **RangeMap** has several use-cases where a numeric range needs to point to a singular object or value.  When working with ranges in data, this allows the user to simulate and reference billions of key/value pairs at comparable efficiency to any other **HashMap** type.  It can also save system memory for cases where system memory is limited.  If the ranges in a **RangeMap** instance are in intervals of 1000, the size of the collection would be ~1000x smaller than an equivalent set of key/value pairs.

Use JDK JavaDoc tool to view doc comments in rendered view

## DEMONSTRATION INSTRUCTIONS

1.	Open Driver.java in your IDE.
2. Ensure **ARange**, **RangeKey**, and **RangeMap** are imported into your project and accessable by **Driver.java**.
3. Create run configuration for **Driver.java**,  and run program.
4.	Follow prompts in command line for demonstrations of the **RangeMap** package.




## RANGEMAP PACKAGE INSTRUCTIONS (not needed for running demo)

1. Create a class and make sure **ARange**, **RangeKey** and **RangeMap** are imported into your class.
 ![image](Picture0.png)

2. Instantiate a new **RangeMap** object and add your range start, range end, and the value or object you want that range of numbers to point to. **RangeMap** also has an alternate constructor that takes two parameters - an **ARange** object and a value - so the keys can be generated anonymously inside the **RangeMap** or elsewhere.
 ![image](Picture1.png)
 


3. Use **RangeMap.get()** to get your value from any number inside the range-key, and any key in the **RangeMap**.
 ![image](Picture2.png)

As per the example in step 2, this map will return a value of 1 since it is the assigned value for any key from 1000 to 2000.



### For Help, reference the RangeMap.Java doc comments, which outline every aspect of the Collection in detail.





