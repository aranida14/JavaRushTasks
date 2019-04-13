package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("0");
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String))
            throw new UnsupportedOperationException(o + " is not a String");
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (current.getElementName().equals(o)) {
                Entry<String> parent = current.getParent();
                if (parent != null) {
                    if (parent.getLeftChild() == current) {
                        parent.setLeftChild(null);
                        parent.setAvailableToAddLeftChildren(true);
                    } else {
                        parent.setRightChild(null);
                        parent.setAvailableToAddRightChildren(true);
                    }
                    return true;
                }
            } else {
                Entry<String> left = current.getLeftChild();
                if(left != null)
                    queue.offer(left);
                Entry<String> right = current.getRightChild();
                if (right != null)
                    queue.offer(right);
            }
        }
        return false;
    }

    @Override
    public boolean add(String s) {
        Entry<String> newItem = new Entry<>(s);
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (current.isAvailableToAddChildren()) {
                if (current.isAvailableToAddLeftChildren()) {
                    current.setLeftChild(newItem);
                    current.setAvailableToAddLeftChildren(false);
                } else if (current.isAvailableToAddRightChildren()) {
                    current.setRightChild(newItem);
                    current.setAvailableToAddRightChildren(false);
                }
                newItem.setParent(current);
                return true;
            } else {
                Entry<String> left = current.getLeftChild();
                if(left != null)
                    queue.offer(left);
                Entry<String> right = current.getRightChild();
                if (right != null)
                    queue.offer(right);
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0; //includes root
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            size++;
            Entry<String> left = current.getLeftChild();
            if(left != null)
                queue.offer(left);
            Entry<String> right = current.getRightChild();
            if (right != null)
                queue.offer(right);
        }
        return --size;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (current.getElementName().equals(s)) {
                if (current.getParent() != null) {
                    return current.getParent().getElementName();
                } else {
                    return null;
                }
            } else {
                Entry<String> left = current.getLeftChild();
                if(left != null)
                    queue.offer(left);
                Entry<String> right = current.getRightChild();
                if (right != null)
                    queue.offer(right);
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public String getElementName() {
            return elementName;
        }

        public boolean isAvailableToAddLeftChildren() {
            return availableToAddLeftChildren;
        }

        public void setAvailableToAddLeftChildren(boolean availableToAddLeftChildren) {
            this.availableToAddLeftChildren = availableToAddLeftChildren;
        }

        public boolean isAvailableToAddRightChildren() {
            return availableToAddRightChildren;
        }

        public void setAvailableToAddRightChildren(boolean availableToAddRightChildren) {
            this.availableToAddRightChildren = availableToAddRightChildren;
        }

        public Entry<T> getParent() {
            return parent;
        }

        public void setParent(Entry<T> parent) {
            this.parent = parent;
        }

        public Entry<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Entry<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Entry<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Entry<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

}
