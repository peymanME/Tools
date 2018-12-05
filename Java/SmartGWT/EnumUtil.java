class EnumUtil {
    // Object is Enum type
    public static String[] enumNameToStringArray(Object[] values) {
        int i = 0;
        String[] result = new String[values.length];
        for (Object value: values) {
            result[i++] = value.name;
        }
        return result;
    }
}
