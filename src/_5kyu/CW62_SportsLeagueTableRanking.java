package _5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
You organize a sports league in a round-robin-system. Each team meets all other teams. In your league a win
gives a team 2 points, a draw gives both teams 1 point. After some games you have to compute the order of
the teams in your league. You use the following criteria to arrange the teams:
Points
Scoring differential (the difference between goals scored and those conceded)
Goals scored

First you sort the teams by their points. If two or more teams reached the same number of points,
the second criteria comes into play and so on. Finally, if all criteria are the same, the teams share a place.

Input
number: Number of teams in your league.
games: An array of arrays. Each item represents a played game with an array of four elements [TeamA,TeamB,GoalA,GoalB]
(TeamA played against TeamB and scored GoalA goals and conceded GoalB goals ).

Output
positions: An array of positions. The i-th item should be the position of the i-th team in your league.

Example
number = 6
games = [[0, 5, 2, 2],   // Team 0 - Team 5 => 2:2
         [1, 4, 0, 2],   // Team 1 - Team 4 => 0:2
         [2, 3, 1, 2],   // Team 2 - Team 3 => 1:2
         [1, 5, 2, 2],   // Team 1 - Team 5 => 2:2
         [2, 0, 1, 1],   // Team 2 - Team 0 => 1:1
         [3, 4, 1, 1],   // Team 3 - Team 4 => 1:1
         [2, 5, 0, 2],   // Team 2 - Team 5 => 0:2
         [3, 1, 1, 1],   // Team 3 - Team 1 => 1:1
         [4, 0, 2, 0]]   // Team 4 - Team 0 => 2:0

You may compute the following table:
  Rank	 Team	 For:Against	GD	Points
    1.	Team 4  	5 : 1   	+4    5
    2.	Team 5  	6 : 4   	+2    4
    3.	Team 3  	4 : 3   	+1    4
    4.	Team 0  	3 : 5   	-2    2
    4.	Team 1  	3 : 5   	-2    2
    6.	Team 2  	2 : 5   	-3    1
Team 5 and Team 3 reached the same number of points. But since Team 5 got a better scoring differential,
it ranks better than Team 3. All values of Team 0 and Team 1 are the same, so these teams share the fourth place.

In this example you have to return the array [4, 4, 6, 3, 1, 2].
 */
public class CW62_SportsLeagueTableRanking {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeRanks(6, new int[][]{
                {0, 5, 2, 2},
                {1, 4, 0, 2},
                {2, 3, 1, 2},
                {1, 5, 2, 2},
                {2, 0, 1, 1},
                {3, 4, 1, 1},
                {2, 5, 0, 2},
                {3, 1, 1, 1},
                {4, 0, 2, 0}
        }))); // [4, 4, 6, 3, 1, 2]
        System.out.println(Arrays.toString(computeRanks(6, new int[][]{
                {0, 5, 2, 0},
                {1, 4, 2, 2},
                {2, 3, 1, 3},
                {1, 5, 0, 0},
                {2, 0, 2, 1},
                {3, 4, 3, 1}
        }))); // [2, 3, 4, 1, 5, 6]
    }

    public static int[] computeRanks(int number, int[][] games) {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            teams.add(new Team(i));
        }

        for (int[] game : games) {
            updateScores(teams.get(game[0]), teams.get(game[1]), game[2], game[3]);
        }

        Collections.sort(teams);

        for (int i = 0; i < teams.size(); i++) {
            if (i > 0 && teams.get(i).compareTo(teams.get(i - 1)) == 0) {
                teams.get(i).rank = teams.get(i - 1).rank;
            } else {
                teams.get(i).rank = i + 1;
            }
        }

        int[] result = new int[number];
        for (Team team : teams) {
            result[team.name] = team.rank;
        }

        return result;
    }

    private static void updateScores(Team teamA, Team teamB, int goalsA, int goalsB) {
        teamA.goalsFor += goalsA;
        teamA.goalsAgainst += goalsB;
        teamB.goalsFor += goalsB;
        teamB.goalsAgainst += goalsA;

        if (goalsA > goalsB) {
            teamA.points += 2;
        } else if (goalsB > goalsA) {
            teamB.points += 2;
        } else {
            teamA.points += 1;
            teamB.points += 1;
        }

        teamA.gd += goalsA - goalsB;
        teamB.gd += goalsB - goalsA;
    }

}

class Team implements Comparable<Team> {
    int name;
    int goalsFor = 0;
    int goalsAgainst = 0;
    int gd = 0;
    int points = 0;
    int rank;

    public Team(int name) {
        this.name = name;
    }

    @Override
    public int compareTo(Team other) {
        if (other.points != this.points)
            return Integer.compare(other.points, this.points);

        if (other.gd != this.gd)
            return Integer.compare(other.gd, this.gd);

        return Integer.compare(other.goalsFor, this.goalsFor);
    }
}