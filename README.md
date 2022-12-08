# RangeMap
RangeMap is an extension of Java’s Linked HashMap that takes a range of numeric values as a key to a singular value in system memory. Calling RangeMap.get() for any number within a range-key will produce the corresponding value for that range/value pair.

The RangeMap get() method finds the appropriate key by dividing the input parameter by the
interval of the RangeMap Object's keys, and then passes the Object key to the superclass’s get() method.  This allows any key/value pair, even those that aren’t explicitly initialized, to be searched by reference.

The RangeMap has several use-cases where a range of values needs to point to a singular object or value.  The Object can be a primitive, Object, or another nested range/value pair.  When working with ranges in data, this allows the user to simulate and reference billions of key/value pairs at comparable efficiency to any other HashMap type.  RangeMap can also save system memory for instances where system storage is limited.  If the ranges in a RangeMap instance are in intervals of 1000, the storage size of the collection would be 1000x smaller than an equivalent set of key/value pairs.

Use JDK JavaDoc tool to view doc comments in rendered view
![image](https://user-images.githubusercontent.com/92828306/206587508-3b1f3eb1-4cb8-4434-960c-73970cf35189.png)

