    class ArrayUtil {
	    	// To merge two string array.
		public static String[] mergeArray (String[] a, String[] b){
			List list = new ArrayList(Arrays.asList(a));
			list.addAll(Arrays.asList(b));
			String[] stringArray = (String[]) list.toArray(new String[0]);
			return stringArray;
		}
	    	// To know a string exist in the string array.
		public static boolean exist (String[] stringArrays, String yourString){
			return Arrays.asList(stringArrays).contains(yourString);
		}
	}
