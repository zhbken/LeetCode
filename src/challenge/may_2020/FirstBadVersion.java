package challenge.may_2020;

public class FirstBadVersion {

	public int firstBadVersion(int n) {
		int lo = 0, hi = n, mid = -1;
		while (lo <= hi) {
			if (lo == hi) {
				break;
			}
			mid = lo + (hi - lo) / 2;
			boolean badVersion = isBadVersion(mid);
			if (badVersion) {
				hi = mid;
			} else if (lo +1 == hi) {
				return isBadVersion(hi) ? hi : lo;
			} else {
				lo = mid;
			}
		}
		return mid;
	}

	// test case, let 5 be initial bad version
	private boolean isBadVersion(int version) {
		return 5 <= version;
	}
}
