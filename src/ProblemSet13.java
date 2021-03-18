public class ProblemSet13 {

    public boolean groupSum(int start, int[] numbers, int target) {
        if (target == 0) return true;
        if (start == numbers.length) return false;

        if (groupSum(start + 1, numbers, target - numbers[start])) return true;
        return groupSum(start + 1, numbers, target);
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        if (target == 0) return true;
        if (start == numbers.length) return false;

        if (numbers[start] == 6) return groupSum6(start + 1, numbers, target - numbers[start]);
        if (groupSum6(start + 1, numbers, target - numbers[start])) return true;
        return groupSum6(start + 1, numbers, target);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if (target == 0) return true;
        if (start >= numbers.length) return false;

        if (groupNoAdj(start + 2, numbers, target - numbers[start])) return true;
        return groupNoAdj(start + 1, numbers, target);
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if (target == 0) return true;
        if (start == numbers.length) return false;

        if (numbers[start] % 5 == 0) {
            if (numbers[start + 1] == 1) {
                return groupSum5(start + 2, numbers, target - numbers[start]);
            } else {
                return groupSum5(start + 1, numbers, target - numbers[start]);
            }
        }
        if (groupSum5(start + 1, numbers, target - numbers[start])) return true;
        return groupSum5(start + 1, numbers, target);
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if (target == 0) return true;
        if (start == numbers.length) return false;

        int i = start + 1;
        for(int x = start + 1; x < numbers.length; x++) {
            if (numbers[start] == numbers[x]) {
                i++;
            }
        }
        if (groupSumClump(i, numbers, target - ((i - start) * numbers[start]))) return true;
        return groupSumClump(i, numbers, target);
    }

    public boolean splitArray(int[] numbers) {
        if (numbers.length == 0) return true;
        return sidesAreEqual(numbers, 0, 0);
    }

    public boolean sidesAreEqual(int[] numbers, int i, int balance) {
        if (i == numbers.length) return balance == 0;
        if(sidesAreEqual(numbers, i + 1, balance + numbers[i])) return true;
        return sidesAreEqual(numbers, i + 1, balance - numbers[i]);
    }

    public boolean splitOdd(int[] numbers) {
        if (numbers.length == 0) return true;
        return sidesAreEqualOdd(numbers, 0, 0, 0);
    }

    public boolean sidesAreEqualOdd(int[] numbers, int i, int group1, int group2) {
        if (i == numbers.length) return ((group1 % 2 == 1 && group2 % 10 == 0) || (group2 % 2 == 1 && group1 % 10 == 0));;
        if(sidesAreEqualOdd(numbers, i + 1, group1 + numbers[i], group2)) return true;
        return sidesAreEqualOdd(numbers, i + 1, group1, group2 + numbers[i]);
    }
}