package zadacha6;

public class RabinKarp {
    private int M,R = 256;
    private int Q = 104729;
    private String pat;
    private long patHash,RM;

    private long hash(String key, int M){
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R*h + key.charAt(i) % Q);
        }
        return h;
    }
    public RabinKarp(String pat){
        this.pat = pat;
        this.M = pat.length();
        RM = 1;
        for (int i = 0; i <= M -1 ; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }
    private boolean check(int i){ return true;}
    public int search(String txt){
        int N = txt.length();
        long txtHash = hash(txt, M);
        if( patHash == txtHash) return 0;
        for (int i = M; i < N; i++) {
            txtHash
                     = (txtHash+ Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash
                    = (txtHash * R + txt.charAt(i)) % Q;
            if(patHash == txtHash)
                if (check(i-M+1))
                    return i-M+1;
        }
        return N;
    }



}
