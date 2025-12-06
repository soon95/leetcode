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
        if (path.equals("/")) {
            return; // 根目录已存在，无需创建
        }

        String[] parts = path.split("/");
        FileNode current = root;

        for (String part : parts) {
            if (part.isEmpty()) {
                continue; // 跳过空字符串（如"/a/b"分割后开头的""）
            }

            // 若子节点不存在，创建目录
            current.getChildren().computeIfAbsent(part, name -> new FileNode(true, name, null));

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
        int lastSlashIndex = filePath.lastIndexOf("/");
        String dirPath = filePath.substring(0, lastSlashIndex);
        String fileName = filePath.substring(lastSlashIndex + 1);

        // 解析目录路径（若不存在则创建）
        FileNode dir = resolvePath(dirPath);
        if (dir == null) {
            mkdir(dirPath); // 递归创建目录
            dir = resolvePath(dirPath);
        }

        if (!dir.isDir()) {
            throw new RuntimeException("'" + dirPath + "'不是目录，无法创建文件");
        }

        // 获取或创建文件
        FileNode file = dir.getChildren().computeIfAbsent(fileName, name -> new FileNode(false, name, ""));
        if (file.isDir()) {
            throw new RuntimeException("'" + fileName + "'是目录，无法作为文件写入");
        }

        // 追加内容
        file.setContent(file.getContent() + content);
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
        if (path.equals("/")) {
            return root; // 根路径特殊处理
        }

        String[] parts = path.split("/");
        FileNode current = root;

        for (String part : parts) {
            if (part.isEmpty()) {
                continue; // 跳过空字符串
            }

            FileNode child = current.getChildren().get(part);
            if (child == null) {
                return null; // 路径不存在
            }

            current = child;
        }

        return current;
    }
}