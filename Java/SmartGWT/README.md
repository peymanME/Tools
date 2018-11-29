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
 
 Notes:
        # Class DateTimeFormat: Formats and parses dates and times using locale-sensitive patterns in client side.
		
		
		## Example:
		```bash
			DateTimeFormat fd = DateTimeFormat.getFormat("yyyy-MM-dd");        //to convert Date to String in client side, use format method of DateTimeFormat class.
			String s  = fd.format(Date);
		```
			