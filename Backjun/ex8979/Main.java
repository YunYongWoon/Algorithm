package ex8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Team implements Comparable<Team> {

	private int teamId, gold, silver, bronze;

	public Team(int teamId, int gold, int silver, int bronze) {
		this.teamId = teamId;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	public int getTeamId() {
		return this.teamId;
	}

	public boolean checkTeamRank(Team team) {
		if (team.gold == this.gold && team.silver == this.silver && team.bronze == this.bronze) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Team o) {
		if (this.gold > o.gold) {
			return -1;
		} else if (this.gold < o.gold) {
			return 1;
		} else {
			if (this.silver > o.silver) {
				return -1;
			} else if (this.silver < o.silver) {
				return 1;
			} else {
				if (this.bronze > o.bronze) {
					return -1;
				} else if (this.bronze < o.bronze) {
					return 1;
				}
			}
		}
		return 0;
	}

}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N, K;
		int answer = 0;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Team[] arr = new Team[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = new Team(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			);
		}
		Arrays.sort(arr);
		Team temp = new Team(-1, -1, -1, -1);
		for (int i = 0; i < N; i++) {
			if (!arr[i].checkTeamRank(temp)) {
				answer = i + 1;
				temp = arr[i];
			}
			if (arr[i].getTeamId() == K) {
				break;
			}
		}
		System.out.println(answer);
	}
}
