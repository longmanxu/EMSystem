
import java.io.*;

/**
 * A class for managing the settings file.
 * @author Longman Xu
 */
public class Settings implements Serializable {
	private String filePath;
	private String lookAndFeel;
	
	// private constructor
	// User should create new instance of Settings using open() or getDefaultSettings()
	private Settings() {
	}
	
	/**
	 * Get a Settings object with default settings.
	 * @param filePath the file path of the settings save file.
	 * @return a Settings with default settings.
	 */
	public static Settings getDefaultSettings(String filePath) {
		Settings newSettings = new Settings();
		newSettings.filePath = filePath;
		newSettings.lookAndFeel = "Windows";
		return newSettings;
	}
	
	/**
	 * Create a new Settings object from a file saved using save()
	 * @param filePath the file path of the file to be opened.
	 * @return a new Settings object from the saved file.
	 * @throws IOException if an IOException is encountered.
	 * @throws ClassNotFoundException If a ClassNotFoundException is encountered.
	 */
	public static Settings open(String filePath) throws IOException, ClassNotFoundException {
		Settings newSettings;
		File saveFile = new File(filePath);
		if (saveFile.isFile()) {
			try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
				newSettings = (Settings) inputStream.readObject();
				return newSettings;
			} catch (IOException | ClassNotFoundException e) {
				throw e;
			}
		}
		return getDefaultSettings(filePath);
	}
	
	/**
	 * Saves the Settings object.
	 * @throws IOException if an IOException is encountered.
	 */
	public void save() throws IOException {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
			outputStream.writeObject(this);
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * Get the look and feel setting.
	 * @return the look and feel setting.
	 */
	public String getLookAndFeel() {
		return lookAndFeel;
	}
	
	/**
	 * Set the look and feel setting.
	 * @param lookAndFeel the look and feel setting.
	 */
	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}
	
	/**
	 * A class for testing.
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Settings a = Settings.open("hwat.txt");
		System.out.println(a.getLookAndFeel());
		a.save();
	}
}