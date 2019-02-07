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
 
# UIHelperClient

1. To check value with a specific path on the map in client side
	
## Example:

``` bash
	if (!UIHelperClient.is_EmptyOrNull(record.toMap(),"[PATH]"){    // PATH like student/name
		// dosomthing
		String [VARIABLE] = (String)UIHelperClient.getValue();				// VARIABLE like name
	}

```	
2. To create dynamic form when you want to have constant locate for a form item(s) 

## Example:
``` bash 

	hLayout = UIHelperClient.createManuallyDynamicFrom([YourDynamicForm], [NumberOfColumnYouWant], [LayoutPatternOfFormItems]);
	
	// set field to main form
	for(DynamicForm defaultDynamicForm: hLayout.getValuesManager().getMembers())
            valuesManager.addMember(defaultDynamicForm);

	
```
# Notes:

### Class DateTimeFormat:
 
To convert Date to String in client side, use format method of DateTimeFormat class.
				
#### Example:
```bash

	DateTimeFormat fd = DateTimeFormat.getFormat("yyyy-MM-dd");
	String s  = fd.format(Date);	
```

# PdfBuilderFromHTMLUtil

If you are using iText libraries to create a PDF file from a html file, the class help you to change default font of pdf document to encoding font.

## Example:
``` bash
		// rpc is RPCManager
		rpc.doCustomResponse();
		HttpServletResponse response = rpc.getContext().response;

		Font font = FontFactory.getFont("./src/main/webapp/fonts/Serif.ttf", BaseFont.IDENTITY_H); // IDENTITY_H works for unicode
		Paragraph p = new Paragraph();
		p.setFont(font);
		
		Document document = new Document(PageSize.A4);
		ServletOutputStream out = response.getOutputStream();

		PdfWriter writer = PdfWriter.getInstance(document, out);


		document.open();

		PdfBuilderFromHTMLUtil pdfBuilderFromHTMLUtil = new PdfBuilderFromHTMLUtil();
		pdfBuilderFromHTMLUtil.PdfBuilder([YOUR HTML], font, p);  // YOUR HTML
		document.add(p);	
		document.close();
		out.flush();
		out.close();
	
```
			
