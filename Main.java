import java.util.*;
import java.io.*;
/*
⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⣾⡳⣼⣆⠀⠀⢹⡄⠹⣷⣄⢠⠇⠻⣷⣶⢀⣸⣿⡾⡏⠀⠰⣿⣰⠏⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⣀⣀⣀⡹⣟⡪⢟⣷⠦⠬⣿⣦⣌⡙⠿⡆⠻⡌⠿⣦⣿⣿⣿⣿⣦⣿⡿⠟⠚⠉⠀⠉⠳⣄⡀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⡀⢀⣼⣟⠛⠛⠙⠛⠉⠻⢶⣮⢿⣯⡙⢶⡌⠲⢤⡑⠀⠈⠛⠟⢿⣿⠛⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣆⠀⠀⠀
⠀⠀⠀⠀⠀⡸⠯⣙⠛⢉⣉⣙⣿⣿⡳⢶⣦⣝⢿⣆⠉⠻⣄⠈⢆⢵⡈⠀⠀⢰⡆⠀⣼⠓⠀⠀⠀   Nah    ⠈⣷⠀⠀
⠀⠀⠀⠖⠉⠻⣟⡿⣿⣭⢽⣽⣶⣈⢛⣾⣿⣧⠀⠙⠓⠀⠑⢦⡀⠹⣧⢂⠀⣿⡇⢀⣿⠺⠇⠀    I'd⠀     ⣿⠀⠀
⠀⠀⠀⠀⠐⠈⠉⢛⣿⣿⣶⣤⣈⠉⣰⣗⡈⢛⣇⠀⣵⡀⠀⠘⣿⡄⢻⣤⠀⢻⡇⣼⣧⣿⡄⠀⠀   Win⠀    ⠀⡿⠀⠀
⠀⠀⠀⠀⠀⣠⣾⣿⢍⡉⠛⠻⣷⡆⠨⣿⣭⣤⣍⠀⢹⣷⡀⠀⠹⣿⡄⠈⠀⢿⠁⣿⣿⠏            ⠀⠀⠀⣇⠀⠀
⠀⣿⣇⣠⣾⣿⣛⣲⣿⠛⠀⠀⢀⣸⣿⣿⣟⣮⡻⣷⣤⡙⢟⡀⠀⠙⢧⠀⠀⠎⠀⠉⠁⠰⣿⠀⠀         ⠀⢀⡿⠀⠀
⠀⠈⢻⣿⣿⣽⣿⣿⣿⣴⡏⠚⢛⣈⣍⠛⠛⠿⢦⣌⢙⠻⡆⠁⠀⠀⠀⣴⣦⠀⠀⠀⠐⢳⢻⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠮⠀⠀⠀
⠀⠀⠈⠙⣿⣧⣶⣿⠿⣧⣴⣿⢻⡉⠀⢀⣠⣴⣾⡟⠿⠃⠁⣠⣤⡶⣾⡟⠅⠀⣀⡄⠀⣾⢸⣿⣏⢻⢶⣦⣤⣤⣄⢶⣾⣿⣡⣤⡄⠀
⠀⠀⣠⣞⣋⣿⣿⣾⣿⡿⡛⣹⡟⣤⢰⡿⠟⠉⣀⣀⣤⣤⡠⠙⢁⣾⡿⠂⠀⣿⠟⣁⠀⣹⠀⣹⣿⡟⣼⣿⣿⣌⣿⣞⣿⣿⠁⠀⠀⠀
⠀⢠⡿⢛⢟⣿⣿⣿⣿⣿⣿⡟⣼⣿⣟⢓⠛⣿⣏⣿⣵⣗⣵⣴⣿⢟⡵⣣⣼⣿⢟⣵⣶⢻⣶⣿⠀⠀⣈⢻⣿⣿⣿⢿⣾⢿⣧⠀⠀⠀
⠀⠘⠃⢸⣿⡾⣿⣿⣿⣿⣯⣿⣿⣿⣶⣿⣿⣟⣾⡿⣫⣿⣿⣿⣽⣿⣿⣿⣿⢫⣾⣿⣿⣿⣿⣿⣴⡆⣻⣿⡏⣿⢻⣧⣿⡿⣿⡆⠀⠀
⠀⠀⠀⠜⣿⣾⢿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣭⣿⣖⣿⢿⣿⡿⣿⣿⣿⡿⢡⢯⣿⣿⣿⣿⣿⣿⣿⣧⡿⣾⣷⣿⣿⢿⣿⡇⠉⠁⠀⠀
⠀⠀⠀⠀⣿⣥⣾⣿⣿⣿⣿⣿⣿⣿⡇⣭⣿⣿⣿⣿⠃⠞⠟⣸⣿⠏⣸⣧⣀⠿⢿⣿⣿⣟⣿⣿⣿⣿⣽⣿⢿⣿⣿⣿⣿⠁⠀⠀⠀⠀
⠀⠀⠀⠈⠛⣹⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣟⣿⣿⡿⢶⣦⣄⣿⠏⠀⣿⣟⣿⣶⠾⣿⣟⣋⣛⣿⣿⣿⣿⡇⣻⣿⣿⣿⡏⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠟⠛⠫⣿⣿⣿⣿⣿⡿⣧⠛⣿⠛⣿⣿⣿⣷⡌⠹⡟⠀⠀⠉⡟⠋⢠⣾⣿⣿⣿⡟⣿⣿⣿⣿⢀⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠘⠋⣾⣷⣿⣿⣧⠙⠀⠙⢣⠝⠛⠋⣽⣷⢦⠇⠀⠀⠘⠁⣤⣾⣿⠝⠛⠉⠘⢻⣿⣿⢿⣼⣷⡟⢻⣷⠉⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠐⠟⢻⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠈⠛⠀⠀⠀⠀⠀⣾⠟⠀⢸⣷⣿⡇⠀⠛⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠁⠀⢹⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⡧⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠈⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⢻⡿⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣇⠀⠀⠀⠀⠀⠀⠀⠀⠲⣄⠀⡄⠆⠀⠀⠀⠀⠀⠀⠀⠀⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⣀⠀⠀⣠⣾⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⢻⣆⠀⠛⠁⠶⣶⣶⣶⣶⣶⣶⡶⠆⠘⠋⣠⡾⢫⣾⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠛⠀⠙⣷⡀⠀⠀⠙⠛⠛⠛⠛⠋⠁⠀⢀⣴⠋⠀⣾⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣿⣰⣦⡀⠸⣿⣦⡀⠀⠀⠀⠀⠀⠀⢀⣴⡟⠁⠀⠐⢻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⡄⢺⣿⡄⠹⣿⠻⢦⣤⣤⣤⣤⣶⣿⡟⢀⣀⠀⠀⢸⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣮⣿⣿⡀⠹⡷⣦⣀⡀⡀⢸⣿⠏⢠⣾⣿⠀⠀⣾⣿⣿⣿⣿⣶⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀
⣀⣤⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠘⣷⣻⡟⠀⡼⠁⣴⣿⣿⣯⣥⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣀⠀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣯⣿⣤⣤⣤⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣄
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
*/

