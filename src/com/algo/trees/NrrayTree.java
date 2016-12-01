package com.algo.trees;

import com.algo.LinkedList;

/**
 * Created by Subramanyam on 01-Dec-2016.
 */
public class NrrayTree<E> {

    TreeNode<E> root;

    public static class TreeNode<E> {

        E data;
        LinkedList<TreeNode<E>> children = new LinkedList<TreeNode<E>>();

        public TreeNode(E data) {
            this.data = data;
        }
    }

    public void init() {

    }
}
