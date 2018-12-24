	/**
	 * @author Peyman Ekhtiar
	 * Language " JAVA "
	 * SMARTGWT
	 * 
	 */
package pl.ui.client.util;


import com.smartgwt.client.data.*;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import org.apache.commons.lang.ArrayUtils;
import javax.persistence.Id;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UIHelperClient {
	/**********************************************
	 * manualFormItemCreator
	 */
	private static manualFormItemCreator _manualFormItemCreator = null;
	private static class manualFormItemCreator{

		manualFormItemCreator(DefaultDynamicForm dynamicForm) {
			this(dynamicForm, 1, 1);
		}
		manualFormItemCreator(DefaultDynamicForm dynamicForm, int columnNo, int formItemsInRowNo){
			this.dynamicForm = dynamicForm;
			this.formItems = dynamicForm.getOriginallyLocatedFields();
			this.mainLayout = new HLayout();
			this.columnNo = columnNo;
			this.formItemsInRowNo = formItemsInRowNo;
		}
		private DynamicForm dynamicForm;
		private HLayout mainLayout;
		private FormItem[] formItems;
		private int columnNo;
		private int rowNo;
		private int indexFormItem = 0;
		private int formItemsInRowNo;
		private List<DynamicForm> dynamicFormsList = new ArrayList<DynamicForm>();

		private int countFormItems(){
			return this.formItems.length;
		}
		private void createColumnsByFormItems (){
			for(int i = 0; i < this.columnNo; ++i){
				this.mainLayout.addMember(this.createRowsOfDynamicForm());
			}
		}
		private HLayout setInLineTowFormItems (FormItem[] formItems) {
			HLayout hLayout = new HLayout();
			DynamicForm form = new DynamicForm();
			form.setWidth100();
			form.setNumCols(this.formItemsInRowNo);
			form.setColWidths("10%", "20%");
			if (formItems.length > 0) {
				form.setFields(formItems);
//            form.setDisabled(true);
				this.dynamicFormsList.add(form);

			}
			hLayout.setHeight(40);
//			hLayout.setID(String.valueOf(this.indexFormItem) );
			hLayout.addMember(form);
			this.mainLayout.getValuesManager().addMember(form);
			return hLayout;
		}
		private VLayout createRowsOfDynamicForm(){
			VLayout vLayout = new VLayout();
			for(int i = 0; i < this.rowNo ; ++i){
				List<FormItem> formItemDets;
				if ((this.indexFormItem+1) == this.formItems.length ) {
					formItemDets = new ArrayList<FormItem>();
					formItemDets.add(this.formItems[this.indexFormItem]);
				}
				else
					formItemDets = Arrays.asList(this.formItems).subList(this.indexFormItem, this.formItemsInRowNo+ this.indexFormItem);
				this.indexFormItem += this.formItemsInRowNo;
				vLayout.addMember(setInLineTowFormItems (formItemDets.toArray(new FormItem[0])));
				if ((this.indexFormItem) == this.formItems.length )
					return vLayout;
			}
			return vLayout;
		}
		public HLayout createMainLayour(){
			ValuesManager valuesManager = new ValuesManager();
			this.mainLayout.setValuesManager(valuesManager);
			int formItemsNo = this.countFormItems();
			this.rowNo = (formItemsNo + this.columnNo - 1 ) / this.columnNo;
			this.createColumnsByFormItems();
			return this.mainLayout;
		}
	}

	public static HLayout createManuallyDynamicFrom(DynamicForm dynamicForm, int columnNo, int formItemsInRowNo) {
		_manualFormItemCreator = new manualFormItemCreator(dynamicForm, columnNo, formItemsInRowNo)	;
		return _manualFormItemCreator.createMainLayour();
	}

	/**********************************************
	 * 
	 */
	private static String[] checkingToRequiredCanvasArray(DefaultVLayout layout, String[] listFields){
		return checkingToRequiredCanvasArray(layout,null, listFields);
	}
	private static String[] checkingToRequiredCanvasArray(HLayout layout, String[] listFields){
		return checkingToRequiredCanvasArray(null,layout, listFields);
	}
	private static String[] checkingToRequiredCanvasArray(DefaultVLayout vLayout, HLayout hLayout, String[] listFields){
		Canvas[] can = null;
		if (vLayout!= null)
			can = vLayout.getMembers();
		if (hLayout!=null)
			can = hLayout.getMembers();
		if (can == null)
			return new String[]{};
		for (Canvas c: can){
			System.out.println(" ==== c = " + c.getTitle());
			if (c instanceof DynamicForm){
				listFields = getRequieredFieldsArray((DynamicForm)c, listFields);
			}else if (c instanceof DefaultVLayout){
				listFields = checkingToRequiredCanvasArray((DefaultVLayout)c, listFields);
			}else if (c instanceof HLayout){
				listFields = checkingToRequiredCanvasArray((HLayout)c, listFields);
			}
		}
		System.out.println( " === checkingToRequiredCanvasArray" );
		return listFields;

	}

	private static String[] getRequieredFieldsArray (DynamicForm form, String[] fieldsArray ){
		List<String> fields;
		if (fieldsArray.length == 0){
			fields = new LinkedList<String>();
		} else {
			fields = Arrays.asList(fieldsArray);
		}
		for (FormItem formItem : form.getFields()) {
			if (formItem.getRequired() != null && formItem.getRequired())
				fields.add(formItem.getName());
		}
		if (fields.size()>0)
			return fields.toArray(new String[0]);
		return new String[]{};
	}

	private static String[] getRequiredFields (Object object, String[] fields){
		if (object instanceof DynamicForm) {
			fields = getRequieredFieldsArray((DynamicForm)object, fields);
		} else if (object instanceof VLayout){
			fields = checkingToRequiredCanvasArray((VLayout)object, fields);
		}
		if (fields.length>0)
			return fields;
		return new String[]{};
	}
	
	
/**********************************************
 *  To check value with a specific path on the map in client side
 */
	private static class CheckingValues {
		private String[] ObjectNames;
		private Map mainValues;
		public boolean hasValue = true;
		private Object value;
		public Object getValue() {
			return value;
		}

		CheckingValues(Map values, String path){
			this.ObjectNames = path.split("/");
			this.mainValues = values;
			checkingValues();
		}

		private Object checkingValue(String objectName, Map objectMap){
			if (objectMap == null) {
				if (this.mainValues.get(objectName) != null)
					return this.mainValues.get(objectName);
			}
			else {
				if (objectMap.get(objectName)!= null)
					return objectMap.get(objectName);
				}
			return null;
		}
		private void checkingValues(){
			Object object = null;
			int j = this.ObjectNames.length;
			for (int i=0; i < j ;++i) {
				String objectName = this.ObjectNames[i];
				object = this.checkingValue(objectName, (Map)object);
				if (object == null) {
					this.hasValue = false;
					break;
				}
			}
			this.value = object;
		}
	}
	private static CheckingValues _checkingValues;
	public static boolean is_EmptyOrNull(Map values, String path){
		_checkingValues = new CheckingValues(values, path);
		if (_checkingValues.hasValue && _checkingValues.value instanceof String)
			return ((String)_checkingValues.value).isEmpty();
		return !_checkingValues.hasValue;
	}
	public static Object getValue(){
		return _checkingValues.getValue();
	}
/**********************************************************************/	
	
	
	
	
	
	
	
	
	
}