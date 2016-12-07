package com.algo.Applications;

import java.io.File;

import static com.algo.ADT.*;

/**
 * Created by Subramanyam on 07-Dec-2016.
 */
public class FileSystemTraversal {

    class FileData {
        int depth;
        File file;

        public FileData(int depth, File file) {
            this.depth = depth;
            this.file = file;
        }

        public int getDepth() {
            return depth;
        }

        public File getFile() {
            return file;
        }
    }

    /**
     * Print file system tree
     * Solution: Use stack
     * @param root
     */
    public void printFileSystemTree(File root) {

        Stack<FileData> stack = new Stack<FileData>();
        stack.push(new FileData(0, root));

        while (!stack.isEmpty()) {

            FileData temp = stack.pop();

            for (int i = 0 ; i < temp.getDepth() ; i++) {
                System.out.print("-");
            }

            System.out.println(temp.getFile().getName());

            if (temp.getFile().isDirectory()) {

                File [] files = temp.getFile().listFiles();

                for (int i = files.length - 1 ; i >=0 ; i--) {
                    stack.push(new FileData(temp.getDepth() + 1, files[i]));
                }
            }
        }
    }

    public void printFileSystemTreeRecursive(File root, int depth) {

        for (int i = 0 ; i < depth ; i++)
            System.out.print("-");

        System.out.println(root.getName());

        if (root.isDirectory()) {
            for (File file : root.listFiles()) {
                printFileSystemTreeRecursive(file, depth + 1);
            }
        }

    }


}
