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