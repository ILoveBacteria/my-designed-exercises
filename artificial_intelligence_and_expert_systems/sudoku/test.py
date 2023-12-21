import ast
import os
import signal
import json

import sudoku


RuntimeError_ = False
TimeoutError_ = False
MAX_TIME = 5


def signal_handler(signum, frame):
    raise TimeoutError("Timed out!")


def tester(board: list[list], n) -> bool:
    if len(board) != n:
        return False
    for i in range(len(board)):
        if len(board[i]) != n:
            return False
        for j in range(len(board)):
            if board[i][j] > len(board) or board[i][j] <= 0:
                return False
    for row in board:
        if len(set(row)) != len(row):
            return False
    for i in range(len(board)):
        col = [row[i] for row in board]
        if len(set(col)) != len(col):
            return False
    return True


def exception_handing(board: list[list], none_pass) -> bool:
    global RuntimeError_, TimeoutError_
    try:
        signal.signal(signal.SIGALRM, signal_handler)
        signal.alarm(MAX_TIME)
        try:
            n = len(board)
            result = sudoku.solver(board)
            if result is None and none_pass:
                return True
            if tester(result, n):
                return True

        except TimeoutError:
            TimeoutError_ = True

    except Exception as e:
        RuntimeError_ = True

    finally:
        signal.alarm(0)  # Disable the alarm regardless of the outcome
    return False


def read_boards_from_file(path) -> dict:
    test_boards = {}
    dir_list = os.listdir(path)
    for filename in dir_list:
        with open(os.path.join(path, filename), 'r') as file:
            content = file.read()

        board = ast.literal_eval(content)
        test_boards[filename] = board
    return test_boards


def create_cases_statuses(board_size: int, pass_test: bool) -> dict:
    global RuntimeError_,  TimeoutError_
    case_map = {'board': f'{board_size}x{board_size} Sudoku'}
    if RuntimeError_:
        case_map['status'] = 'runtimeError'
        RuntimeError_ = False
    elif TimeoutError_:
        case_map['status'] = 'timeLimit'
        TimeoutError_ = False
    elif pass_test:
        case_map['status'] = 'success'
    else:
        case_map['status'] = 'wrongAnswer'

    return case_map


def main():
    test_boards = read_boards_from_file(path='tests')
    final_result = {
        'correct': False,
        'score': 0,
        'data': [],
        'cases': [],
    }
    
    num_of_passing_cases = 0
    for filename, board in test_boards.items():
        none_pass = False
        if filename == 'input7.txt':
            none_pass = True
        res = exception_handing(board, none_pass)
        if res:
            num_of_passing_cases += 1
        case_map = create_cases_statuses(len(board), res)
        final_result['cases'].append(case_map)

    final_result['score'] = int((num_of_passing_cases / len(test_boards)) * 100)
    if final_result['score'] >= 100:
        final_result['correct'] = True

    print(json.dumps(final_result))


main()
