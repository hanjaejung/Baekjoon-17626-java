package org.example.studyTwoDays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * dp 알고리즘
 * 재귀적 호출은 주로 하향식(top-down) 접근 방식을 사용합니다. 즉, 큰 문제를 작은 하위 문제로 나누어 해결하는 방식입니다.
 * 반면에 동적 계획법은 주로 상향식(bottom-up) 접근 방식을 사용합니다.
 * 작은 하위 문제들부터 시작하여 그 결과를 저장하고, 이를 이용하여 점진적으로 큰 문제의 해를 구해나갑니다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1; //1의 제곱근은 이미 구해져 있다

        int min = 0;
        for (int i = 2; i <= N; i++) { // 현재 제곱근을 구할 수
            min = Integer.MAX_VALUE;

            // i에서 i보다 작은 제곱수에서 뺀 dp[i - j * j] 중
            // 최소를 택한다.
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j; //1부터 시작해서 제곱 후 구하려는 수를 뺸다
                //for문으로 계속 증가시키는 이유는 최소값을 찾기 위해서
                // 예를들어 4일 경우
                //1부터 시작 1의 제곱근에서 4를 뺴면 바로 전수인 3의 제곱근 개수를 볼수 있다 1의 제곱근 1개 3의 제곱근 3개
                //2부터 시작 2의 제곱근은 4 4 빼기 4는 0이므로 이게 최소

                //9의 경우 1의 제곱근인 1를 빼면 8
                //2의 제곱근인 4를 빼면 5
                //3의 제곱근인 9를 뺴면 0

                //즉 위와 같은식으로 1부터 숫자를 올리면서 제곱근을 하면 최소 제곱근 숫자를 구할수 있다
                //System.out.println("i : " + i+ ", j : " + j);
                //System.out.println("min : " + min);
                //System.out.println("temp : " + temp);
                min = Math.min(min, dp[temp]);

            }

            dp[i] = min + 1; // 그리고 1을 더해준다. 1을 더해주는 이유는 j * j의 제곱근을 for문에서 빼버려서 다시 더해주기 위해
            //System.out.println("*********************************i : " + i);
            //System.out.println("*********************************min : " + (min+1));
        }

        System.out.println(dp[N]);
    }
}
