package practise2025.file_system;

import java.util.Map;
import java.util.TreeMap;

public class FileNode {

    private boolean dir;
    private String name;
    private String content;

    private Map<String, FileNode> children = new TreeMap<>();

    public FileNode(boolean dir, String name, String content) {
        this.dir = dir;
        this.name = name;
        this.content = content;
    }

    public boolean isDir() {
        return dir;
    }

    public void setDir(boolean dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, FileNode> getChildren() {
        return children;
    }

    public void setChildren(Map<String, FileNode> children) {
        this.children = children;
    }
}
