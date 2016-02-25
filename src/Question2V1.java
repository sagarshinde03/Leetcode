import java.math.BigInteger;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Question2V1 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1=new BigInteger("0"),num2=new BigInteger("0");
        int multiplier=0;
        while(l1!=null){
            BigInteger bg1=new BigInteger(String.valueOf((int)Math.pow(10,multiplier)));
            BigInteger bg2=new BigInteger(String.valueOf(l1.val));
            BigInteger bg3=bg1.multiply(bg2);
            num1=num1.add(bg3);
            l1=l1.next;
            multiplier++;
        }
        multiplier=0;
        while(l2!=null){
            BigInteger bg1=new BigInteger(String.valueOf((int)Math.pow(10,multiplier)));
            BigInteger bg2=new BigInteger(String.valueOf(l2.val));
            BigInteger bg3=bg1.multiply(bg2);
            num2=num2.add(bg3);
            l2=l2.next;
            multiplier++;
        }
        BigInteger num=num1.add(num2);
        ListNode l=new ListNode(0);
        ListNode lBackup=l;
        int res=num.compareTo(new BigInteger("0"));
        if(res==0) return l;
        while(res!=0){
            l.next=new ListNode(num.mod(new BigInteger("10")).intValue());
            num=num.divide(new BigInteger("10"));
            //num/=10;
            res=num.compareTo(new BigInteger("0"));
            l=l.next;
        }
        return lBackup.next;
    }
}
