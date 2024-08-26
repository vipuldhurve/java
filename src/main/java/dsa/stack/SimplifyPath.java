package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {

//    Given an absolute path for a Unix-style file system,
//    which begins with a slash '/',
//    transform this path into its simplified canonical path.

//    In Unix-style file system context,
//    a single period '.' signifies the current directory,
//    a double period ".." denotes moving up one directory level,
//    and multiple slashes such as "//" are interpreted as a single slash.

//    In this problem,
//    treat sequences of periods not covered by the previous rules (like "...")
//    as valid names for files or directories.

//    The simplified canonical path should adhere to the following rules:

//    - It must start with a single slash '/'.
//    - Directories within the path should be separated by only one slash '/'.
//    - It should not end with a slash '/', unless it's the root directory.
//    - It should exclude any single or double periods used to denote current or parent directories.
//    -

    private static String simplifyPath(String path) {
//        We will use a stack because when we encounter a ".." we need to remove recent dir it from path
//        Stack to store only directories
        Stack<String> stack = new Stack<>();
        StringBuilder dir = new StringBuilder("");

        for (char c : path.toCharArray()) {
            String dirStr = dir.toString();
            if (c == '/') {
//                Check value in dir,
//                process it,
//                and initialize dir for further processing
                if (dirStr.equals("") || dirStr.equals(".")) {
//                    Nothing is added to stack
                } else if (dirStr.equals("..")) {
//                    remove recent added dir if stack is not empty,
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(dirStr);
                }
                dir.setLength(0);
            } else {
                dir.append(c);
            }
        }

        String dirStr = dir.toString();
//        Check if dir holds a value in case "/abc/def/ghi" to process "ghi" part if slash("/") not encountered at end
        if (dirStr.equals("") || dirStr.equals(".")) {
//                    Nothing is added to stack
        } else if (dirStr.equals("..")) {
//                    remove recent added dir if stack is not empty,
            if (!stack.isEmpty()) stack.pop();
        } else {
            stack.push(dirStr);
        }

//        Initialize dir to create path
        dir.setLength(0);

        while (!stack.isEmpty()) {
            dir.insert(0, stack.pop());
            dir.insert(0, "/");
        }

        return dir.length() == 0 ? "/" : dir.toString();
    }


    public static void main(String[] args) {
        String[] inputArray = new String[]{
                "/home/",
                "/home//foo/",
                "/home/user/Documents/../Pictures",
                "/../",
                "/.../a/../b/c/../d/."
        };
        Arrays.stream(inputArray)
                .peek(s -> System.out.println("Input: " + s))
                .map(SimplifyPath::simplifyPath)
                .forEach(s -> System.out.println("Path: " + s + "\n"));
    }
}
