package com.hari.dsal.implementations;

public class DesignHashSet_705 {

    /** Initialize your data structure here. */
   public DesignHashSet_705() {
    set = new boolean[1000001];
  }

  public void add(int key) {
    set[key] = true;
  }

  public void remove(int key) {
    set[key] = false;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    return set[key];
  }

  private boolean[] set = new boolean[1000001];
}
