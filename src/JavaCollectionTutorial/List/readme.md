Key feature of the list interface:
Order Preservation
Index-Based Access
Allows duplicates

Adding Elements: 
When we add an element to an arraylist the following steps occur:

Check Capacity: Before Adding the new element, ArrayList checks if there is enough space in the internal array(element Data)
if the array size is full, it needs to be resized.

Resize If Necessary: If the internal array is full, the arraylist will create a new array with a larger capacity (usually 1.5 times
the currenct capacity) and copy the elements from the old array to new array

Add the element: THe new element is then added to the internal array at appropriate index, and the size is incremented.

