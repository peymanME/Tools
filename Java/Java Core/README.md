# JAVA CORE

# Notes

## @Deprecated:

Since Java 1.5, programmers can use the @Deprecated annotation type to mark a program’s element (class, method, field and constructor) deprecated. The following are some examples.

### Example:

``` bash

	@Deprecated
	class Foo {
	 
		// class implementation
	 
	}
```

## String

1. We do String manipulation like concat, substring etc.
2. These are heavy operations and generate a lot of garbage in heap.
3. It is immutable

## StringBuffer VS. StringBuilder

1. A thread-safe, mutable sequence of characters use StringBuffer.
2. StringBuffer is synchronized, StringBuilder is not.
3. StringBuffer and StringBuilder are mutable objects in java and provide append(), insert(), delete() and substring() methods for String manipulation.
4. These ara mutable.
5. StringBuilder is more faster than StringBuffer.

## final keywords:

Final keyword has a numerous way to use:

1. A final class cannot be subclassed or a final class cannot be extended(inherited)
2. A final method cannot be overridden by subclasses. 
3. A final variable can only be initialized once. Its value can’t be modified, essentially, a constant.
- Final variable can be assigned value later, but only once.
- Final variable, internal state of the object pointed by that reference variable can be changed. Note that this is not re-assigning. This property of final is called non-transitivity.
- Final with foreach loop : final with for-each statement is a legal statement.
``` bash

    int arr[] = {1, 2, 3}; 
          
        // final with for-each statement 
        // legal statement 
        for (final int i : arr) 
            System.out.print(i + " "); 
    }  
```
Other usage:
4. When an anonymous inner class is defined within the body of a method, all variables declared final in the scope of that method are accessible from within the inner class