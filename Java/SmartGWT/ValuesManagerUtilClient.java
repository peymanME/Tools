	/**
	 * @author Peyman Ekhtiar
	 * Language " JAVA "
	 * SMARTGWT
	 */
public class ValuesManagerUtilClient {   
	public static void printValuesManager(Map map, boolean printValue){
		int level = 0;
		String space = "";
		runRecursiveChecking( map, level, space, printValue);
	}

	private static void printOut(int level, String s, String space, Map map, boolean printValue, String value){
		String type = "";
		if (printValue) {
			if (value != null)
				value = "  [ value = " + value + " ] ";
			else
				value = "  [ value = null ] ";
			System.out.println(  space + value  );
			return;
		}
		if (map != null && map.get(s) != null)
			type = " type = " + map.get(s).getClass().getName();

		System.out.println( space +" "+ level +" " + s +  type );
	}

	private static void runRecursiveChecking(Map map, int level, String space, boolean printValue){
		if(map == null) return;

		level += 1;
		space += "- ";
		Object[] keys = getKeys(map);
//		Object[] values = new Object[map.size()];
		for (Object key : keys) {
			String keyStr = (String) key;
			printOut(level, keyStr, space, map, false, null);
			if (map.get(keyStr) instanceof String)
				printOut(level, keyStr, space, map, printValue, (String) map.get(keyStr));
			else if (map.get(keyStr) instanceof Boolean ||
					map.get(keyStr) instanceof Integer ||
					map.get(keyStr) instanceof Date ||
					map.get(keyStr) instanceof Character)
				printOut(level, keyStr, space, map, printValue, map.get(keyStr).toString());
			else if (map.get(keyStr) instanceof ArrayList)
				runRecursiveArrayListChecking((ArrayList<Map>) map.get(keyStr), level, space, printValue);
			else if (map.get(keyStr) instanceof Map)
				runRecursiveChecking((Map) map.get(keyStr), level, space, printValue);
		}

	}
	private static void runRecursiveArrayListChecking(ArrayList<Map> maps, int level, String space, boolean printValue){
		int row = 0;
		for (Map map: maps){
			row += 1;
			System.out.println(space + " " + level + " row = " + row);
			runRecursiveChecking(map, level, space, printValue);
		}
	}


	private static Object[] getKeys (Map map){
		return map.keySet().toArray();
	}
}
