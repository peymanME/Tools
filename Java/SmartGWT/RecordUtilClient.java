	/**
	 * @author Peyman Ekhtiar
	 * Language " JAVA "
	 * SMARTGWT
	 */
public class RecordUtilClient {   

	private static Object[] getKeys (Map map){
		return map.keySet().toArray();
	}
	
	private static boolean isExceptKey(String[] keys, String key){
		return Arrays.asList(keys).contains(key);
	}
	
	public static boolean recordsCompareValues (Map newRecord, Map oldRecord, String[] exceptKeys){
		System.out.println( " Invoked recordsCompareValues" );
		if(newRecord == null || oldRecord == null) return false;

		Object[] newKeys = getKeys(newRecord);

		System.out.println( " newKeys = " + newKeys.length );

		for (Object key : newKeys) {
			String keyStr = (String) key;
			if ( exceptKeys!= null && isExceptKey(exceptKeys, keyStr)) continue;
			if (newRecord.get(key) == null || oldRecord.get(key) == null)
				return false;
			String newRecordValue = newRecord.get(key).toString();
			String oldRecordValue = oldRecord.get(key).toString();
//			System.out.println( " newRecord keyStr = " + keyStr + ", value = " + newRecordValue);
//			System.out.println( " oldRecord keyStr = " + keyStr + ", value = " + oldRecordValue);
			if ((newRecordValue==null && oldRecordValue!=null)
					|| (newRecordValue!=null && oldRecordValue==null)
					|| (newRecordValue!=null && oldRecordValue!=null && !newRecordValue.equals(oldRecordValue))){
				return false;
			}
		}
		return true;
	}

}
