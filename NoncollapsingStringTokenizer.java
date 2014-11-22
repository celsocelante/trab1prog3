    /**
     *  This is a replacement for the standard StringTokenizer which
     *  handles multiple delimiters differently.  Given the input 
     *  "A,B,,,E", a StringTokenizer would return three tokens: 
     *  "A", "B", and "E" (collapsing the repeated ",,," 
     *  into a single delimiter ",").  A NoncollapsingStringTokenizer 
     *  instead returns five tokens: "A", "B", "", "", "E".  
     *  The repeated delimiters are taken to indicate empty fields, 
     *  so an empty string "" is returned where appropriate.
     *
     *  Source: http://www.coderanch.com/u/290/Jim-Yingst
     *          http://www.coderanch.com/t/271313/java/java/StringTokenizer-null-fields
     */

    public class NoncollapsingStringTokenizer {
     
        private String str;
        private String[] delims;
        private int currentPosition;
     
        public NoncollapsingStringTokenizer(String str) {
            this(str, " \t\n\r\f");
        }
     
        public NoncollapsingStringTokenizer(String str, String delimStr) {
            this.str = str;
            delims = new String[delimStr.length()];
            for (int i = 0; i < delimStr.length(); i++) {
                delims[i] = delimStr.substring(i, i + 1);
            }
        }
     
        public String nextToken() {
            int nextDelimPosition = str.length();
            for (int i = 0; i < delims.length; i++) {
                int delimPosition = str.indexOf(delims[i], currentPosition);
                if (delimPosition >= 0 && delimPosition < nextDelimPosition) {
                    nextDelimPosition = delimPosition;
                }
            }
            String token = str.substring(currentPosition, nextDelimPosition);
            currentPosition = nextDelimPosition + 1;
            return token;
        }
     
        public boolean hasMoreTokens() {
            return (currentPosition < str.length());
        }
    }