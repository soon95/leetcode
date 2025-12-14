package practise2025.file_system;

import java.util.ArrayList;
import java.util.List;


public class FileSystem {
    private final FileNode root;

    // 构造函数：默认创建根目录
    public FileSystem() {
        this.root = new FileNode(true, "/", null);
    }

    /**
     * 列出路径下的文件/目录（字典序）
     */
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        FileNode current = resolvePath(path);

        if (current == null) {
            return result; // 路径不存在，返回空列表（或抛出异常，根据需求调整）
        }

        if (current.isDir()) {
            // 目录：返回所有子节点名称（TreeMap已按字典序排序）
            result.addAll(current.getChildren().keySet());
        } else {
            // 文件：返回自身名称
            result.add(current.getName());
        }

        return result;
    }

    /**
     * 创建目录（递归创建中间目录）
     */
    public void mkdir(String path) {

        List<String> partList = parsePath(path);
        if (partList.isEmpty()) {
            return;
        }

        FileNode current = root;

        for (String part : partList) {

            // 若子节点不存在，创建目录
            current.getChildren().putIfAbsent(part, new FileNode(true, part, null));

            FileNode child = current.getChildren().get(part);
            if (!child.isDir()) {
                throw new RuntimeException("路径中的'" + part + "'不是目录，无法创建子目录");
            }

            current = child;
        }
    }

    /**
     * 创建/追加文件内容
     */
    public void addContentToFile(String filePath, String content) {
        // 分割路径，获取目录部分和文件名
        List<String> partList = parsePath(filePath);

        List<String> dirPartList = partList.subList(0, partList.size() - 1);
        String fileName = partList.getLast();

        // 解析目录路径（若不存在则创建）
        String dirPath = String.join("/", dirPartList);
        FileNode dir = resolvePath(dirPath);
        if (dir == null) {
            mkdir(dirPath); // 递归创建目录
            dir = resolvePath(dirPath);
        }

        if (dir == null) {
            throw new IllegalArgumentException("路径不存在");
        }

        if (!dir.isDir()) {
            throw new RuntimeException("'" + dirPath + "'不是目录，无法创建文件");
        }

        // 获取或创建文件
        FileNode file = dir.getChildren().get(fileName);
        if (file == null) {
            file = new FileNode(false, fileName, content);
            dir.getChildren().put(fileName, file);
        } else {
            if (file.isDir()) {
                throw new RuntimeException("'" + fileName + "'是目录，无法作为文件写入");
            }
            // 追加内容
            file.setContent(file.getContent() + content);
        }
    }

    /**
     * 读取文件内容
     */
    public String readContentFromFile(String filePath) {
        FileNode file = resolvePath(filePath);
        if (file == null) {
            throw new RuntimeException("文件不存在：" + filePath);
        }
        if (file.isDir()) {
            throw new RuntimeException("'" + filePath + "'是目录，无法读取内容");
        }
        return file.getContent();
    }

    /**
     * 辅助方法：解析路径，返回目标节点（若不存在返回null）
     */
    private FileNode resolvePath(String path) {

        List<String> partList = parsePath(path);
        if (partList.isEmpty()) {
            return root;
        }

        FileNode current = root;

        for (String part : partList) {
            FileNode child = current.getChildren().get(part);
            if (child == null) {
                return null; // 路径不存在
            }

            current = child;
        }

        return current;
    }

    private List<String> parsePath(String path) {

        String[] split = path.split("/");

        List<String> result = new ArrayList<>();

        for (String item : split) {
            if (item.isEmpty()) {
                continue;
            }
            result.add(item);
        }

        return result;
    }


    public static void main(String[] args) {

        FileSystem fileSystem = new FileSystem();

        fileSystem.mkdir("a/b/c");

        List<String> ls = fileSystem.ls("a/b");

        fileSystem.addContentToFile("a/b/c/doc", "hello");

        String s = fileSystem.readContentFromFile("a/b/c/doc");

        System.out.println(s);


    }

}