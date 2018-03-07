import java.util.*;

public class Test {
    enum Answer {
        A, B, C, D
    }

    static int sCount = 0;
    static int[] sSize = {
            (int) Math.pow(4, 9),
            (int) Math.pow(4, 8),
            (int) Math.pow(4, 7),
            (int) Math.pow(4, 6),
            (int) Math.pow(4, 5),
            (int) Math.pow(4, 4),
            (int) Math.pow(4, 3),
            (int) Math.pow(4, 2),
            (int) Math.pow(4, 1),
            (int) Math.pow(4, 0)
    };

    static List<Answer> sAnswers = new ArrayList<>();

    public static void genAnswers() {
        sAnswers.clear();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                sAnswers.add(getAnswerIndex(sCount / sSize[i]));
            } else {
                sAnswers.add(getAnswerIndex((sCount % sSize[i - 1]) / sSize[i]));
            }
        }
        sCount++;
    }

    private static Answer getAnswerIndex(int ordinal) {
        switch (ordinal) {
            case 0: {
                return Answer.A;
            }
            case 1: {
                return Answer.B;
            }
            case 2: {
                return Answer.C;
            }
            default: {
                return Answer.D;
            }
        }
    }

    public static boolean judge(int index) {
        Answer answer = sAnswers.get(index);
        boolean res;
        switch (index) {
            case 0: {
                res = true;
                break;
            }
            case 1: {
                switch (answer) {
                    case A: {
                        res = sAnswers.get(5 - 1) == Answer.C;
                        break;
                    }
                    case B: {
                        res = sAnswers.get(5 - 1) == Answer.D;
                        break;
                    }
                    case C: {
                        res = sAnswers.get(5 - 1) == Answer.A;
                        break;
                    }
                    case D: {
                        res = sAnswers.get(5 - 1) == Answer.B;
                        break;
                    }
                    default:
                        res = false;
                }
                break;
            }
            case 2: {
                Answer a = sAnswers.get(3 - 1);
                Answer b = sAnswers.get(6 - 1);
                Answer c = sAnswers.get(2 - 1);
                Answer d = sAnswers.get(4 - 1);

                switch (answer) {
                    case A: {
                        res = a != b && a != c && a != d;
                        break;
                    }
                    case B: {
                        res = b != a && b != c && b != d;
                        break;
                    }
                    case C: {
                        res = c != a && c != b && c != d;
                        break;
                    }
                    case D: {
                        res = d != a && d != b && d != c;
                        break;
                    }
                    default:
                        res = false;
                }

                break;
            }
            case 3: {
                switch (answer) {
                    case A: {
                        res = sAnswers.get(1 - 1) == sAnswers.get(5 - 1);
                        break;
                    }
                    case B: {
                        res = sAnswers.get(2 - 1) == sAnswers.get(7 - 1);
                        break;
                    }
                    case C: {
                        res = sAnswers.get(1 - 1) == sAnswers.get(9 - 1);
                        break;
                    }
                    case D: {
                        res = sAnswers.get(6 - 1) == sAnswers.get(10 - 1);
                        break;
                    }
                    default:
                        res = false;
                }
                break;
            }
            case 4: {
                int i;
                switch (answer) {
                    case A: {
                        i = 8;
                        break;
                    }
                    case B: {
                        i = 4;
                        break;
                    }
                    case C: {
                        i = 9;
                        break;
                    }
                    case D:
                    default: {
                        i = 7;
                    }
                }
                res = answer == sAnswers.get(i - 1);
                break;
            }
            case 5: {
                switch (answer) {
                    case A: {
                        res = sAnswers.get(2 - 1) == sAnswers.get(8 - 1) && sAnswers.get(4 - 1) == sAnswers.get(8 - 1);
                        break;
                    }
                    case B: {
                        res = sAnswers.get(1 - 1) == sAnswers.get(8 - 1) && sAnswers.get(6 - 1) == sAnswers.get(8 - 1);
                        break;
                    }
                    case C: {
                        res = sAnswers.get(3 - 1) == sAnswers.get(8 - 1) && sAnswers.get(10 - 1) == sAnswers.get(8 - 1);
                        break;
                    }
                    case D: {
                        res = sAnswers.get(5 - 1) == sAnswers.get(8 - 1) && sAnswers.get(9 - 1) == sAnswers.get(8 - 1);
                        break;
                    }
                    default:
                        res = false;
                }
                break;
            }
            case 6: {
                Map<Answer, Integer> times = new HashMap<>();
                times.put(Answer.A, 0);
                times.put(Answer.B, 0);
                times.put(Answer.C, 0);
                times.put(Answer.D, 0);
                for (Answer a : sAnswers) {
                    int t = times.get(a);
                    times.put(a, ++t);
                }
                Answer answerMin = Answer.A;
                int t = times.get(Answer.A);
                if (t > times.get(Answer.B)) {
                    answerMin = Answer.B;
                    t = times.get(Answer.B);
                }
                if (t > times.get(Answer.C)) {
                    answerMin = Answer.C;
                    t = times.get(Answer.C);
                }
                if (t > times.get(Answer.D)) {
                    answerMin = Answer.D;
                    t = times.get(Answer.D);
                }

                Answer answerThis;
                switch (answer) {
                    case A: {
                        answerThis = Answer.C;
                        break;
                    }
                    case B: {
                        answerThis = Answer.B;
                        break;
                    }
                    case C: {
                        answerThis = Answer.A;
                        break;
                    }
                    case D:
                    default: {
                        answerThis = Answer.D;
                    }
                }
                res = answerThis == answerMin;
                break;
            }
            case 7: {
                Answer answer1 = sAnswers.get(1 - 1);
                switch (answer) {
                    case A: {
                        res = Math.abs(answer1.ordinal() - sAnswers.get(7 - 1).ordinal()) > 1;
                        break;
                    }
                    case B: {
                        res = Math.abs(answer1.ordinal() - sAnswers.get(5 - 1).ordinal()) > 1;
                        break;
                    }
                    case C: {
                        res = Math.abs(answer1.ordinal() - sAnswers.get(2 - 1).ordinal()) > 1;
                        break;
                    }
                    case D: {
                        res = Math.abs(answer1.ordinal() - sAnswers.get(10 - 1).ordinal()) > 1;
                        break;
                    }
                    default:
                        res = false;
                }
                break;
            }
            case 8: {
                boolean b1 = sAnswers.get(1 - 1) == sAnswers.get(6 - 1);
                boolean b2;
                switch (answer) {
                    case A: {
                        b2 = sAnswers.get(6 - 1) == sAnswers.get(5 - 1);
                        break;
                    }
                    case B: {
                        b2 = sAnswers.get(10 - 1) == sAnswers.get(5 - 1);
                        break;
                    }
                    case C: {
                        b2 = sAnswers.get(2 - 1) == sAnswers.get(5 - 1);
                        break;
                    }
                    case D:
                    default: {
                        b2 = sAnswers.get(9 - 1) == sAnswers.get(5 - 1);
                    }
                }
                res = (b1 && !b2) || (!b1 && b2);
                break;
            }
            case 9: {
                Map<Answer, Integer> times = new HashMap<>();
                times.put(Answer.A, 0);
                times.put(Answer.B, 0);
                times.put(Answer.C, 0);
                times.put(Answer.D, 0);
                for (Answer a : sAnswers) {
                    int t = times.get(a);
                    times.put(a, ++t);
                }
                Answer answerMin = Answer.A;
                Answer answerMax = Answer.A;
                if (times.get(Answer.B) > times.get(answerMax)) {
                    answerMax = Answer.B;
                }
                if (times.get(Answer.B) < times.get(answerMin)) {
                    answerMin = Answer.B;
                }

                if (times.get(Answer.C) > times.get(answerMax)) {
                    answerMax = Answer.C;
                }
                if (times.get(Answer.C) < times.get(answerMin)) {
                    answerMin = Answer.C;
                }

                if (times.get(Answer.D) > times.get(answerMax)) {
                    answerMax = Answer.D;
                }
                if (times.get(Answer.D) < times.get(answerMin)) {
                    answerMin = Answer.D;
                }
                int timesDiff = Math.abs(times.get(answerMax) - times.get(answerMin));
                switch (answer) {
                    case A: {
                        res = timesDiff == 3;
                        break;
                    }
                    case B: {
                        res = timesDiff == 2;
                        break;
                    }
                    case C: {
                        res = timesDiff == 4;
                        break;
                    }
                    case D:
                    default: {
                        res = timesDiff == 1;
                    }
                }
                break;
            }
            default:
                res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        A:
        while (true) {
            genAnswers();
            for (int i = 0; i < sAnswers.size(); i++) {
                if (!judge(i)) {
                    break;
                }
                if (i == sAnswers.size() - 1) {
                    break A;
                }
            }
        }

        System.out.println(sAnswers);
    }
}
