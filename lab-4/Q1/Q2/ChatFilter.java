public class ChatFilter {

	public static String filterLogs(String[] logs, String keyword) {
		
		String lowerKey = keyword.toLowerCase();
		StringBuilder report = new StringBuilder();
		int count = 0;

		for (String line : logs) {
	
			String[] parts = line.split(" ", 3);
			
			if (parts.length < 3) continue; 
			
			String time = parts[0];
			String user = parts[1];
			String message = parts[2];
			
			
			if (message.toLowerCase().contains(lowerKey)) {
				count++;
				report.append(time).append(" ").append(user).append(": ").append(message).append("\n");
			}
		}

		StringBuilder result = new StringBuilder();
		result.append("Matches: ").append(count).append("\n");
		result.append(report.toString());
		return result.toString();
	}

}