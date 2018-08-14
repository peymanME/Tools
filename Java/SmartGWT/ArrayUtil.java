    class ArrayUtil {
		private static String[] mergeArray (String[] a, String[] b){
			List list = new ArrayList(Arrays.asList(a));
			list.addAll(Arrays.asList(b));
			String[] stringArray = (String[]) list.toArray(new String[0]);
			return stringArray;
		}
	}
