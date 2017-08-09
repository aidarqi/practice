package com.aidar.collection_test;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @desc
 * @date 17-7-7
 */
public class CollectionTest0 {
    public static void main(String[] args) {
        Collection collection = new Collection() {
            @Override public int size() {
                return 0;
            }

            @Override public boolean isEmpty() {
                return false;
            }

            @Override public boolean contains(Object o) {
                return false;
            }

            @NotNull @Override public Iterator iterator() {
                return null;
            }

            @NotNull @Override public Object[] toArray() {
                return new Object[0];
            }

            @NotNull @Override public Object[] toArray(@NotNull Object[] a) {
                return new Object[0];
            }

            @Override public boolean add(Object o) {
                return false;
            }

            @Override public boolean remove(Object o) {
                return false;
            }

            @Override public boolean containsAll(@NotNull Collection c) {
                return false;
            }

            @Override public boolean addAll(@NotNull Collection c) {
                return false;
            }

            @Override public boolean removeAll(@NotNull Collection c) {
                return false;
            }

            @Override public boolean retainAll(@NotNull Collection c) {
                return false;
            }

            @Override public void clear() {

            }
        };
        Map map = new Map() {
            @Override public int size() {
                return 0;
            }

            @Override public boolean isEmpty() {
                return false;
            }

            @Override public boolean containsKey(Object key) {
                return false;
            }

            @Override public boolean containsValue(Object value) {
                return false;
            }

            @Override public Object get(Object key) {
                return null;
            }

            @Override public Object put(Object key, Object value) {
                return null;
            }

            @Override public Object remove(Object key) {
                return null;
            }

            @Override public void putAll(@NotNull Map m) {

            }

            @Override public void clear() {

            }

            @NotNull @Override public Set keySet() {
                return null;
            }

            @NotNull @Override public Collection values() {
                return null;
            }

            @NotNull @Override public Set<Entry> entrySet() {
                return null;
            }
        };
        Map map1 = new HashMap();
        List list = new List() {
            @Override public int size() {
                return 0;
            }

            @Override public boolean isEmpty() {
                return false;
            }

            @Override public boolean contains(Object o) {
                return false;
            }

            @NotNull @Override public Iterator iterator() {
                return null;
            }

            @NotNull @Override public Object[] toArray() {
                return new Object[0];
            }

            @NotNull @Override public Object[] toArray(@NotNull Object[] a) {
                return new Object[0];
            }

            @Override public boolean add(Object o) {
                return false;
            }

            @Override public boolean remove(Object o) {
                return false;
            }

            @Override public boolean containsAll(@NotNull Collection c) {
                return false;
            }

            @Override public boolean addAll(@NotNull Collection c) {
                return false;
            }

            @Override public boolean addAll(int index, @NotNull Collection c) {
                return false;
            }

            @Override public boolean removeAll(@NotNull Collection c) {
                return false;
            }

            @Override public boolean retainAll(@NotNull Collection c) {
                return false;
            }

            @Override public void clear() {

            }

            @Override public Object get(int index) {
                return null;
            }

            @Override public Object set(int index, Object element) {
                return null;
            }

            @Override public void add(int index, Object element) {

            }

            @Override public Object remove(int index) {
                return null;
            }

            @Override public int indexOf(Object o) {
                return 0;
            }

            @Override public int lastIndexOf(Object o) {
                return 0;
            }

            @NotNull @Override public ListIterator listIterator() {
                return null;
            }

            @NotNull @Override public ListIterator listIterator(int index) {
                return null;
            }

            @NotNull @Override public List subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        System.out.println("************************");
        List list1 = new ArrayList();
        System.out.println(list1.contains(null));
        Iterator it = list1.iterator();
        System.out.println(it.hasNext());
        System.out.println("************************");
        ArrayList list2 = new ArrayList();
        list2.add("1");
        list2.add(null);
        System.out.println(list2.contains(null));
        Iterator it2 = list2.iterator();
//        System.out.println(it2.hasNext());
        while (it2.hasNext()){
            System.out.println(it2.next());
            it2.remove();
        }
        System.out.println(it2.hasNext());
        System.out.println("************************");
        List list3 = new ArrayList();
        list3.add("1");
        System.out.println(list3.contains(null));
        Iterator it3 = list3.iterator();
        //        System.out.println(it2.hasNext());
        while (it3.hasNext()){
            System.out.println(it3.next());
        }
        System.out.println("************************");
        List list4 = new ArrayList();
        list4.add("1");
        list4.add(null);
        list4.add("2");
        list4.add("3");
        list4.add("4");
        //        System.out.println(it2.hasNext());
        for(Object s:list4) {
            System.out.println(s);
//            list4.remove(s);
        }
        for(Object s:list4) {
            System.out.println("xx : " + s);
        }
        System.out.println("************************");
        Set set = new HashSet();
        System.out.println(set.getClass().getName());
        System.out.println(list4.getClass().getClassLoader());

        Hashtable hashtable = new Hashtable();
        hashtable.put(1,1);

        HashMap<String, Integer> map2 = new HashMap();
        map2.put("1", 1);
        for (Map.Entry entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        int oldCap = 14;
        System.out.println(oldCap>>1);
        System.out.println(oldCap);

    }
}
