package com.wxw.tanxin;

import java.util.Scanner;

public class Main {

	private int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int m = sc.nextInt();
		int col = sc.nextInt();
		int[] visited = new int[node];
		int[][] edge = new int[node][node];
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			edge[x][y] = 1;
		}
		Main dfs = new Main();
		dfs.count = 0;
		System.out.println(dfs.DFS(edge, 0, visited));
	}
	
	private int DFS(int[][] edge, int k, int[] visited){
		int u;//k���ڽӶ���	
		visited[k] = 1;
		u = getFirst(edge, k);
		while(u != -1){
			count++;
			if(visited[u] == 0){
				DFS(edge, u, visited);
			}
			u = getNext(edge, k, u);
		}
		return count;
	}
	
	/**
	 * ��ȡk�ĵ�һ���ڽӽڵ�
	 * @param edge
	 * @param k
	 * @return
	 */
	private int getFirst(int[][] edge, int k){

		if(k < 0 || k > edge.length - 1){
			return -1;
		}
		
		for (int i = 0; i < edge.length; i++) {
			if(edge[k][i] == 1){
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * ��ȡ��ǰ����k�ĵ�t���ڽӶ����λ��
	 * @param k ��ǰ�ڵ�
	 * @param t ��ǰ����k�ĵ�t���ڽӶ���
	 * @return ��t���ڽӶ����λ��
	 */
	private int getNext(int[][] edge, int k, int t){

		int node = edge.length;
		if(k < 0 || k > node - 1 || t < 0 || t > node - 1){
			return -1;
		}
		
		for(int i = t + 1; i < node; i++){
			if(edge[k][i] == 1){
				return i;
			}
		}
		return -1;
	}
}
