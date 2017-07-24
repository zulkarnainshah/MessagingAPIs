/**
 * @author Zulkarnain Shah
 * @date 24-Jul-2017
 */
package messageapi.models;

import messageapi.utils.Constants;

public class ServerResponse {

	String serverMessage;

	private ServerResponse(String message) {
		this.serverMessage = message;
	}

	public static ServerResponse conflict(String message) {
		if (message != null) {
			return new ServerResponse(message);
		} else {
			return new ServerResponse(Constants.Strings.CONFLICT);
		}
	}

	public static ServerResponse success(String message) {
		if (message != null) {
			return new ServerResponse(message);
		} else {
			return new ServerResponse(Constants.Strings.SUCCESS);
		}
	}

	public static ServerResponse warning(String message) {
		if (message != null) {
			return new ServerResponse(message);
		} else {
			return new ServerResponse(Constants.Strings.WARNING);
		}
	}

	public static ServerResponse error(String message) {
		if (message != null) {
			return new ServerResponse(message);
		} else {
			return new ServerResponse(Constants.Strings.ERROR);
		}
	}

	public static ServerResponse notFound(String message) {
		if (message != null) {
			return new ServerResponse(message);
		} else {
			return new ServerResponse(Constants.Strings.NOT_FOUND);
		}
	}

	public String getServerMessage() {
		return serverMessage;
	}

	public void setServerMessage(String message) {
		this.serverMessage = message;
	}
}
