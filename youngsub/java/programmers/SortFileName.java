import java.util.*;

public class SortFileName {
    static class FileName {
        String head, number, tail;

        public FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    public String[] solution(String[] files) {
        List<FileName> list = new ArrayList<>();

        for (String file : files) {
            // HEAD 부분 추출
            int i = 0;
            while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                i++;
            }
            String head = file.substring(0, i);

            // NUMBER 부분 추출
            int numStart = i;
            while (i < file.length() && Character.isDigit(file.charAt(i))) {
                i++;
            }
            String number = file.substring(numStart, i);

            // TAIL 부분 추출
            String tail = "";
            if (i < file.length()) {
                tail = file.substring(i);
            }

            list.add(new FileName(head, number, tail));
        }

        list.sort((o1, o2) -> {
            String head1 = o1.head.toLowerCase();
            String head2 = o2.head.toLowerCase();
            if (!head1.equals(head2)) {
                return head1.compareTo(head2);
            }

            int number1 = Integer.parseInt(o1.number);
            int number2 = Integer.parseInt(o2.number);
            if (number1 != number2) {
                return Integer.compare(number1, number2);
            }

            return 0;
        });


        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).head + list.get(i).number + list.get(i).tail;
        }
        return answer;
    }
}