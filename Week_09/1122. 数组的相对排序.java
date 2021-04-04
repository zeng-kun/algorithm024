//方法一：
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num1 : arr1) {
            count[num1]++;
        }
        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }
        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }
}

//方法二
class Solution {
    Map<Integer, Integer> record;
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        Collections.sort(res, (num1, num2) -> {
            if (record.containsKey(num1) || record.containsKey(num2)) {
                return record.getOrDefault(num1, 1000) - record.getOrDefault(num2, 1000);
            } else {
                return num1 - num2;
            }
        });
        return res.stream().mapToInt(i -> i).toArray();
    }
}

//方法三
class Solution {
    Map<Integer, Integer> record;
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        quickSort(arr1, 0, arr1.length - 1);
        return arr1;
    }
    public void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }
    public int partition(int[] arr, int lo, int hi) {
        int temp = arr[hi];
        int j = lo;
        for (int i = lo; i < hi; i++) {
            if (less(arr[i], temp)) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j, hi);
        return j;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public boolean less(int num1, int num2) {
        if (record.containsKey(num1) && record.containsKey(num2)) {
            return record.get(num1) < record.get(num2);
        } else if (record.containsKey(num1)) {
            return true;
        } else if (record.containsKey(num2)) {
            return false;
        } else {
            return num1 < num2;
        }
    }
}
