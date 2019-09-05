package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
	public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<Node> st = new Stack<Node>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            res.add(curr.val);
            Collections.reverse(curr.children);
            for(Node node: curr.children){
                st.push(node);
            }
            
        }
        
        return res;
    }
}
