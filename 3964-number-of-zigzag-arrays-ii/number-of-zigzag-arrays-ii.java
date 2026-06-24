class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        if (n == 1) return m % MOD;

        long[][] T = buildTransitionMatrix(m, size);
        long[][] Tn = matPow(T, n - 1, size);

        long ans = 0;
        for (int start = 0; start < size; start++) {
            for (int end = 0; end < size; end++) {
                ans = (ans + Tn[end][start]) % MOD;
            }
        }

        return (int) ans;
    }

    private long[][] buildTransitionMatrix(int m, int size) {
        long[][] T = new long[size][size];

        for (int xi = 0; xi < m; xi++) {
            // From DOWN(xi): next must go down → yi < xi → land in UP(yi)
            for (int yi = 0; yi < xi; yi++) {
                T[m + yi][xi] = 1;
            }

            // From UP(xi): next must go up → yi > xi → land in DOWN(yi)
            for (int yi = xi + 1; yi < m; yi++) {
                T[yi][m + xi] = 1;
            }
        }

        return T;
    }

    private long[][] matMul(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;  // skip zero rows — saves time
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[][] matPow(long[][] M, int p, int size) {
        // Start with identity matrix
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1;

        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, M, size);
            M = matMul(M, M, size);
            p >>= 1;
        }

        return result;
    }
}