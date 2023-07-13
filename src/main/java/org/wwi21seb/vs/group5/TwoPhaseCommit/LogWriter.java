package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogWriter<T extends Serializable> {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogWriter.class.getName());
    private final String directory;

    public LogWriter() {
        // Set log directory to logs in the user directory
        this.directory = System.getProperty("user.dir") + "/logs";
        LOGGER.log(Level.INFO, "Log directory: " + directory);
        // Create the directory if it doesn't exist
        new File(directory).mkdirs();
    }

    public void writeLog(UUID id, T object) {
        writeObjectToLog(id, object);
    }

    public void deleteLog(String id) {
        File file = new File(directory + "/" + id + ".txt");

        if (file.delete()) {
            // Delete file and log success
            LOGGER.log(Level.INFO, "Successfully deleted log file");
        } else {
            // Log failure
            LOGGER.log(Level.SEVERE, "Failed to delete log file");
        }
    }

    public T readLog(String id) {
        try (FileInputStream fileInputStream = new FileInputStream(directory + "/" + id + ".txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Read object from file
            T object = (T) objectInputStream.readObject();
            LOGGER.log(Level.INFO, "Successfully read log file");
            return object;
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing stream", e);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Class not found", e);
        }

        return null;
    }

    public List<T> readAllLogs() {
        // Get all files in log directory
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        List<T> objects = new ArrayList<>();

        // Read all files
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                // Only read log files
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    // Get id from filename
                    String id = file.getName().replaceFirst("[.][^.]+$", "");
                    // Get object from log file
                    T object = readLog(id);

                    if (object != null) {
                        // Add object to list
                        objects.add(object);
                    }
                }
            }
        }

        return objects;
    }

    private void writeObjectToLog(UUID id, T object) {
        File file = new File(directory + "/" + id.toString() + ".txt");
        file.getParentFile().mkdirs(); // ensure the parent directory exists

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Write object to file
            objectOutputStream.writeObject(object);
            LOGGER.log(Level.INFO, "Successfully written object to log file");
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing stream", e);
        }
    }
}

