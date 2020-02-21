package [YOUR PACKAGE]

        import java.lang.reflect.InvocationTargetException;
        import java.lang.reflect.Method;
        import java.lang.reflect.Modifier;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/*
* Created by
* @author peyman.ekhtiar on 11/12/2019
*/
public class DataValuesUtils {

    private static String getNameClassDTO (String className){
        String[] p = className.split("\\.");
        return discardStr(p[p.length -1], "DTO");
    }

    private static String getNameProperty (String methodName){
        return discardStr(methodName, "get").toLowerCase();
    }

    private static String discardStr (String classDTOName, String targ){
        if (classDTOName.contains(targ))
            return classDTOName.replace(targ, "").toLowerCase();
        return classDTOName.toLowerCase();
    }

    private static boolean isClassEntity (String typeName){
        return (typeName.contains("[ROOT YOUR PACKAGE]"));
    }

    private static String[] getObjectNamesGetter (String path){
        String[] objectNames = path.split("\\.");
        for (int i=0;objectNames.length > i; ++i){
            objectNames[i]= getMethodGetterName(objectNames[i]);
        }
        return objectNames;
    }

    private static Object getValueFromKlass ( String objsNameGetter, Class klass, Object object){
        try {
            Method method = klass.getMethod (objsNameGetter, null);
            return method.invoke(object,null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getValueFromMethedGetter (String[] objsNameGetters, Class klass, Object object){
        Object objValue = null;
        for (String objsNameGetter: objsNameGetters) {
            objValue = getValueFromKlass(objsNameGetter, klass, object);
            if (objValue == null) return "";
            if (isClassEntity (objValue.getClass().getTypeName())){
                klass = objValue.getClass();
                object = objValue;
            }
        }
        return objValue;
    }

    private static String getMethodGetterName (String objName){
        return "get"+ objName.substring(0, 1).toUpperCase() + objName.substring(1);
    }

    public static Map<String, Object> getPathValues (Class klass, Object obje){
        Map<String, Object> result = new HashMap<>();
        return getPathValues(getNameClassDTO(klass.getName())+".", klass, obje, result);
    }

    public static Map<String, Object> getPathValues (String root, Class klass, Object obje, Map<String, Object> result){
        for (Method method : klass.getMethods())
            if ((method.getModifiers() & Modifier.STATIC) == 0)
                if (method.getName().contains("get"))
                    try {
                        if (method.getName().toLowerCase().contains("class")){
                            continue;
                        }
                        if (method.invoke(obje,null) != null) {
                            String pro = getNameProperty(method.getName());
                            if (isClassEntity (method.invoke(obje,null).getClass().getTypeName())){
                                getPathValues(root+pro+".", method.invoke(obje,null).getClass(), method.invoke(obje,null), result);
                            } else {
                                result.put(root + pro, method.invoke(obje, null));
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        continue;
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        continue;
                    }
        return result;

    }

    public static List<Object> getValuesByPaths (String[] paths, Class klass, Object object){
        List<Object> valueList = new ArrayList<>();
        for (int i=0; paths.length > i; ++i){
            if (paths[i].isEmpty()){
                valueList.add("");
                continue;
            }
            if (paths[i].contains("/")){
                String[] paths2 = paths[i].split("/");
                List<Object> valueList2 = getValuesByPaths(paths2, klass, object);
                String con = concatinat(valueList2);
                valueList.add(con);
                continue;
            }
            String[] objsNameGetters = getObjectNamesGetter(paths[i]);
            Object value = getValueFromMethedGetter (objsNameGetters, klass, object);
            valueList.add(value);
        }
        return valueList;
    }

    public static String concatinat (List<Object> stringList){
        List<String> strings = new ArrayList<>();
        for (int i=0; i<stringList.size();++i){
            strings.add(String.valueOf(stringList.get(i)));
        }
        return  String.join("; ", strings);
    }

}
