
public class NO85_MaximalRectangleTest {
	public static void main(String[] args) {
		//
		char[][] matrix = { { '1', '0', '1', '0', '0' }, 
							{ '1', '0', '1', '1', '1' }, 
							{ '1', '1', '1', '1', '1' },
							{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalRectangle(matrix));
		//
	}

	public static int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			return 0;
		}
		int cols = matrix[0].length;

		int maxArea = 0;
		int[] areas = new int[cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				areas[col] = matrix[row][col] == '0' ? 0 : areas[col] + 1;
			}
			maxArea = Math.max(maxArea, largestRectangleArea(areas));
		}
		return maxArea;
	}

	public static int largestRectangleArea(int[] heights) {
		int max = 0;

		int left, right, temp;
		for (int i = 0; i < heights.length; i++) {
			left = i - 1;
			right = i + 1;

			while (left >= 0 && heights[i] <= heights[left])
				left--;
			while (right < heights.length && heights[i] <= heights[right])
				right++;

			temp = heights[i] * (right - left - 1);

			max = Math.max(max, temp);
		}

		return max;
	}
}
