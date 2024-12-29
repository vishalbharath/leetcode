// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

int firstBadVersion(int n) {
    long int x=1;
    long int mid;
    while(x<n){
        mid=(x+n)/2;
        if(isBadVersion(mid) == true){
            n=mid;
        }
        else{
            x=mid+1;
        }
    }
    return x;
    
}
