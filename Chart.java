package BabyProductsRental;

import java.util.ArrayList;

public class Chart {

	public static void main(String[] args) {
		// 데이터베이스의 값을 가져옴(현재는 임의의 값)
				// ArrayList<Integer> arr = new ArrayList<Integer>();
				String[] sArr = { "위생용품", "이동용품", "침구용품", "세정용품", "장난감", "유아식기", "목욕용품", "아동복", "전자기기" };
				int[] arr = { 70, 30, 25, 105, 92, 12, 34, 79, 60 };
				// 정렬 전
				System.out.println("--------정렬 전--------");
				System.out.println(print(sArr));
				System.out.println(print(arr));
				System.out.println("--------정렬 후--------");

				// 인덱스 정렬 전 문자열 정렬해주기... 문자열 정렬 먼저 하면 문자열이 변하지 않아요 ^^...
				sArr = selectSort(arr, sArr);
				arr = selectSort(arr);

				System.out.println(print(sArr));
				System.out.println(print(arr));
				// 퍼센트로 전환
				System.out.println("-------퍼센트 전환------");
				float[] dArr = percentArray(arr);
				System.out.println(print(dArr));
				System.out.println(sum_arr(dArr));

			}

			public static int[] selectSort(int[] arr) {
				// 정수 배열을 선택 정렬하여 리턴해주는 함수
				for (int i = 0; i < arr.length; i++) {
					int maxIndex = i;
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[maxIndex] < arr[j]) {
							maxIndex = j;
						}
					}
					int temp = arr[maxIndex];
					arr[maxIndex] = arr[i];
					arr[i] = temp;
				}
				return arr;
			}

			public static String[] selectSort(int[] arr, String[] sArr) {
				// 인덱스 배열을 정렬하며 동시에 스트링 타입의 이름 배열을 선택 정렬하여 리턴해주는 함수
				for (int i = 0; i < arr.length; i++) {
					int maxIndex = i;
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[maxIndex] < arr[j]) {
							maxIndex = j;
						}
					}
					int temp = arr[maxIndex];
					arr[maxIndex] = arr[i];
					arr[i] = temp;

					String temp2 = sArr[maxIndex];
					sArr[maxIndex] = sArr[i];
					sArr[i] = temp2;
				}
				return sArr;
			}

			public static String print(int[] arr) {
				// 정수 배열의 모든 값을 한 개의 문자열로 표현하는 함수(오버로딩)
				String s = "";
				for (int i : arr) {
					s += i + " " + "";
				}
				return s;
			}

			public static String print(float[] arr) {
				// 실수 배열의 모든 값을 한 개의 문자열로 표현하는 함수
				String s = "";
				for (float i : arr) {
					s += i + " " + "";
				}
				return s;
			}

			public static String print(String[] sArr) {
				// 문자열 배열의 모든 값을 한 개의 문자열로 표현하는 함수(오버로딩)
				String s = "";
				for (String i : sArr) {
					s += i + " " + "";
				}
				return s;
			}

			public static int sum_arr(int[] arr) {
				// 정수 배열의 모든 값을 더하여 출력하는 함수
				int sum = 0;
				for (int i : arr) {
					sum += i;
				}
				return sum;
			}

			public static float sum_arr(float[] arr) {
				// 정수 배열의 모든 값을 더하여 출력하는 함수
				float sum = 0;
				for (float i : arr) {
					sum += i;
				}
				return sum;
			}

			public static float avg_arr(int[] arr) {
				// 정수 배열의 모든 값의 평균을 구하여 실수로 출력하는 함수
				float avg = (float) sum_arr(arr) / arr.length;
				return avg;
			}

			public static float[] percentArray(int[] arr) {
				// 정수 배열의 모든 값을 퍼센트로 전환하여 실수 배열로 출력하는 함수
				int sum = sum_arr(arr);
				float[] dArr = new float[arr.length];
				for (int i = 0; i < arr.length; i++) {
					dArr[i] = (float) arr[i] / sum * 100;
				}
				return dArr;

			}

			public static int[] percentIntArray(int[] arr) {
				// 정수 배열의 모든 값을 퍼센트로 전환하여 실수 배열로 출력하는 함수
				int sum = sum_arr(arr);
				int[] iArr = new int[arr.length];
				for (int i = 0; i < arr.length; i++) {
					iArr[i] = (int) (arr[i] / sum * 100);
				}
				return iArr;

			}

			public static int[] floatToIntArry(float[] fArr) {
				int[] arr = new int[fArr.length];
				for (int i = 0; i < fArr.length; i++) {
					arr[i] = (int) Math.round(fArr[i]);
				}
				return arr;
			}

			public static int[] StringToIntArray(String[] sArr) {
				//스트링 배열을 int배열로 만들어주는 메소드
				//인트 배열 = StringToIntArray(인트로 바꿀 스트링 배열)
				int[] arr = new int[sArr.length];
				for (int i = 0; i < sArr.length; i++) {
					arr[i] = Integer.parseInt(sArr[i]);
				}
				return arr;
			}
			
			public static String[] IntToStringArray(int[] arr) {
				//int 배열을 String 배열로 바꿔주는 메소드
				String[] sArr = new String[arr.length];
				for (int i = 0; i < arr.length; i++) {
					sArr[i] = Integer.toString(arr[i]);
				}
				return sArr;
			}

	}