/*Write you code here -------- */
public class Main {
    public static void main(String args[]) throws IOException {
        MyTemplate.FastIO jio = new MyTemplate().new FastIO();
        int n = jio.nextInt();
        jio.close();
    }
}


/*end here-------------------- */
class MyTemplate {
    class Calc{
        public static ArrayList<Integer> generatePrimes(int n) {
            // Create an array to track prime status
            boolean[] isPrime = new boolean[n + 1];
            ArrayList<Integer> primes = new ArrayList<>();
    
            // Initialize all numbers as prime
            for (int i = 2; i <= n; i++) {
                isPrime[i] = true;
            }
    
            // Sieve of Eratosthenes algorithm
            for (int p = 2; p * p <= n; p++) {
                if (isPrime[p]) {
                    // Mark all multiples of p as non-prime
                    for (int multiple = p * p; multiple <= n; multiple += p) {
                        isPrime[multiple] = false;
                    }
                }
            }
    
            // Collect all prime numbers
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
            }
    
            return primes;
        }
            
        public static long GCD(long a,long b){
            if(a<b){
                long temp=a;
                a=b;
                b=temp;
            }
            if(b==0){
                return a;
            }
            return GCD(b,a%b);
        }
        public static int GCD(int a,int b){
            if(a<b){
                int temp=a;
                a=b;
                b=temp;
            }
            if(b==0){
                return a;
            }
            return GCD(b,a%b);
        }
        public static void swap(int a,int b){
            int temp=a;
            a=b;
            b=temp;
        }
        public static void swap(long a,long b){
            long temp=a;
            a=b;
            b=temp;
        }
    }

    class FastIO {
        private BufferedReader br;
        private BufferedWriter bw;
        private StringTokenizer st;

        // Constructor to initialize input and output
        public FastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        // Method to read next line
        public String nextLine() throws IOException {
            return br.readLine();
        }

        // Method to read next token
        public String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        // Method to read an integer
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        // Method to read a long
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        // Method to read a double
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        // Method to read an integer array
        public int[] readIntArray(int size) throws IOException {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        // Method to read a long array
        public long[] readLongArray(int size) throws IOException {
            long[] arr = new long[size];
            for (int i = 0; i < size; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        // Method to print a string without a newline
        public void print(String str) throws IOException {
            bw.write(str);
            bw.flush();
        }

        // Method to print a string followed by a newline
        public void println(String str) throws IOException {
            bw.write(str + "\n");
            bw.flush();
        }

        // Method to print an integer followed by a newline
        public void println(int num) throws IOException {
            bw.write(num + "\n");
            bw.flush();
        }

        // Method to print a long followed by a newline
        public void println(long num) throws IOException {
            bw.write(num + "\n");
            bw.flush();
        }

        // Method to print an integer array
        public void printArray(int[] arr) throws IOException {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + (i == arr.length - 1 ? "" : " "));
            }
            bw.write("\n");
            bw.flush();
        }

        // Method to print a long array
        public void printArray(long[] arr) throws IOException {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + (i == arr.length - 1 ? "" : " "));
            }
            bw.write("\n");
            bw.flush();
        }

        // Flush the output stream
        public void flush() throws IOException {
            bw.flush();
        }

        // Close input and output streams
        public void close() throws IOException {
            br.close();
            bw.close();
        }
    }
}

