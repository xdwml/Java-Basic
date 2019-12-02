import java.util.Stack;

/**
 * 实现二叉树的先序、 中序、 后序遍历， 包括递归方式和非递归方式
 */
public class Code_01_PreInPosTraversal {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	/************递归遍历***********************/
	//先序遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");//先打印头
		preOrderRecur(head.left);//再打印左孩子
		preOrderRecur(head.right);//最后打印右孩子
	}
	//中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);//先打印左孩子
		System.out.print(head.value + " ");//再打印头
		inOrderRecur(head.right);//最后打印右孩子
	}
	//后序遍历
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);//先打印左孩子
		posOrderRecur(head.right);//再打印右孩子
		System.out.print(head.value + " ");//最后打印头
	}

	/************非递归遍历***********************/
	//先序遍历
	public static void preOrderUnRecur(Node head) {
		System.out.print("先序: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();//栈中弹出一个节点作为头
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	//中序遍历
	public static void inOrderUnRecur(Node head) {
		System.out.print("中序: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " "); 
					head = head.right;
				}
			}
		}
		System.out.println();
	}
	//后序遍历1
	public static void posOrderUnRecur1(Node head) {
		System.out.print("后序1: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);  
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	//后序遍历2
	public static void posOrderUnRecur2(Node h) {
		System.out.print("后序2: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============递归版==============");
		System.out.print("先序: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("中序: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("后序: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============非递归=============");
		preOrderUnRecur(head);
		inOrderUnRecur(head);
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);

	}

}
