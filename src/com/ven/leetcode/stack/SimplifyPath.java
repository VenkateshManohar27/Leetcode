package com.ven.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level. For more
 * information, see: Absolute path vs relative path in Linux/Unix
 * 
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "/home/" Output: "/home" Explanation: Note that there is no trailing
 * slash after the last directory name.
 * 
 * Example 2:
 * 
 * Input: "/../" Output: "/" Explanation: Going one level up from the root
 * directory is a no-op, as the root level is the highest level you can go.
 * 
 * Example 3:
 * 
 * Input: "/home//foo/" Output: "/home/foo" Explanation: In the canonical path,
 * multiple consecutive slashes are replaced by a single one.
 * 
 * Example 4:
 * 
 * Input: "/a/./b/../../c/" Output: "/c"
 * 
 * Example 5:
 * 
 * Input: "/a/../../b/../c//.//" Output: "/c"
 * 
 * Example 6:
 * 
 * Input: "/a//b////c/d//././/.." Output: "/a/b/c"
 * 
 * @author Venkatesh Manohar
 *
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		Stack<String> st = new Stack<String>();
		String[] strs = path.split("/");

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(".") || strs[i].isEmpty()) {
				continue;
			} else if (strs[i].equals("..")) {
				if (!st.isEmpty())
					st.pop();
			} else {
				st.push(strs[i]);
			}
		}
		
		Iterator<String> itr = st.iterator();
		StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            sb.append("/").append(itr.next());
        }
        return sb.length() == 0 ? "/" : sb.toString();
	}

	// public String simplifyPath(String path) {
	// if (path == null || path.length() == 0) {
	// return path;
	// }
	// Stack<String> st = new Stack<String>();
	// StringBuilder temp = new StringBuilder();
	// for (int i = 0; i < path.length(); i++) {
	// char c = path.charAt(i);
	// if (c == '/') {
	// if (temp.length() > 0) {
	// st.push(temp.toString());
	// temp = new StringBuilder();
	// }
	// continue;
	// } else if (c == '.') {
	// if (i < path.length() - 1 && path.charAt(i + 1) == '.') {
	// i++;
	// if (!st.isEmpty()) {
	// st.pop();
	// }
	// }
	//
	// } else {
	// temp.append(c);
	// }
	//
	// }
	// StringBuilder sb = new StringBuilder();
	// if (st.isEmpty()) {
	// sb.append("/");
	// } else {
	// while (!st.isEmpty()) {
	// sb.insert(0, st.pop());
	// sb.insert(0, "/");
	//
	// }
	// }
	// return sb.toString();
	// }
}
