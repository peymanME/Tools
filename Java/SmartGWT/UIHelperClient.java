	/**
	 * @author Peyman Ekhtiar
	 * Language " JAVA "
	 * SMARTGWT
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
}