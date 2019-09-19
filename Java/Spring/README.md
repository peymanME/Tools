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

1. When you want to use MYSQL database you should consider the following:
``` bash
spring.datasource.url = jdbc:mysql://localhost:3306/[DATABASE_NAME]?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```

2. To add the properties on your proxy object that breaks the JSON serialization to that annotation.
``` bash
	spring.jackson.serialization.fail-on-empty-beans=false
```

## Redirect to external url

```bash
@RequestMapping("/goto")
public RedirectView localRedirect() {
    RedirectView redirectView = new RedirectView();
    redirectView.setUrl("http://www.yahoo.com");
    return redirectView;
}
```
## Get Path of file 
Using in controller
```bash
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource([Your/file/name]);
```

## CRON in Spring

These are valid formats for cron expressions:

* 0 0 * * * * = the top of every hour of every day.
* */10 * * * * * = every ten seconds.
* 0 0 8-10 * * * = 8, 9 and 10 o'clock of every day.
* 0 0 6,19 * * * = 6:00 AM and 7:00 PM every day.
* 0 0/30 8-10 * * * = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
* 0 0 9-17 * * MON-FRI = on the hour nine-to-five weekdays
* 0 0 0 25 12 ? = every Christmas Day at midnight
The pattern is:
    second, minute, hour, day, month, weekday

