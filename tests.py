#! /usr/bin/python3

import sys

from subprocess import Popen, PIPE, DEVNULL
from difflib import Differ


OK = '\033[1;92mOK\033[0m'
FAIL = '\033[1;91mFAIL\033[0m'
ERROR = '\033[1;93mABORTED\033[0m'


def test(filename):
    print(filename + ' ...   ', end='')
    if filename[-4:] != '.mcs':
        print(ERROR + '\n >> files must end with .mcs')
    else:
        if 'wrong' in filename:
            compile_wrong(filename)
        else:
            compile_right(filename)


def compile(filename):
    cmd = ['./mcsc', filename]
    err = ''
    with Popen(cmd, stdout=DEVNULL, stderr=PIPE) as p:
        berr = p.communicate()[1]
        err = berr.decode('utf-8')

    if not err:
        print(ERROR)
    return err


def compile_right(filename):
    err = compile(filename)
    if 'Error' in err:
        print(FAIL + '\n >> Error during compilation.')
        print(err)
    else:
        try:
            filename_expected = filename[:-4] + '.expected'
            filename_obtained = filename[:-4] + '.tam'
            with open(filename_expected, 'r') as file_expected:
                expected = file_expected.read()
            with open(filename_obtained, 'r') as file_obtained:
                obtained = file_obtained.read()
            diff = compare(expected, obtained)
            if diff:
                print(FAIL + '\n >> Does not match what was expected.')
                print(diff)
            else:
                print(OK)
        except Exception as e:
            print(ERROR)
            print(e)


def compile_wrong(filename):
    err = compile(filename)
    if 'Error' in err:
        print(OK)
    else:
        print(FAIL + '\n >> This test should return an error.')


def compare(expected, obtained):
    expected = clean(expected)
    obtained = clean(obtained)
    if expected == obtained:
        return ''
    else:
        d = Differ()
        diff = d.compare(expected, obtained)
        return ''.join(diff)


def clean(tam):
    codelines = [line.split(';')[0].strip() for line in tam.split('\n')]
    return [line + '\n' for line in codelines if line]


if __name__ == '__main__':
    for filename in sys.argv[1:]:
        test(filename)
