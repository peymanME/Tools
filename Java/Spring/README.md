# Spring



# Notes

## @Autowired:

This annotation allows Spring to resolve and inject collaborating beans into your bean.
The @Autowired annotation is auto wire the bean by matching data type.
1. @Autowired on Properties
2. @Autowired on Setters
3. @Autowired on Constructors
4. @Autowired and Optional Dependencies

## @Qualifier:

it uses to provide various implementations of a particular bean type.

## @SuppressWarnings: 

It allows Java programmers to disable compilation warnings for a certain part of a program (type, field, method, parameter, constructor, and local variable).
Normally warnings are good. However in some cases they would be inappropriate and annoying.
So programmers can choose to tell the compiler ignoring such warnings if needed.

### 1. @SuppressWarnings("unchecked")
To see the list of warnings which would be issued by the Oracle’s Java compiler, type the following command:
 
``` bash

	> javac -X
```
If we use without "unchecked" like @SuppressWarnings()annotation, the compiler will complain like this:

``` bash

	XYZ.java uses unchecked or unsafe operations.
```

### 2. @SuppressWarnings("deprecation")

If we use without "deprecation" like @SuppressWarnings()annotation, the compiler will complain like this:

``` bash

	XYZ.java uses or overrides a deprecated API.
```

## POINTs

When you want to use MYSQL database you should consider the following:
``` bash
spring.datasource.url = jdbc:mysql://localhost:3306/[DATABASE_NAME]?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```
