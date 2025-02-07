package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;

public  class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.storage = new HashMap<>(initialData);
        saveToFile();
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

    private void loadFromFile() {
        String content = Utils.readFile(filePath);
        if (!content.isEmpty()) {
            storage = Utils.deserialize(content);
        }
    }

    private void saveToFile() {
        String json = Utils.serialize(storage);
        Utils.writeFile(filePath, json);
    }
}
// END
