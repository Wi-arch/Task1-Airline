package by.education.airline.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Reader {

	private final static Logger LOGGER = Logger.getLogger(Reader.class);

	private Reader() {
	}

	private static class ReaderInstanse {
		private final static Reader INSTANCE = new Reader();
	}

	public static Reader getInstance() {
		return ReaderInstanse.INSTANCE;
	}

	public String readStringFromFile(String path) {

		StringBuilder result = new StringBuilder();

		File file = new File(getClass().getClassLoader().getResource(path).getPath());
		if (!file.exists()) {
			LOGGER.fatal("File to initialize application not found " + path);
			throw new RuntimeException("File " + path + " not found");
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = reader.readLine();
			while (line != null) {
				result.append(line + "\r\n");
				line = reader.readLine();
			}

		} catch (IOException e) {
			LOGGER.warn(e);
		}
		return result.toString();
	}

}
