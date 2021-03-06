package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;



public class Utils {
	
	public static TreeNode cloneNode(TreeNode node) {
		if (node == null) {
			return null;
		} else {
			TreeNode clone = new TreeNode(node.val);
			clone.left = node.left;
			clone.right = node.right;
			return clone;
		}	
	}
	
	public static  TreeNode NewTree(List list){
		TreeNode root = null;
		if (list == null || list.size() == 0) {
			return root;
		}
		
		int val = (int)list.get(0);
		root = new TreeNode(val);
		list.remove(0);
		
		Queue queue = new LinkedList<>();
		queue.offer(root);
		
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			TreeNode node = (TreeNode) queue.poll();
			int leftVal = (int)iter.next();
			int rightVal = 0;
			if (iter.hasNext()) {
				rightVal = (int) iter.next();
			}
			
			TreeNode left = new TreeNode(leftVal);
			node.left = left;
			queue.offer(left);
			TreeNode right = null;
			right = new TreeNode(rightVal); 
			node.right = right;
			queue.offer(right);
		}
		return root;
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue =  new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				System.out.print(node.val +",");
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
				
			}
			System.out.println();
		}
	}


    public static  void printTreePretty(TreeNode root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static  void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode TreeNode : nodes) {
            if (TreeNode != null) {
                System.out.print(TreeNode.val);
                newNodes.add(TreeNode.left);
                newNodes.add(TreeNode.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;

        return Math.max(maxLevel(TreeNode.left), maxLevel(TreeNode.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    public static TreeNode newTreeFromArray(String[] data){
    	TreeNode root = new TreeNode(0);
    	if (data == null || data.length == 0) {
    		return null;
    	}
    	root.val = Integer.valueOf(data[0]);
    	Queue queue = new LinkedList<>();
    	int currentLevel = 1;
    	int i = 1;
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		TreeNode node = (TreeNode)queue.poll();
    		if (i < data.length) {
    			String current = data[i];
    			if (current.equals("#")) {
    				node.left = null;
    			} else {
    				node.left = new TreeNode(Integer.valueOf(current));
    				queue.offer(node.left);
    			}
    			i++;
    		} else {
    			return root;
    		}
    		if (i < data.length) {
    			String current = data[i];
    			if (current.equals("#")) {
    				node.right = null;
    			} else {
    				node.right = new TreeNode(Integer.valueOf(current));
    				queue.offer(node.right);
    			}
    			i++;
    		} else {
    			return root;
    		}
    	}
    	return root;
    }

    public static TreeNode newTreeFromArray(int[] data){
    	if (data == null || data.length == 0) {
    		return null;
    	}
    	int len = data.length;
    	String[] values = new String[len];
    	for (int i = 0; i < len; i++) {
    		values[i] = String.valueOf(data[i]);
    	}
    	return newTreeFromArray(values);
    }
    
    public static void echo(String s){
    	System.out.println(s);
    }
    
}
