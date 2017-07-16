/**
 * @author Zulkarnain Shah
 * @date 16-Jul-2017
 */

package messageapi.models;

public class TestClass {
	private final long id;
	private final String data;
	
	public long getId() {
		return id;
	}
	public String getContent() {
		return data;
	}
	
	public TestClass(long id, String data) {
		this.id = id;
		this.data = data;
	}
}
