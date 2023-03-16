package string;

public class BoyerMoore {

    static int bm(String text, String searchText) {
        int pt; // text 커서
        int textLen = text.length();
        int searchTextLen = searchText.length();
        
        int[] skip = new int[Character.MAX_VALUE + 1];

        // a - z 초기화
        for(pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = searchTextLen;
        }

        // 검색 문자의 건너뛸 인덱스 계산
        for(pt = 0; pt <= searchTextLen - 1; pt++) {
            skip[searchText.charAt(pt)] = searchTextLen - pt - 1;
        }

        int pst; // 검색 텍스트 커서
        while(pt < textLen) {
            pst = searchTextLen - 1; // 검색 텍스트의 마지막 문자

            while(text.charAt(pt) == searchText.charAt(pst)) {
                if(pst == 0) return pt; // 검색 성공
                pt--;
                pst--;
            }

            pt += (skip[text.charAt(pt)] > searchTextLen - pst) ? skip[text.charAt(pt)] : searchTextLen - pst;
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABABCDEFGHA";
        String search = "ABC";
        System.out.println(bm(text, search) + 1 + "인덱스부터 일치합니다.");

    }
}
