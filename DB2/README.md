# DB2
 
# Notes:
 
## GLOBAL:

To filter COLUMN_NAME on tables of database

```bash 
	
	SELECT TBNAME,NAME,COLTYPE,LENGTH,SCALE FROM SYSIBM.SYSCOLUMNS WHERE NAME = [COLUMN_NAME];
```
## INSERT:

Insert value into the table if it is not exist: 
 
### Example: 

``` bash

	INSERT INTO [TABLE_NAME] ([Fields])
	SELECT [FIELDs VALUEs] FROM SYSIBM.SYSDUMMY1
	WHERE NOT EXISTS(SELECT [IDFIELD] FROM [TABLE_NAME] WHERE [CONDITION]);
```

## WHERE: 

A condition to filter a date with the specific format

### Example:

``` bash 

	WHERE VARCHAR_FORMAT ([DATE_FIELD_NAME] ,'[FORMAT_PATTERN]') = '[YOUR_DATE]'     --// FORMAT_PATTERN like YYYY-MM-DD , YOUR_DATE like 2018-09-09
```	

