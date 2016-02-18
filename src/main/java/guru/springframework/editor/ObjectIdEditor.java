package guru.springframework.editor;

import java.beans.PropertyEditorSupport;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;

public class ObjectIdEditor extends PropertyEditorSupport {

	public ObjectIdEditor() {
	}

	public ObjectIdEditor(boolean status) {
		super(status);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("SET AS TEXT " + text);
		if (text != null)
			setValue(new ObjectId(text));

	}

	@Override
	public String getAsText() {
		if (getValue() != null) {
			System.out.println("GET AS TEXT " + getValue().toString());
			return String.valueOf(getValue().toString());
		}
		return "";
	}
}