/*

⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣬⢧⣬⡒⠀⠀⠀⢀⣠⠝⠉⠉⠉⠉⠁⠀⠸⠟⠙⠹⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣈⡹⠒⠚⠁⣠⠞⣉⠀⢀⡴⠚⠉⠁⡀⠀⠀⠀⠀⠀⠀⠉⠙⠲⠶⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⡤⠴⠞⠁⠀⠀⢀⢞⡡⠊⠁⡰⢋⣠⣶⠖⠋⠁⠀⠠⡄⠀⠀⠀⠀⠀⠀⢠⡀⣀⣉⠭⠿⠟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢯⣍⡻⠭⠭⠤⠄⣀⠴⠂⠀⣰⠟⠉⠀⣠⡾⠛⢩⣷⠃⠀⠀⠀⠀⠀⢱⠀⡆⡀⣠⠀⠀⠘⢿⠮⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⣛⡿⣣⢯⠄⡴⢫⡅⠀⢀⡴⠃⠀⠀⣾⠇⠀⠀⢸⠀⠀⠀⠸⡄⡇⡇⣿⡇⠀⠀⠈⢷⡄⠙⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⣰⠟⣡⢞⡵⠋⠀⢠⠎⠀⡤⠀⢠⡟⠀⠀⠀⡇⢠⠀⡀⠀⣷⣷⣧⢿⡗⢲⡀⠀⢸⡿⡄⠀⠙⢾⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⢴⣚⣡⠞⠞⠁⣾⠵⠋⢀⢆⣴⠏⣠⠊⢀⣠⡼⠀⠀⠀⠀⡷⠘⣷⡇⢰⣿⣿⣳⡼⣧⠸⣷⠀⠀⠇⠙⢦⡀⠈⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠁⣼⠃⣠⡾⠉⠀⠀⢀⡿⠋⣸⠞⢁⡠⠋⠁⠀⠀⠀⠀⣴⠃⣸⣿⡃⢸⣱⡸⢻⣿⣿⣿⣿⢸⠀⢤⠀⢀⠙⢦⡀⠹⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⡷⣾⣿⠃⠀⡄⢀⡜⠁⠐⡧⠴⠊⠀⠀⠀⢀⠀⢠⠖⠛⢠⣿⡏⡇⣸⣿⣿⣾⣿⣿⣿⣿⣸⡄⠈⣦⠈⣧⠠⣷⡦⣝⡟⠦⣄⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡿⠟⢰⣿⠃⠀⣼⢠⡟⡀⠀⠀⡇⢀⡇⢰⠀⢀⡎⢠⡏⠀⡤⢸⣿⡇⣧⠿⣯⣿⣿⣿⣿⣿⣿⣷⣷⢀⡈⢧⣹⢦⡙⢷⡀⠉⠙⠛⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠤⠒⠃⠀⣰⢟⣥⠃⢠⣧⡟⣰⡇⠀⠀⢀⡞⣰⣧⠀⡜⣰⢻⠃⢸⣸⠈⢻⣳⣇⡿⣿⠘⢿⣿⣼⣿⣏⣿⣿⡇⠟⣦⡉⢳⡘⠓⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣞⣵⣟⠁⢀⣾⢿⡹⣹⠀⢠⢀⠞⣰⣻⠃⣰⡷⠃⣸⡆⡏⡿⠀⢸⠉⢹⡇⣿⣿⣼⣿⡿⣿⣿⣼⣹⡀⢠⣿⣿⠸⡗⢶⣶⣯⡿⠶⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢀⣴⠿⠋⣞⡼⢀⡞⢹⣿⡇⣿⠀⡟⣏⡼⣱⣯⡶⠿⠁⡄⢹⣿⢧⠃⠀⢸⠀⣼⡏⢙⣿⠻⣿⣷⣽⣿⣿⡻⡇⢸⢯⡇⣷⡿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⣰⡿⣣⣿⠀⣼⣿⣿⡟⢸⢀⣿⠱⢋⡟⠀⢀⠆⡇⣼⡏⠸⢠⠃⢻⣴⣿⠁⢸⣿⠀⣿⢻⣿⢿⡍⡛⣇⣾⣦⣷⡈⢿⠯⢷⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣯⡟⢩⡟⣰⠟⢦⣯⣇⣼⣿⡇⠀⣿⡇⠀⣼⣿⢳⠀⡇⡀⣾⢰⣼⣿⣿⣀⣿⣿⡄⣿⣿⣿⠀⡇⣅⣿⣵⠇⣿⣿⣮⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀
⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠛⠀⢸⣵⢻⣄⣆⣿⣿⣿⣿⡇⢀⣿⡇⢠⣻⢹⣾⣰⢷⢷⣿⢸⣿⣿⣻⣿⡿⠿⣿⣿⠾⡏⢰⠃⣿⡿⡟⢿⣏⣻⡈⠙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠇⢸⣿⣾⣷⣻⣏⣿⣇⣼⡿⡇⣸⣿⣾⣷⣿⣩⣿⣯⡿⢡⣿⣿⣿⣿⣿⣿⣯⣄⣹⡟⣤⣿⣾⢀⣾⠏⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠁⠀⢸⣿⠻⣏⡟⣿⣿⣿⣿⣡⣿⣿⣿⣿⣿⣿⣿⣿⣿⡓⠃⢘⣿⠟⣿⣭⢳⠉⠹⠿⢠⣿⡏⣹⣿⣿⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠾⠃⠀⠙⣦⣻⣿⠿⠙⡿⢿⣿⣽⠋⢯⣿⡏⠀⠻⠃⣤⣻⢏⣀⠛⠟⢋⣤⠗⣠⡄⣿⡴⠋⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⣿⠲⠀⠀⠘⠋⠛⠀⠈⠿⠁⠀⠀⠀⠐⠌⠓⠛⣿⠿⡿⠓⠀⠉⢠⣟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢻⣟⡭⠁⠀⢀⣾⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⡌⢷⡀⢤⡄⠀⠀⠀⠀⠳⣄⢀⡤⠀⠀⠀⠀⠀⣿⣷⠀⢀⣼⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣾⣿⣿⣿⣿⣿⣿⣿⡇⠀⢿⣄⠋⠲⢶⣤⣀⣀⣤⣤⣶⣶⣶⣶⣶⠖⠋⠀⣠⠞⢹⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠛⢦⡀⡓⠿⣿⣟⣻⡿⢖⣚⣿⠟⠁⢀⣴⠞⠁⠀⣾⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠀⠘⡎⣿⣷⣤⡈⠛⠛⠻⠛⠛⠉⢁⣴⣿⠋⠐⣠⣾⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⢁⠘⣿⢷⣤⣀⣀⠀⣀⣠⣿⠿⡻⣡⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡖⠘⠦⢼⣟⠸⠛⢻⣻⣽⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣻⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⣬⠽⣷⣶⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⠀⠀⠀⠀⠀⠀
⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣋⣀⣿⠏⠰⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⠀⠀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡬⣿⣿⢯⣷⣶⠝⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡘⠛⢤⣀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣷⣶⢿⣷⣶⢤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠉
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢿⣒⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣀⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢧⣴⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢛⣩⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶
⣿⣿⣿⣿⣿⣿⣿⣦⣭⣉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣮⣿⡖⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⠿⠿⠿⢿⣿⣿⠿⢿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣭⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⠿⠟⢛⣥⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣟⢿⣿⣿⣿⣿⣿
*/



