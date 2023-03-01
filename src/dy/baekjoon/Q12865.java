package dy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q12865 {

    static int[] ch = new int[100001];

    static class Product implements Comparable<Product> {
        int w, v;

        public Product(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Product o) {
            if(this.w == o.w) return o.v - this.v;
            else return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            products.add(new Product(w, v));
        }

        Collections.sort(products);
        for (Product product : products) {
            int w = product.w;
            for(int i = K; i >= w; i--) {
                ch[i] = Math.max(ch[i], ch[i - w] + product.v);
            }
        }

        System.out.println(ch[K]);

    }
}