class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;

        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>();
        int n=wordList.size();
        for(int i=0;i<n;i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String w=q.peek().word;
            int l=q.peek().level;

            q.remove();
            if(w.equals(endWord)==true) return l;
            for(int i=0;i<w.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char replace[]=w.toCharArray();
                    replace[i]=ch;
                    String replaceWord=new String(replace);
                    if(set.contains(replaceWord)==true){
                        set.remove(replaceWord);
                        q.add(new Pair(replaceWord, l+1));
                    }
                }
            }

        }
        return 0;
    }

    class Pair{
        String word;
        int level;
        Pair(String w, int l){
            word=w;
            level=l;
        }
    }
}
