package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 比较字符串最小字母出现频次1170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] queries = {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
		String[] words={"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
		numSmallerByFrequency(queries, words);
	}
	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		ArrayList<Integer> w =new ArrayList<Integer> ();
		ArrayList<Integer> q =new ArrayList<Integer> ();


		for(String i: words) {
			int num = 0;
			char t;
			char[] arr = i.toCharArray();
			t = arr[0];
			for(char c:arr) {
				if(c < t) {
					t = c;
					num = 0;
				}
				if(t == c) {
					num++;
				}
			}
			w.add(num);
		}
		for(String i: queries) {
			int num = 0;
			char t;
			char[] arr = i.toCharArray();
			t = arr[0];
			for(char c:arr) {
				if(c < t) {
					t = c;
					num = 0;
				}
				if(t == c) {
					num++;
				}
			}
			q.add(num);
		}
		int[] res =new int[queries.length];
		for(int i = 0;i < q.size();i++) {
			for(int j = 0;j < w.size();j++) {
				if(q.get(i) < w.get(j)) {
					res[i]++;
				}
			}
		}
		return res;
	
	}
}
