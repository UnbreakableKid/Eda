package EDA1;

import java.util.Iterator;

public class ArvBP <E extends Comparable<? super E>> implements ABP<E>, Iterable<E>{

    private ABNode<E> root;
    private int count = 0;

    public ArvBP(){
        this.root = null;
    }

    public ArvBP(E x){
        this.root = new ABNode<E>(x);
    }

    public ArvBP(ABNode<E> r){
        this.root = r;
    }

    public ArvBP (E r, ABNode<E> left, ABNode<E> right){
        this.root = new ABNode<E>(r, left, right);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(E x) {
        return contains(x, this.root);
    }

    @Override
    public E findMin() {
        return findMin(root);
    }

    @Override
    public E findMax() {
        return findMax(root);
    }

    private boolean contains(E x, ABNode<E> node){
        if(node == null){
            return false;
        }
        if(x.compareTo(node.element) == 0){
            return true;
        } else if(x.compareTo(node.element) > 0){
            return contains(x, node.right);
        } else {
            return contains(x, node.left);
        }
    }

    private E findMin(ABNode<E> node) {
        if (node.left != null){
            return findMin(node.left);
        }
        return node.element;
    }

    private E findMax(ABNode<E> node) {
        if (node.right != null){
            return findMin(node.left);
        }
        return node.element;
    }


    public void insere(E x) {
        count++;
        this.root = insere(x, this.root);
    }

    private ABNode<E> insere(E x, ABNode<E> node){

        if(node == null){
            node = new ABNode<E>(x);
            return node;
        }

        if(x.compareTo(node.element) > 0){
            node.right = insere(x, node.right);
        } else if(x.compareTo(node.element) < 0){
            node.left = insere(x, node.left);
        } else {
            count--;
        }
        return node;

    }

    public void remove(E x) {
        count--;
        this.root = remove(x, this.root);
    }


    private ABNode<E> remove(E x, ABNode<E> node) {

        if (node == null) {
            count++;
            return node;
        }

        if (x.compareTo(node.element) > 0) {
            node.right = remove(x, node.right);
        } else if (x.compareTo(node.element) < 0) {
            node.left = remove(x, node.left);
        }
        else if(node.right == null && node.left == null) {
            node = null;
        }
        else if (node.right == null && node.left != null){
            node = node.left;
        }
        else if (node.left == null  && node.right != null){
            node = node.right;
        }

        else if (node.left != null && node.right != null){
            E min = findMin(node.right);
            node.element = min;
            node.right = remove(min, node.right);
        }
        return node;

    }

    public void printEmOrdem() {
        if(!this.isEmpty()) {
            helperEmOrdem(this.root);
            System.out.println();
        }
    }

    private void helperEmOrdem(ABNode<E> node) {

        if(node.left != null) {
            helperEmOrdem(node.left);
        }

        System.out.println(node.element);

        if(node.right != null) {
            helperEmOrdem(node.right);
        }

    }

    public void printPosOrdem() {
        if(!this.isEmpty()) {
            helperPosOrdem(this.root);
            System.out.println();
        }
    }

    private void helperPosOrdem(ABNode<E> node) {

        if(node.left != null) {
            helperEmOrdem(node.left);
        }

        if(node.right != null) {
            helperEmOrdem(node.right);
        }
        System.out.println(node.element);

    }

    public void printPreOrdem() {
        if(!this.isEmpty()) {
            helperPreOrdem(this.root);
            System.out.println();
        }
    }

    private void helperPreOrdem(ABNode<E> node) {

        System.out.println(node.element);

        if(node.left != null) {
            helperEmOrdem(node.left);
        }

        if(node.right != null) {
            helperEmOrdem(node.right);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorEmOrdemABP<>(root, count);
    }
}
