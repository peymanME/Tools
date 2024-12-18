# Flutter

## Common flutter command
### To add package
```cmd
 flutter pub add <package>
```
### To remove package
```cmd
 flutter pub remove <package>
```
### To add package to dev
```cmd
 flutter pub add --dev <package>
```
### Set Up a New Package Project
```flutter
flutter create --template=package my_library_name
```
## To test project
```cmd
flutter test <test project path>
```

---

## Mockito command
### To build mock classes
```flutter
flutter pub run build_runner build --delete-conflicting-outputs
```

---

### Test coverage pages
```flutter
genhtml coverage/lcov.info -o coverage/html
```

## References
- [Create a project](https://docs.flutter.dev/reference/flutter-cli?gclid=CjwKCAjw7c2pBhAZEiwA88pOFxDVj7EIL-tpmke6dxRNqZzJ611wFF883vhQf1dhzlCcThA5693VhBoCo94QAvD_BwE&gclsrc=aw.ds)
- [test](https://pub.dev/packages/test#running-tests)

# 
```
flutter run -d chrome -v
```
or 
```
flutter run -d edge -v
```
or
```
flutter run web -v
```
or 
```
flutter run -d chrome --profile
```
