# JAVA CORE

- Java is always “pass by value”

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

## HashMap VS. Hashtable

1. A Hashtable is synchronized and does not allow null keys or values.
2. One of HashMap's subclasses is LinkedHashMap
3. HashMap can be synchronized by Collections.synchronizeMap(hashMap)

## finally

Always not execute in a scenario such as an invocation of a “System.exit()” function, an infinite loop, or system crash, etc.

## reflection

Reflection is used to describe code that is able to inspect other code in the same system.

## java.util.Collections

This class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, "wrappers", which return a new collection backed by a specified collection, and a few other odds and ends.

### Collections.sort(): 
The method is present in java.util.Collections class. It is used to sort the elements present in the specified list of Collection in ascending order.

### java.util.Comparator (interface):
A comparison function, which imposes a total ordering on some collection of objects. Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a natural ordering.

``` bash

List<Entity> [listEntity] = entityDAO.findByParam(Restrictions.eq([field], [value]));

Collections.sort([listEntity], new Comparator<[Entity]>() {
					@Override
					public int compare([Entity] o1, [Entity] o2) {
						return (o1.getIdEntity() > o2.getIdEntity() ? -1 : (o1.getIdEntity() == o2.getIdEntity() ? 0 : 1));
					}
				});
```				
				