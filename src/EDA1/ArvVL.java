package EDA1;

import java.util.Iterator;

public class ArvVL<E extends Comparable<? super E>> implements AVL<E>, Iterable<E> {

    private AVLNode<E> root;
    private int count;

    public ArvVL(AVLNode<E> r){
        root = r;
    }

    public ArvVL(){
        root = null;
    }

    public ArvVL(E x){
        this(x, null, null);
    }

    public ArvVL (E x, AVLNode<E> left, AVLNode<E> right){
        root = new AVLNode<E>(x, left, right, 0);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E x) {
        return contains(x, this.root);
    }

    public E findMin() {
        return findMin(root);
    }

    public E findMax() {
        return findMax(root);
    }

    private boolean contains(E x, AVLNode<E> node) {
        if (node == null) {
            return false;
        }
        if (x.compareTo(node.element) == 0) {
            return true;
        } else if (x.compareTo(node.element) > 0) {
            return contains(x, node.right);
        }
        return contains(x, node.left);
    }

    private E findMin(AVLNode<E> node) {
        if (node.left != null){
            return findMin(node.left);
        }
        return node.element;
    }

    private E findMax(AVLNode<E> node) {
        if (node.right != null){
            return findMin(node.left);
        }
        return node.element;
    }

    public void insere(E x) {
        count++;
        this.root = insere(x, this.root, 0);
    }

    //ch -> current height
    private AVLNode<E> insere(E x, AVLNode<E> node, int ch){
        if(node == null) {
            node = new AVLNode<E>(x, ch);
        }
        else if (x.compareTo(node.element) > 0){
            node.right = insere(x, node.right, ++ch);
        } else if(x.compareTo(node.element) < 0){
            node.left = insere(x, node.left, ++ch);
        } else{
            node.valid = true;
        }
        int l = (node.left == null)? 0 : node.left.getMaxHeight();
        int r = (node.right == null)? 0 : node.right.getMaxHeight();

        if(Math.abs(l - r) > 1){
            //UNBALANCED
            node = balanceFromHere(x, node);
        }
        return node;
    }

    private AVLNode<E> balanceFromHere(E x, AVLNode<E> node){
        //right
        AVLNode<E> temp;
        if (x.compareTo(node.element) > 0){
            temp = node.right;
            if (x.compareTo(temp.element) > 0){
                // R, R
                node = leftRot(node);
            } else if(x.compareTo(temp.element) < 0){
                // R, L
                node = rightLeftRot(node);
            }
        }//left
        else if(x.compareTo(node.element) < 0){
            temp = node.left;
            if (x.compareTo(temp.element) > 0){
                // L, R
                node = leftRightRot(node);
            } else if(x.compareTo(temp.element) < 0){
                // L, L
                node = rightRot(node);
            }
        }
        return node;
    }

    private AVLNode<E> rightRot(AVLNode<E> n){
        AVLNode<E> n1 = n.left;
        n.left = n1.right;
        n1.right = n;
        n.h = n.getMaxHeight();
        n1.h = n1.getMaxHeight();
        return n1;
    }

    private AVLNode<E> leftRot(AVLNode<E> n){
        AVLNode<E> n1 = n.right;
        n.right = n1.left;
        n1.left = n;
        n.h = n.getMaxHeight();
        n1.h = n1.getMaxHeight();
        return n1;
    }

    private AVLNode<E> leftRightRot(AVLNode<E> n){
        AVLNode<E> n1 = n.left;
        n.left = leftRot(n1);
        return rightRot(n);
    }

    private AVLNode<E> rightLeftRot(AVLNode<E> n){
        AVLNode<E> n1 = n.right;
        n.right = rightRot(n1);
        return leftRot(n);
    }

    public void remove(E x) {
        count--;
        this.root = remove(x, this.root);
    }

    private AVLNode<E> remove(E x, AVLNode<E> node) {
        if (node == null) {
            //DOES NOT EXIST
            count++;
            return null;
        }
        if (x.compareTo(node.element) > 0) {
            node.right = remove(x, node.right);
        } else if (x.compareTo(node.element) < 0) {
            node.left = remove(x, node.left);
        }
        else {
            node.valid = false;
        }
        return node;
    }

    public void printEmOrdem() {
        if(!this.isEmpty()) printEmOrdem(root);
    }

    private void printEmOrdem(AVLNode<E> node) {
        if (node.left != null) {
            printEmOrdem(node.left);
        }
        if (node.valid) {
            System.out.println(node.element);
        }
        if (node.right != null) {
            printEmOrdem(node.right);
        }
    }

    public void printPosOrdem() {
        if(!this.isEmpty()) printPosOrdem(root);
    }

    private void printPosOrdem(AVLNode<E> node) {
        if (node.left != null) {
            printPosOrdem(node.left);
        }
        if (node.right != null) {
            printPosOrdem(node.right);
        }
        if (node.valid) {
            System.out.println(node.element);
        }
    }

    public void printPreOrdem() {
        if(!this.isEmpty()) printPreOrdem(root);
    }

    private void printPreOrdem(AVLNode<E> node) {
        if(node.valid) {
            System.out.println(node.element);
        }
        if(node.left != null) {
            printPreOrdem(node.left);
        }
        if(node.right != null) {
            printPreOrdem(node.right);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorEmOrdemAVL<E>(root, count);
    }
}
