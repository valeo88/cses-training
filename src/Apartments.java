import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * There are n applicants and m free apartments.
 * Your task is to distribute the apartments so that as many applicants as possible will get an apartment.
 *
 * Each applicant has a desired apartment size,
 * and they will accept any apartment whose size is close enough to the desired size.
 *
 * Input
 *
 * The first input line has three integers n, m, and k: the number of applicants,
 * the number of apartments, and the maximum allowed difference.
 *
 * The next line contains n integers a1,a2,…,an: the desired apartment size of each applicant.
 * If the desired size of an applicant is x, he or she will accept any apartment whose size is between x−k and x+k.
 *
 * The last line contains m integers b1,b2,…,bm: the size of each apartment.
 *
 * Output
 *
 * Print one integer: the number of applicants who will get an apartment.
 * */
public class Apartments {

    static Random rand = new Random();
    static void shuffle(long[] aa, int n) {
        for (int i = 1; i < n; i++) {
            int j = rand.nextInt(i + 1);
            long tmp = aa[i]; aa[i] = aa[j]; aa[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        shuffle(a, n);
        shuffle(b, m);
        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;

        for (int i = 0, j = 0; i < n && j < m; ) {
            if (a[i] >= b[j] - k && a[i] <= b[j] + k) {
                cnt++;
                i++;
                j++;
            } else if (a[i] < b[j] - k) {
                i++;
            }
            else {
                j++;
            }
        }

        pw.println(cnt);
        pw.flush();

    }

    // use binary search modification
    static int getLowerBoundIdx(long[] b, long key) {
        int start = 0;
        int end = b.length - 1;
        while (true) {
            int mid = start + (end - start) / 2;
            if (b[mid] >= key) {
                end = mid - 1;
                if (start > end) {
                    return mid;
                }
            } else {
                start = mid + 1;
                if(start > end){
                    return mid < b.length-1 ? mid+1 : -1;
                }
            }
        }
    }

    /* working c++ solution
    *
    * #include<bits/stdc++.h>
using namespace std;
typedef long long ll;

bool apart(ll *des, ll *siz, ll i, ll j, ll k)
{
	if(siz[j]<=(des[i]+k)&&siz[j]>=(des[i]-k))
		return true;
	else
		return false;
}

int main(){
	ll n,m,k,i,j;
	cin>>n>>m>>k;
	ll des[n]; des[0]=0;//desired size
	ll siz[m]; siz[0]=0;//size of app
	ll num=0;

	for(ll i=1;i<=n;i++){cin>>des[i];}//1 indexing
	for(ll i=1;i<=m;i++){cin>>siz[i];}//1 indexing
	sort(des,des+n+1);
	sort(siz,siz+m+1);

	i=1; //Set i=1 initially
	for(ll j=1;j<=m;j++){		//Iterate for size
		for(;i<=m;i++){		//Iterate for desired keeps checking next
			if(apart(des,siz,i,j,k)==true){
				num++;			//Accept if in range
				i++;			//Increment deired
				break;
				}
			else{
				if(siz[j]<des[i]-k)	//If size not reachable
					break;
				else
					continue;		//Increment desired
			}
		}
	}

	cout<<num;
}
    *
    * */

}
