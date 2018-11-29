# ValuesManagerUtilClient

You can find the key level and its value through of the code.
## Example:
	if printValue set to TRUE value it shows value of each key on your console. 

 ```bash
 
	
		ValuesManagerUtilClient.printValuesManager((Map) getValuesManager().getValues(), true) 
 ```

# RecordUtilClient

	TO compare tow records.
	
## Example:
	

 ```bash
 
	
		RecordUtilClient.recordsCompareValues(recordNew.toMap(), recordOld.toMap())
 ```
 
# Notes:
### Class DateTimeFormat: To convert Date to String in client side, use format method of DateTimeFormat class.
		
		
#### Example:
```bash

	DateTimeFormat fd = DateTimeFormat.getFormat("yyyy-MM-dd");
	String s  = fd.format(Date);
	
```
			