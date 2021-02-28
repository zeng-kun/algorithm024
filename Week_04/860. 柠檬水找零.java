class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i = 0;i<bills.length;i++){
            if(bills[i] == 5){
                //如果是5元的就不用找
                five++;
            }else if(bills[i] == 10){
                //如果是10元的话，找零5元
                five--;
                ten++;
            }else if(ten>0){
                //如果是20元，找零两种方式，3个5元或者1个10元，1个5元；
                //如果有10元的，优先从10元的开始找
                ten--;
                five--;
            }else {
                five -=3;
            }
            if(five<0){
                return false;
            }
        }
        return true;
    }

}