class Solution { 

		public List<List<String>> solveNQueens(int n) {
			List<List<String>> result = new ArrayList<>();
			char[][] board = new char[n][n];
			init(board);
			helper(result, board, 0); // recursive
			return result;

		}

		private void init(char[][] board) {
			for (char[] row : board) {
				Arrays.fill(row, '.');

			}

		}

		private void helper(List<List<String>> result, char[][] board, int rowIndex) {

			// 終止條件, 找到全部解
			if (rowIndex == board.length) {
				result.add(generate(board));
				return;

			}

			for (int colIndex = 0; colIndex < board.length; colIndex++) {
				if (isValid(board, rowIndex, colIndex)) {
					board[rowIndex][colIndex] = 'Q';
					helper(result, board, rowIndex + 1);
					board[rowIndex][colIndex] = '.';

				}

			}

		}

		private List<String> generate(char[][] board) {
			List<String> list = new ArrayList<String>();
			for (char[] row : board) {
				StringBuilder sb = new StringBuilder();
				for (char c : row) {
					sb.append(c);
				}
				list.add(sb.toString());

			}
			return list;

		}

		private boolean isValid(char[][] board, int rowIndex, int colIndex) {

			for (int i = rowIndex - 1; i >= 0; i--) {
				int left = colIndex - (rowIndex - i);
				int right = colIndex + (rowIndex - i);
				// 上方
				if (board[i][colIndex] == 'Q')
					return false;
				//左上
				else if (left >= 0 && board[i][left] == 'Q')
					return false;
				//右上
				else if (right < board.length && board[i][right] == 'Q')
					return false;

			}
			
			return true;
		}

	}