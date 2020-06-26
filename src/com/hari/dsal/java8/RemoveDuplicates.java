package com.hari.dsal.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List deptList = new ArrayList();
        deptList.add(new Department(1, "IT"));
        deptList.add(new Department(2, "HR"));
        deptList.add(new Department(1, "IT"));
        deptList.add(new Department(4, "Development"));
        deptList.add(new Department(2, "HR"));

        Set deptSet = new HashSet<>();

        // directly removing the elements from list if already existed in set
        deptList.removeIf(p -> !deptSet.add(((Department) p).getDeptName()));

        deptList.forEach(dept->System.out.println(((Department) dept).getDeptId() +" : "+((Department) dept).getDeptName()));

    }
}
