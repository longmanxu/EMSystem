
import java.io.*;

/**
 *
 * @author longm
 */
public class Settings {
	private String filePath;
	private String lookAndFeel;
	
	public Settings (String filePath) {
		this.filePath = filePath;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			lookAndFeel = reader.readLine();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public void save(String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(lookAndFeel);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public String getLookAndFeel() {
		return lookAndFeel;
	}

	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}
}