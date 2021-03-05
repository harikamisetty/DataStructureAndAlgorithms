package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class ListOperations {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 2, 9, 7, 6, 8, 22, 45);
		// Sort  a List
		Collections.sort(intList);

		for (int val : intList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		
		// Reverse Sort List
		Collections.sort(intList, Comparator.reverseOrder());

		for (int val : intList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		// Read First 3 element from a lost
		List<Integer> list = intList.parallelStream().limit(3).collect(Collectors.toList());

		for (int res : list) {
			System.out.print(res + ",");
		}
		System.out.println("\n");
		
		// Sort with ignore case
		List<String> strList = Arrays.asList("hari", "Koman", "Nilu", "apple", "zoo");
		Collections.sort(strList, new SortIgnoreCase());

		for (String val : strList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");

		// 3 ways to sort Strings in a ReverseOrder in case insensitive
		Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(strList, Comparator.reverseOrder());
		Collections.sort(strList, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

		for (String val : strList) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		List<String> listStr = strList.parallelStream().limit(3).collect(Collectors.toList());

		for (String res : listStr) {
			System.out.print(res + ",");
		}
		System.out.println("\n");
		
		// Position insert
		List<Integer> res = new ArrayList<>();
		res.add(0,3);
		res.add(0,5);
		for(int val : res) {
			System.out.println(val);
		}
		
		// Convert LIST to ARRAY
		int[] array = res.stream().mapToInt(Integer::intValue).toArray();
		int[] arrat2 = res.parallelStream().mapToInt(Integer::intValue).toArray();
		
		Map<String, List<String>> map = new HashMap<>();
		// Convert Map values to List
		List<List<String>> templ= new ArrayList<List<String>>(map.values()); 
		
		// MIN and MAX in a list
		int min = Collections.min(intList);
		int max = Collections.max(intList);	
		
		List[] arrlist = new List[3];
		
		for(int i=0;i<3;i++) {
			arrlist[i] = Arrays.asList(i+1,i+2);
		}
		
		for(List lists : arrlist) {
			System.out.println(lists);
		}	
		Queue<Long> small = new PriorityQueue<>();
		small.add((long)20);
		small.add((long)10);
		small.add((long)5);
		small.add((long)30);
		System.out.println(small.peek());
		
		  // create some user objects 
        User u1 = new User("Aaman", 25); 
        User u2 = new User("Joyita", 22); 
        User u3 = new User("Suvam", 28); 
        User u4 = new User("mahafuj", 2); 
  
        // before sort 
		List<User> listuser = Arrays.asList(u2, u1, u4, u3);
		System.out.println("Before Sort:");
		listuser.forEach(User -> System.out.println("User age " + User.getAge()));

		Collections.sort(listuser, Comparator.comparingInt(User::getAge));
		System.out.println("\nAfterSort:");
		listuser.forEach(User -> System.out.println("User age " + User.getAge()));
		
		int[] nums1 = {2,4,6,1};
		//Array to List
		List<Integer> myList = Arrays.stream(nums1).boxed().collect(Collectors.toList());
	}
}

class SortIgnoreCase implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		return s1.toLowerCase().compareTo(s2.toLowerCase());
	}
}

class User implements Comparable<User> { 
    public String name; 
    public int age; 
  
    public User(String name, int age) 
    { 
        this.name = name; 
        this.age = age; 
    } 
  
    public int compareTo(User u1) 
    { 
        return name.compareTo(u1.name); 
    } 
  
    public String getName() 
    { 
        return name; 
    } 
  
    public void setName(String name) 
    { 
        this.name = name; 
    } 
  
    public int getAge() 
    { 
        return age; 
    } 
  
    public void setAge(int age) 
    { 
        this.age = age; 
    } 
  
    @Override
    public String toString() 
    { 
        return "User [name=" + name 
            + ", age=" + age + "]"; 
    } 
} 
